package com.restaurant.ventas.ports.output;

import com.restaurant.ventas.domain.model.ItemPedido;
import java.math.BigDecimal;
import java.util.Optional;

public interface RecetaServicePort {
    Optional<BigDecimal> obtenerPrecioReceta(String recetaId);
    Optional<String> obtenerNombreReceta(String recetaId);
}
