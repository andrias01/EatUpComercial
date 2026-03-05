package com.restaurant.ventas.ports.input;

import com.restaurant.ventas.domain.model.Venta;

public interface ConsultarVentaUseCase {
    Venta obtenerVentaPorId(String ordenId);
}
