package com.restaurant.ventas.ports.output;

import com.restaurant.ventas.domain.model.Mesa;
import java.util.Optional;

public interface MesaServicePort {
    Optional<Mesa> obtenerMesa(String numeroMesa);
    void liberarMesa(String numeroMesa);
}
