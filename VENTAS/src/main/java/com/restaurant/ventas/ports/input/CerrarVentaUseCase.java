package com.restaurant.ventas.ports.input;

import com.restaurant.ventas.domain.model.Venta;

public interface CerrarVentaUseCase {
    Venta cerrarVenta(String ordenId);
}
