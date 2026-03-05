package com.restaurant.ventas.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mesa {
    private String numeroActual;
    private String ubicacion;
    private Integer comensales;
    private LocalDateTime horaApertura;
    private Integer tiempoActivoMinutos;
}
