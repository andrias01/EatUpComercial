package com.restaurant.ventas.adapters.rest.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.Map;

@FeignClient(name = "receta-service", url = "${services.recetas.url}")
public interface RecetaFeignClient {
    @GetMapping("/recetas/{id}/info")
    Map<String, Object> getRecetaInfo(@PathVariable("id") String id);
}
