package com.restaurant.ventas.adapters.rest;

import com.restaurant.ventas.adapters.rest.client.DescuentoFeignClient;
import com.restaurant.ventas.domain.model.Descuento;
import com.restaurant.ventas.ports.output.DescuentoServicePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class DescuentoRestAdapter implements DescuentoServicePort {

    private final DescuentoFeignClient client;

    @Override
    public Optional<Descuento> obtenerDescuentoActivo(String clienteId) {
        try {
            return Optional.ofNullable(client.getDescuentoActivo(clienteId));
        } catch (Exception e) {
            log.error("Error al obtener descuento activo del cliente {}: {}", clienteId, e.getMessage());
            return Optional.empty();
        }
    }
}
