package com.restaurant.ventas.ports.output;

import com.restaurant.ventas.domain.model.Descuento;
import java.util.Optional;

public interface DescuentoServicePort {
    Optional<Descuento> obtenerDescuentoActivo(String clienteId);
}
