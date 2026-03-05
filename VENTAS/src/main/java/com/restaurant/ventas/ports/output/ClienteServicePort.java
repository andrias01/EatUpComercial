package com.restaurant.ventas.ports.output;

import com.restaurant.ventas.domain.model.Cliente;
import java.util.Optional;

public interface ClienteServicePort {
    Optional<Cliente> obtenerCliente(String id);
    void actualizarHistorico(String clienteId, String ordenId);
}
