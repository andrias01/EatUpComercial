package com.restaurant.ventas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateVentaRequest {
    @NotBlank(message = "El ID del vendedor es obligatorio")
    private String vendedorId;
    
    @NotBlank(message = "El número de mesa es obligatorio")
    private String numeroMesa;
    
    @NotBlank(message = "El ID del cliente es obligatorio")
    private String clienteId;
    
    @NotEmpty(message = "La orden debe tener al menos un item")
    private List<ItemPedidoRequest> items;
}
