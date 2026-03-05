package com.restaurant.ventas.ports.output;

import com.restaurant.ventas.domain.model.Vendedor;
import java.util.Optional;

public interface VendedorServicePort {
    Optional<Vendedor> obtenerVendedor(String id);
}
