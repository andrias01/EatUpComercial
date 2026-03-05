package com.restaurant.ventas.controller;

import com.restaurant.ventas.domain.model.EstadoCocina;
import com.restaurant.ventas.domain.model.ItemPedido;
import com.restaurant.ventas.domain.model.Venta;
import com.restaurant.ventas.domain.model.Cliente;
import com.restaurant.ventas.domain.model.Mesa;
import com.restaurant.ventas.domain.model.Vendedor;
import com.restaurant.ventas.dto.*;
import com.restaurant.ventas.mapper.VentaMapper;
import com.restaurant.ventas.ports.input.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ventas")
@RequiredArgsConstructor
public class VentaController {

    private final CrearVentaUseCase crearVentaUseCase;
    private final ConsultarVentaUseCase consultarVentaUseCase;
    private final AgregarItemUseCase agregarItemUseCase;
    private final CambiarEstadoItemUseCase cambiarEstadoItemUseCase;
    private final CerrarVentaUseCase cerrarVentaUseCase;
    private final ListarOrdenesActivasUseCase listarOrdenesActivasUseCase;
    private final VentaMapper ventaMapper;

    @PostMapping
    public ResponseEntity<VentaResponse> crearVenta(@Valid @RequestBody CreateVentaRequest request) {
        Venta domain = Venta.builder()
                .vendedor(Vendedor.builder().id(request.getVendedorId()).build())
                .mesa(Mesa.builder().numeroActual(request.getNumeroMesa()).build())
                .cliente(Cliente.builder().id(request.getClienteId()).build())
                .itemsPedido(request.getItems().stream()
                        .map(item -> ItemPedido.builder()
                                .recetaId(item.getRecetaId())
                                .cantidad(item.getCantidad())
                                .comentario(item.getComentario())
                                .build())
                        .collect(Collectors.toList()))
                .build();
        
        Venta created = crearVentaUseCase.crearVenta(domain);
        return new ResponseEntity<>(ventaMapper.toResponse(created), HttpStatus.CREATED);
    }

    @GetMapping("/{ordenId}")
    public ResponseEntity<VentaResponse> consultarVenta(@PathVariable String ordenId) {
        Venta venta = consultarVentaUseCase.obtenerVentaPorId(ordenId);
        return ResponseEntity.ok(ventaMapper.toResponse(venta));
    }

    @PostMapping("/{ordenId}/items")
    public ResponseEntity<VentaResponse> agregarItem(@PathVariable String ordenId, @Valid @RequestBody ItemPedidoRequest request) {
        ItemPedido item = ItemPedido.builder()
                .recetaId(request.getRecetaId())
                .cantidad(request.getCantidad())
                .comentario(request.getComentario())
                .build();
        
        Venta updated = agregarItemUseCase.agregarItem(ordenId, item);
        return ResponseEntity.ok(ventaMapper.toResponse(updated));
    }

    @PatchMapping("/item/estado")
    public ResponseEntity<VentaResponse> cambiarEstadoItem(@Valid @RequestBody CambioEstadoItemRequest request) {
        EstadoCocina nuevoEstado;
        try {
            nuevoEstado = EstadoCocina.valueOf(request.getNuevoEstado().toUpperCase().replace(" ", "_"));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Estado de cocina inválido: " + request.getNuevoEstado());
        }
        
        Venta updated = cambiarEstadoItemUseCase.cambiarEstadoItem(request.getOrdenId(), request.getItemInstanciaId(), nuevoEstado);
        return ResponseEntity.ok(ventaMapper.toResponse(updated));
    }

    @GetMapping("/mesas/activas")
    public ResponseEntity<List<VentaResponse>> listarOrdenesActivas() {
        List<Venta> activas = listarOrdenesActivasUseCase.listarOrdenesActivas();
        return ResponseEntity.ok(activas.stream().map(ventaMapper::toResponse).collect(Collectors.toList()));
    }

    @PatchMapping("/{ordenId}/cerrar")
    public ResponseEntity<VentaResponse> cerrarVenta(@PathVariable String ordenId) {
        Venta closed = cerrarVentaUseCase.cerrarVenta(ordenId);
        return ResponseEntity.ok(ventaMapper.toResponse(closed));
    }
}
