package com.restaurant.ventas.ports.input;

import com.restaurant.ventas.domain.model.EstadoCocina;
import com.restaurant.ventas.domain.model.Venta;

public interface CambiarEstadoItemUseCase {
    Venta cambiarEstadoItem(String ordenId, String itemInstanciaId, EstadoCocina nuevoEstado);
}
