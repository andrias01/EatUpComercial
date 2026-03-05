package com.restaurant.ventas.ports.input;

import com.restaurant.ventas.domain.model.ItemPedido;
import com.restaurant.ventas.domain.model.Venta;

public interface AgregarItemUseCase {
    Venta agregarItem(String ordenId, ItemPedido item);
}
