package com.restaurant.ventas.adapters.rest;

import com.restaurant.ventas.adapters.rest.client.VendedorFeignClient;
import com.restaurant.ventas.domain.model.Vendedor;
import com.restaurant.ventas.ports.output.VendedorServicePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class VendedorRestAdapter implements VendedorServicePort {

    private final VendedorFeignClient client;

    @Override
    public Optional<Vendedor> obtenerVendedor(String id) {
        try {
            return Optional.ofNullable(client.getVendedor(id));
        } catch (Exception e) {
            log.error("Error al obtener vendedor {}: {}", id, e.getMessage());
            return Optional.empty();
        }
    }
}
