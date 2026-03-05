package com.restaurant.ventas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.restaurant.ventas.domain.model.EstadoOrden;
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
public class VentaResponse {
    @JsonProperty("orden_id")
    private String ordenId;
    
    private VendedorDto vendedor;
    private MesaDto mesa;
    private ClienteDto cliente;
    
    @JsonProperty("items_pedido")
    private List<ItemPedidoDto> itemsPedido;
    
    private TotalesDto totales;
    
    @JsonProperty("estado_orden")
    private EstadoOrden estadoOrden;
    
    @JsonProperty("fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VendedorDto {
        private String id;
        private String nombre;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MesaDto {
        @JsonProperty("numero_actual")
        private String numeroActual;
        private String ubicacion;
        private Integer comensales;
        @JsonProperty("hora_apertura")
        private LocalDateTime horaApertura;
        @JsonProperty("tiempo_activo_minutos")
        private Integer tiempoActivoMinutos;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ClienteDto {
        @JsonProperty("es_consumidor_final")
        private Boolean esConsumidorFinal;
        private String id;
        private String nombre;
        @JsonProperty("descuento_aplicado")
        private DescuentoDto descuentoAplicado;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DescuentoDto {
        private String nombre;
        private Double porcentaje;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ItemPedidoDto {
        @JsonProperty("item_instancia_id")
        private String itemInstanciaId;
        @JsonProperty("id_receta")
        private String recetaId;
        private String nombre;
        @JsonProperty("estado_cocina")
        private String estadoCocina;
        private Integer cantidad;
        private String comentario;
        @JsonProperty("mesa_origen")
        private String mesaOrigen;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TotalesDto {
        @JsonProperty("subtotal_bruto")
        private Double subtotalBruto;
        @JsonProperty("valor_descuento")
        private Double valorDescuento;
        @JsonProperty("total_a_pagar")
        private Double totalAPagar;
    }
}
