package com.restaurant.ventas.adapters.persistence;

import com.restaurant.ventas.domain.model.EstadoOrden;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ventas")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VentaEntity {
    @Id
    private String ordenId;
    
    // Datos del vendedor
    private String vendedorId;
    private String vendedorNombre;
    
    // Datos de la mesa
    private String mesaNumero;
    private String mesaUbicacion;
    private Integer mesaComensales;
    private LocalDateTime mesaHoraApertura;
    
    // Datos del cliente
    private String clienteId;
    private String clienteNombre;
    private Boolean clienteEsConsumidorFinal;
    private String clienteDescuentoNombre;
    private BigDecimal clienteDescuentoPorcentaje;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "orden_id")
    private List<ItemPedidoEntity> itemsPedido;
    
    // Totales
    private BigDecimal subtotalBruto;
    private BigDecimal valorDescuento;
    private BigDecimal totalAPagar;
    
    @Enumerated(EnumType.STRING)
    private EstadoOrden estadoOrden;
    
    private LocalDateTime fechaCreacion;
}
