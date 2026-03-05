package com.restaurant.ventas.adapters.persistence;

import com.restaurant.ventas.domain.model.EstadoOrden;
import com.restaurant.ventas.domain.model.Venta;
import com.restaurant.ventas.ports.output.VentaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class VentaPersistenceAdapter implements VentaRepositoryPort {

    private final JpaVentaRepository repository;
    private final PersistenceMapper mapper;

    @Override
    public Venta guardar(Venta venta) {
        VentaEntity entity = mapper.toEntity(venta);
        VentaEntity saved = repository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Venta> obtenerPorId(String ordenId) {
        return repository.findById(ordenId).map(mapper::toDomain);
    }

    @Override
    public List<Venta> listarActivas() {
        return repository.findByEstadoOrden(EstadoOrden.ABIERTA).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existeOrdenActivaEnMesa(String numeroMesa) {
        return repository.existsByMesaNumeroAndEstadoOrden(numeroMesa, EstadoOrden.ABIERTA);
    }
}
