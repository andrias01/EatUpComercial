package com.restaurant.ventas.mapper;

import com.restaurant.ventas.domain.model.Cliente;
import com.restaurant.ventas.domain.model.Descuento;
import com.restaurant.ventas.domain.model.ItemPedido;
import com.restaurant.ventas.domain.model.Mesa;
import com.restaurant.ventas.domain.model.Totales;
import com.restaurant.ventas.domain.model.Vendedor;
import com.restaurant.ventas.domain.model.Venta;
import com.restaurant.ventas.dto.CreateVentaRequest;
import com.restaurant.ventas.dto.VentaResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-05T00:22:22-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20260224-0835, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class VentaMapperImpl implements VentaMapper {

    @Override
    public VentaResponse toResponse(Venta domain) {
        if ( domain == null ) {
            return null;
        }

        VentaResponse.VentaResponseBuilder ventaResponse = VentaResponse.builder();

        ventaResponse.ordenId( domain.getOrdenId() );
        ventaResponse.vendedor( vendedorToVendedorDto( domain.getVendedor() ) );
        ventaResponse.mesa( mesaToMesaDto( domain.getMesa() ) );
        ventaResponse.cliente( clienteToClienteDto( domain.getCliente() ) );
        ventaResponse.itemsPedido( itemPedidoListToItemPedidoDtoList( domain.getItemsPedido() ) );
        ventaResponse.totales( totalesToTotalesDto( domain.getTotales() ) );
        ventaResponse.estadoOrden( domain.getEstadoOrden() );
        ventaResponse.fechaCreacion( domain.getFechaCreacion() );

        return ventaResponse.build();
    }

    @Override
    public CreateVentaRequest toCreateRequest(Venta domain) {
        if ( domain == null ) {
            return null;
        }

        CreateVentaRequest.CreateVentaRequestBuilder createVentaRequest = CreateVentaRequest.builder();

        createVentaRequest.vendedorId( domainVendedorId( domain ) );
        createVentaRequest.numeroMesa( domainMesaNumeroActual( domain ) );
        createVentaRequest.clienteId( domainClienteId( domain ) );

        return createVentaRequest.build();
    }

    protected VentaResponse.VendedorDto vendedorToVendedorDto(Vendedor vendedor) {
        if ( vendedor == null ) {
            return null;
        }

        VentaResponse.VendedorDto.VendedorDtoBuilder vendedorDto = VentaResponse.VendedorDto.builder();

        vendedorDto.id( vendedor.getId() );
        vendedorDto.nombre( vendedor.getNombre() );

        return vendedorDto.build();
    }

    protected VentaResponse.MesaDto mesaToMesaDto(Mesa mesa) {
        if ( mesa == null ) {
            return null;
        }

        VentaResponse.MesaDto.MesaDtoBuilder mesaDto = VentaResponse.MesaDto.builder();

        mesaDto.numeroActual( mesa.getNumeroActual() );
        mesaDto.ubicacion( mesa.getUbicacion() );
        mesaDto.comensales( mesa.getComensales() );
        mesaDto.horaApertura( mesa.getHoraApertura() );
        mesaDto.tiempoActivoMinutos( mesa.getTiempoActivoMinutos() );

        return mesaDto.build();
    }

    protected VentaResponse.DescuentoDto descuentoToDescuentoDto(Descuento descuento) {
        if ( descuento == null ) {
            return null;
        }

        VentaResponse.DescuentoDto.DescuentoDtoBuilder descuentoDto = VentaResponse.DescuentoDto.builder();

        descuentoDto.nombre( descuento.getNombre() );
        if ( descuento.getPorcentaje() != null ) {
            descuentoDto.porcentaje( descuento.getPorcentaje().doubleValue() );
        }

        return descuentoDto.build();
    }

    protected VentaResponse.ClienteDto clienteToClienteDto(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        VentaResponse.ClienteDto.ClienteDtoBuilder clienteDto = VentaResponse.ClienteDto.builder();

        clienteDto.esConsumidorFinal( cliente.getEsConsumidorFinal() );
        clienteDto.id( cliente.getId() );
        clienteDto.nombre( cliente.getNombre() );
        clienteDto.descuentoAplicado( descuentoToDescuentoDto( cliente.getDescuentoAplicado() ) );

        return clienteDto.build();
    }

    protected VentaResponse.ItemPedidoDto itemPedidoToItemPedidoDto(ItemPedido itemPedido) {
        if ( itemPedido == null ) {
            return null;
        }

        VentaResponse.ItemPedidoDto.ItemPedidoDtoBuilder itemPedidoDto = VentaResponse.ItemPedidoDto.builder();

        itemPedidoDto.itemInstanciaId( itemPedido.getItemInstanciaId() );
        itemPedidoDto.recetaId( itemPedido.getRecetaId() );
        itemPedidoDto.nombre( itemPedido.getNombre() );
        if ( itemPedido.getEstadoCocina() != null ) {
            itemPedidoDto.estadoCocina( itemPedido.getEstadoCocina().name() );
        }
        itemPedidoDto.cantidad( itemPedido.getCantidad() );
        itemPedidoDto.comentario( itemPedido.getComentario() );
        itemPedidoDto.mesaOrigen( itemPedido.getMesaOrigen() );

        return itemPedidoDto.build();
    }

    protected List<VentaResponse.ItemPedidoDto> itemPedidoListToItemPedidoDtoList(List<ItemPedido> list) {
        if ( list == null ) {
            return null;
        }

        List<VentaResponse.ItemPedidoDto> list1 = new ArrayList<VentaResponse.ItemPedidoDto>( list.size() );
        for ( ItemPedido itemPedido : list ) {
            list1.add( itemPedidoToItemPedidoDto( itemPedido ) );
        }

        return list1;
    }

    protected VentaResponse.TotalesDto totalesToTotalesDto(Totales totales) {
        if ( totales == null ) {
            return null;
        }

        VentaResponse.TotalesDto.TotalesDtoBuilder totalesDto = VentaResponse.TotalesDto.builder();

        if ( totales.getSubtotalBruto() != null ) {
            totalesDto.subtotalBruto( totales.getSubtotalBruto().doubleValue() );
        }
        if ( totales.getValorDescuento() != null ) {
            totalesDto.valorDescuento( totales.getValorDescuento().doubleValue() );
        }
        if ( totales.getTotalAPagar() != null ) {
            totalesDto.totalAPagar( totales.getTotalAPagar().doubleValue() );
        }

        return totalesDto.build();
    }

    private String domainVendedorId(Venta venta) {
        if ( venta == null ) {
            return null;
        }
        Vendedor vendedor = venta.getVendedor();
        if ( vendedor == null ) {
            return null;
        }
        String id = vendedor.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String domainMesaNumeroActual(Venta venta) {
        if ( venta == null ) {
            return null;
        }
        Mesa mesa = venta.getMesa();
        if ( mesa == null ) {
            return null;
        }
        String numeroActual = mesa.getNumeroActual();
        if ( numeroActual == null ) {
            return null;
        }
        return numeroActual;
    }

    private String domainClienteId(Venta venta) {
        if ( venta == null ) {
            return null;
        }
        Cliente cliente = venta.getCliente();
        if ( cliente == null ) {
            return null;
        }
        String id = cliente.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
