package com.restaurant.ventas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CambioEstadoItemRequest {
    @NotBlank(message = "El ID de la orden es obligatorio")
    @JsonProperty("orden_id")
    private String ordenId;
    
    @NotBlank(message = "El ID de la instancia del item es obligatorio")
    @JsonProperty("item_instancia_id")
    private String itemInstanciaId;
    
    @NotBlank(message = "El nuevo estado es obligatorio")
    @JsonProperty("nuevo_estado")
    private String nuevoEstado;
    
    @JsonProperty("hora_finalizacion")
    private LocalDateTime horaFinalizacion;
}
