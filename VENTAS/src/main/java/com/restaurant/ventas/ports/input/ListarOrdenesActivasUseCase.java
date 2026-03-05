package com.restaurant.ventas.ports.input;

import com.restaurant.ventas.domain.model.Venta;
import java.util.List;

public interface ListarOrdenesActivasUseCase {
    List<Venta> listarOrdenesActivas();
}
