package com.restaurant.ventas.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Totales {
    private BigDecimal subtotalBruto;
    private BigDecimal valorDescuento;
    private BigDecimal totalAPagar;
}
