package com.restaurant.ventas.ports.output;

import com.restaurant.ventas.domain.model.Venta;
import java.util.List;
import java.util.Optional;

public interface VentaRepositoryPort {
    Venta guardar(Venta venta);
    Optional<Venta> obtenerPorId(String ordenId);
    List<Venta> listarActivas();
    boolean existeOrdenActivaEnMesa(String numeroMesa);
}
