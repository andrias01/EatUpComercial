package com.restaurant.ventas.application.service;

import com.restaurant.ventas.domain.model.*;
import com.restaurant.ventas.ports.input.*;
import com.restaurant.ventas.ports.output.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VentaService implements 
    CrearVentaUseCase, 
    ConsultarVentaUseCase, 
    AgregarItemUseCase, 
    CambiarEstadoItemUseCase, 
    CerrarVentaUseCase,
    ListarOrdenesActivasUseCase {

    private final VentaRepositoryPort ventaRepository;
    private final ClienteServicePort clienteService;
    private final MesaServicePort mesaService;
    private final RecetaServicePort recetaService;
    private final DescuentoServicePort descuentoService;
    private final VendedorServicePort vendedorService;

    @Override
    @Transactional
    public Venta crearVenta(Venta ventaInput) {
        // 1. Validar vendedor
        Vendedor vendedor = vendedorService.obtenerVendedor(ventaInput.getVendedor().getId())
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));
        
        // 2. Validar mesa y que no esté ocupada
        Mesa mesa = mesaService.obtenerMesa(ventaInput.getMesa().getNumeroActual())
                .orElseThrow(() -> new RuntimeException("Mesa no encontrada"));
        
        if (ventaRepository.existeOrdenActivaEnMesa(mesa.getNumeroActual())) {
            throw new RuntimeException("La mesa ya tiene una orden activa");
        }

        // 3. Validar cliente
        Cliente cliente = clienteService.obtenerCliente(ventaInput.getCliente().getId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // 4. Aplicar descuento automático si existe
        descuentoService.obtenerDescuentoActivo(cliente.getId())
                .ifPresent(cliente::setDescuentoAplicado);

        // 5. Validar y enriquecer items
        List<ItemPedido> itemsEnriquecidos = new ArrayList<>();
        for (ItemPedido item : ventaInput.getItemsPedido()) {
            String nombreReceta = recetaService.obtenerNombreReceta(item.getRecetaId())
                    .orElseThrow(() -> new RuntimeException("Receta no encontrada: " + item.getRecetaId()));
            
            item.setItemInstanciaId("ITEM-" + UUID.randomUUID().toString().substring(0, 8));
            item.setNombre(nombreReceta);
            item.setEstadoCocina(EstadoCocina.PENDIENTE);
            item.setMesaOrigen(mesa.getNumeroActual());
            itemsEnriquecidos.add(item);
        }

        // 6. Calcular totales iniciales
        Totales totales = calcularTotales(itemsEnriquecidos, cliente.getDescuentoAplicado());

        // 7. Construir y guardar venta
        Venta nuevaVenta = Venta.builder()
                .ordenId("ORD-" + LocalDateTime.now().getYear() + "-" + UUID.randomUUID().toString().substring(0, 4).toUpperCase())
                .vendedor(vendedor)
                .mesa(mesa)
                .cliente(cliente)
                .itemsPedido(itemsEnriquecidos)
                .totales(totales)
                .estadoOrden(EstadoOrden.ABIERTA)
                .fechaCreacion(LocalDateTime.now())
                .build();

        return ventaRepository.guardar(nuevaVenta);
    }

    @Override
    public Venta obtenerVentaPorId(String ordenId) {
        return ventaRepository.obtenerPorId(ordenId)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada: " + ordenId));
    }

    @Override
    @Transactional
    public Venta agregarItem(String ordenId, ItemPedido nuevoItem) {
        Venta venta = obtenerVentaPorId(ordenId);
        
        if (venta.getEstadoOrden() != EstadoOrden.ABIERTA) {
            throw new RuntimeException("No se pueden agregar items a una orden cerrada o cancelada");
        }

        String nombreReceta = recetaService.obtenerNombreReceta(nuevoItem.getRecetaId())
                .orElseThrow(() -> new RuntimeException("Receta no encontrada"));

        nuevoItem.setItemInstanciaId("ITEM-" + UUID.randomUUID().toString().substring(0, 8));
        nuevoItem.setNombre(nombreReceta);
        nuevoItem.setEstadoCocina(EstadoCocina.PENDIENTE);
        nuevoItem.setMesaOrigen(venta.getMesa().getNumeroActual());

        venta.getItemsPedido().add(nuevoItem);
        venta.setTotales(calcularTotales(venta.getItemsPedido(), venta.getCliente().getDescuentoAplicado()));

        return ventaRepository.guardar(venta);
    }

    @Override
    @Transactional
    public Venta cambiarEstadoItem(String ordenId, String itemInstanciaId, EstadoCocina nuevoEstado) {
        Venta venta = obtenerVentaPorId(ordenId);
        
        ItemPedido item = venta.getItemsPedido().stream()
                .filter(i -> i.getItemInstanciaId().equals(itemInstanciaId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item no encontrado en la orden"));

        item.setEstadoCocina(nuevoEstado);
        
        return ventaRepository.guardar(venta);
    }

    @Override
    @Transactional
    public Venta cerrarVenta(String ordenId) {
        Venta venta = obtenerVentaPorId(ordenId);
        
        if (venta.getEstadoOrden() != EstadoOrden.ABIERTA) {
            throw new RuntimeException("La orden ya está cerrada o cancelada");
        }

        // 1. Recalcular totales por si acaso
        venta.setTotales(calcularTotales(venta.getItemsPedido(), venta.getCliente().getDescuentoAplicado()));
        
        // 2. Cambiar estado
        venta.setEstadoOrden(EstadoOrden.CERRADA);
        
        // 3. Liberar mesa
        mesaService.liberarMesa(venta.getMesa().getNumeroActual());
        
        // 4. Actualizar histórico del cliente
        clienteService.actualizarHistorico(venta.getCliente().getId(), venta.getOrdenId());

        return ventaRepository.guardar(venta);
    }

    @Override
    public List<Venta> listarOrdenesActivas() {
        return ventaRepository.listarActivas();
    }

    private Totales calcularTotales(List<ItemPedido> items, Descuento descuento) {
        BigDecimal subtotal = BigDecimal.ZERO;
        
        for (ItemPedido item : items) {
            BigDecimal precio = recetaService.obtenerPrecioReceta(item.getRecetaId())
                    .orElse(BigDecimal.ZERO);
            subtotal = subtotal.add(precio.multiply(new BigDecimal(item.getCantidad())));
        }

        BigDecimal valorDescuento = BigDecimal.ZERO;
        if (descuento != null && descuento.getPorcentaje() != null) {
            valorDescuento = subtotal.multiply(descuento.getPorcentaje().divide(new BigDecimal(100)));
        }

        BigDecimal total = subtotal.subtract(valorDescuento);

        return Totales.builder()
                .subtotalBruto(subtotal)
                .valorDescuento(valorDescuento)
                .totalAPagar(total)
                .build();
    }
}
