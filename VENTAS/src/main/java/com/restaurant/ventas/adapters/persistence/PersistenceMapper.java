package com.restaurant.ventas.adapters.persistence;

import com.restaurant.ventas.domain.model.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PersistenceMapper {

    public VentaEntity toEntity(Venta domain) {
        if (domain == null) return null;
        
        return VentaEntity.builder()
                .ordenId(domain.getOrdenId())
                .vendedorId(domain.getVendedor().getId())
                .vendedorNombre(domain.getVendedor().getNombre())
                .mesaNumero(domain.getMesa().getNumeroActual())
                .mesaUbicacion(domain.getMesa().getUbicacion())
                .mesaComensales(domain.getMesa().getComensales())
                .mesaHoraApertura(domain.getMesa().getHoraApertura())
                .clienteId(domain.getCliente().getId())
                .clienteNombre(domain.getCliente().getNombre())
                .clienteEsConsumidorFinal(domain.getCliente().getEsConsumidorFinal())
                .clienteDescuentoNombre(domain.getCliente().getDescuentoAplicado() != null ? domain.getCliente().getDescuentoAplicado().getNombre() : null)
                .clienteDescuentoPorcentaje(domain.getCliente().getDescuentoAplicado() != null ? domain.getCliente().getDescuentoAplicado().getPorcentaje() : null)
                .itemsPedido(domain.getItemsPedido().stream().map(this::toItemEntity).collect(Collectors.toList()))
                .subtotalBruto(domain.getTotales().getSubtotalBruto())
                .valorDescuento(domain.getTotales().getValorDescuento())
                .totalAPagar(domain.getTotales().getTotalAPagar())
                .estadoOrden(domain.getEstadoOrden())
                .fechaCreacion(domain.getFechaCreacion())
                .build();
    }

    public Venta toDomain(VentaEntity entity) {
        if (entity == null) return null;

        return Venta.builder()
                .ordenId(entity.getOrdenId())
                .vendedor(Vendedor.builder().id(entity.getVendedorId()).nombre(entity.getVendedorNombre()).build())
                .mesa(Mesa.builder().numeroActual(entity.getMesaNumero()).ubicacion(entity.getMesaUbicacion()).comensales(entity.getMesaComensales()).horaApertura(entity.getMesaHoraApertura()).build())
                .cliente(Cliente.builder()
                        .id(entity.getClienteId())
                        .nombre(entity.getClienteNombre())
                        .esConsumidorFinal(entity.getClienteEsConsumidorFinal())
                        .descuentoAplicado(entity.getClienteDescuentoNombre() != null ? 
                                Descuento.builder().nombre(entity.getClienteDescuentoNombre()).porcentaje(entity.getClienteDescuentoPorcentaje()).build() : null)
                        .build())
                .itemsPedido(entity.getItemsPedido().stream().map(this::toItemDomain).collect(Collectors.toList()))
                .totales(Totales.builder()
                        .subtotalBruto(entity.getSubtotalBruto())
                        .valorDescuento(entity.getValorDescuento())
                        .totalAPagar(entity.getTotalAPagar())
                        .build())
                .estadoOrden(entity.getEstadoOrden())
                .fechaCreacion(entity.getFechaCreacion())
                .build();
    }

    private ItemPedidoEntity toItemEntity(ItemPedido domain) {
        return ItemPedidoEntity.builder()
                .itemInstanciaId(domain.getItemInstanciaId())
                .recetaId(domain.getRecetaId())
                .nombre(domain.getNombre())
                .estadoCocina(domain.getEstadoCocina())
                .cantidad(domain.getCantidad())
                .comentario(domain.getComentario())
                .mesaOrigen(domain.getMesaOrigen())
                .build();
    }

    private ItemPedido toItemDomain(ItemPedidoEntity entity) {
        return ItemPedido.builder()
                .itemInstanciaId(entity.getItemInstanciaId())
                .recetaId(entity.getRecetaId())
                .nombre(entity.getNombre())
                .estadoCocina(entity.getEstadoCocina())
                .cantidad(entity.getCantidad())
                .comentario(entity.getComentario())
                .mesaOrigen(entity.getMesaOrigen())
                .build();
    }
}
