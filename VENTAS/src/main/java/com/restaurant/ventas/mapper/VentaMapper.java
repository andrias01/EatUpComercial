package com.restaurant.ventas.mapper;

import com.restaurant.ventas.domain.model.Venta;
import com.restaurant.ventas.dto.VentaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VentaMapper {

    VentaResponse toResponse(Venta domain);

    @Mapping(target = "vendedorId", source = "vendedor.id")
    @Mapping(target = "numeroMesa", source = "mesa.numeroActual")
    @Mapping(target = "clienteId", source = "cliente.id")
    com.restaurant.ventas.dto.CreateVentaRequest toCreateRequest(Venta domain);
}
