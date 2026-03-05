package com.restaurant.ventas.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {
    private String itemInstanciaId;
    private String recetaId;
    private String nombre;
    private EstadoCocina estadoCocina;
    private Integer cantidad;
    private String comentario;
    private String mesaOrigen;
}
