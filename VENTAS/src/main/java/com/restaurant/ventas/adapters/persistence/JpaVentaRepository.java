package com.restaurant.ventas.adapters.persistence;

import com.restaurant.ventas.domain.model.EstadoOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaVentaRepository extends JpaRepository<VentaEntity, String> {
    List<VentaEntity> findByEstadoOrden(EstadoOrden estadoOrden);
    boolean existsByMesaNumeroAndEstadoOrden(String mesaNumero, EstadoOrden estadoOrden);
}
