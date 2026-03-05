package com.restaurant.ventas.adapters.rest.client;

import com.restaurant.ventas.domain.model.Vendedor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "vendedor-service", url = "${services.vendedores.url}")
public interface VendedorFeignClient {
    @GetMapping("/vendedores/{id}")
    Vendedor getVendedor(@PathVariable("id") String id);
}
