package com.restaurant.ventas.adapters.rest.client;

import com.restaurant.ventas.domain.model.Mesa;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mesa-service", url = "${services.mesas.url}")
public interface MesaFeignClient {
    @GetMapping("/mesas/{numero}")
    Mesa getMesa(@PathVariable("numero") String numero);

    @PatchMapping("/mesas/{numero}/liberar")
    void liberarMesa(@PathVariable("numero") String numero);
}
