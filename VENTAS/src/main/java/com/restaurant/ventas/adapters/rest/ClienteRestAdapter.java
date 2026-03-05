package com.restaurant.ventas.adapters.rest;

import com.restaurant.ventas.adapters.rest.client.ClienteFeignClient;
import com.restaurant.ventas.domain.model.Cliente;
import com.restaurant.ventas.ports.output.ClienteServicePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class ClienteRestAdapter implements ClienteServicePort {

    private final ClienteFeignClient client;

    @Override
    public Optional<Cliente> obtenerCliente(String id) {
        try {
            return Optional.ofNullable(client.getCliente(id));
        } catch (Exception e) {
            log.error("Error al obtener cliente {}: {}", id, e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public void actualizarHistorico(String clienteId, String ordenId) {
        try {
            client.actualizarHistorico(clienteId, ordenId);
        } catch (Exception e) {
            log.error("Error al actualizar histórico del cliente {}: {}", clienteId, e.getMessage());
        }
    }
}
