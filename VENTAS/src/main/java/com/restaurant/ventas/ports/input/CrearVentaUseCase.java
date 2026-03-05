package com.restaurant.ventas.ports.input;

import com.restaurant.ventas.domain.model.Venta;

public interface CrearVentaUseCase {
    Venta crearVenta(Venta venta);
}
