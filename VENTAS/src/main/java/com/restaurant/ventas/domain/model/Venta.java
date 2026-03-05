package com.restaurant.ventas.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    private String ordenId;
    private Vendedor vendedor;
    private Mesa mesa;
    private Cliente cliente;
    private List<ItemPedido> itemsPedido;
    private Totales totales;
    private EstadoOrden estadoOrden;
    private LocalDateTime fechaCreacion;
}
