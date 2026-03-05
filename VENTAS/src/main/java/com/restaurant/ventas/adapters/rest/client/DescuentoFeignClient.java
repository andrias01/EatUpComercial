package com.restaurant.ventas.adapters.rest.client;

import com.restaurant.ventas.domain.model.Descuento;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "descuento-service", url = "${services.descuentos.url}")
public interface DescuentoFeignClient {
    @GetMapping("/descuentos/activo/{clienteId}")
    Descuento getDescuentoActivo(@PathVariable("clienteId") String clienteId);
}
