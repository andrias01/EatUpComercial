package com.restaurant.ventas.adapters.rest;

import com.restaurant.ventas.adapters.rest.client.RecetaFeignClient;
import com.restaurant.ventas.ports.output.RecetaServicePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class RecetaRestAdapter implements RecetaServicePort {

    private final RecetaFeignClient client;

    @Override
    public Optional<BigDecimal> obtenerPrecioReceta(String recetaId) {
        try {
            Map<String, Object> info = client.getRecetaInfo(recetaId);
            if (info != null && info.containsKey("precio")) {
                return Optional.of(new BigDecimal(info.get("precio").toString()));
            }
        } catch (Exception e) {
            log.error("Error al obtener precio de receta {}: {}", recetaId, e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Optional<String> obtenerNombreReceta(String recetaId) {
        try {
            Map<String, Object> info = client.getRecetaInfo(recetaId);
            if (info != null && info.containsKey("nombre")) {
                return Optional.of(info.get("nombre").toString());
            }
        } catch (Exception e) {
            log.error("Error al obtener nombre de receta {}: {}", recetaId, e.getMessage());
        }
        return Optional.empty();
    }
}
