package com.restaurant.ventas.adapters.rest.client;

import com.restaurant.ventas.domain.model.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "cliente-service", url = "${services.clientes.url}")
public interface ClienteFeignClient {
    @GetMapping("/clientes/{id}")
    Cliente getCliente(@PathVariable("id") String id);

    @PostMapping("/clientes/{id}/historico/{ordenId}")
    void actualizarHistorico(@PathVariable("id") String id, @PathVariable("ordenId") String ordenId);
}
