package com.restaurant.ventas.adapters.rest;

import com.restaurant.ventas.adapters.rest.client.MesaFeignClient;
import com.restaurant.ventas.domain.model.Mesa;
import com.restaurant.ventas.ports.output.MesaServicePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class MesaRestAdapter implements MesaServicePort {

    private final MesaFeignClient client;

    @Override
    public Optional<Mesa> obtenerMesa(String numeroMesa) {
        try {
            return Optional.ofNullable(client.getMesa(numeroMesa));
        } catch (Exception e) {
            log.error("Error al obtener mesa {}: {}", numeroMesa, e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public void liberarMesa(String numeroMesa) {
        try {
            client.liberarMesa(numeroMesa);
        } catch (Exception e) {
            log.error("Error al liberar mesa {}: {}", numeroMesa, e.getMessage());
        }
    }
}
