package com.taller.inventario.repository;

import com.taller.inventario.entity.Repuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepuestoRepository extends JpaRepository<Repuesto, Long> {
    // ¡Magia pura! Aquí ya tienes save(), findAll(), findById(), deleteById() gratis.
}