package com.restaurant.ventas.adapters.persistence;

import com.restaurant.ventas.domain.model.EstadoCocina;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "items_pedido")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String itemInstanciaId;
    private String recetaId;
    private String nombre;
    
    @Enumerated(EnumType.STRING)
    private EstadoCocina estadoCocina;
    
    private Integer cantidad;
    private String comentario;
    private String mesaOrigen;
}
