package com.taller.inventario.service;

import com.taller.inventario.entity.Repuesto;
import com.taller.inventario.repository.RepuestoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service le dice a Spring: "Esta clase es el cerebro del negocio, guárdala en memoria"
@Service
public class RepuestoService {

    // Conectamos el Service con el Repository
    private final RepuestoRepository repository;

    // Inyección por constructor (Buena práctica moderna en Java 21)
    public RepuestoService(RepuestoRepository repository) {
        this.repository = repository;
    }

    // LÓGICA DE NEGOCIO AQUÍ:

    // 1. Crear o Actualizar un repuesto
    public Repuesto guardarRepuesto(Repuesto repuesto) {
        // Aquí podrías validar que el precio sea > 0 antes de guardar
        return repository.save(repuesto);
    }

    // 2. Listar TODOS los repuestos
    public List<Repuesto> listarTodos() {
        return repository.findAll();
    }

    // 3. Buscar UN repuesto por su ID
    public Optional<Repuesto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // 4. Eliminar un repuesto
    public void eliminarRepuesto(Long id) {
        repository.deleteById(id);
    }
    // 5. Actualizar un repuesto
    public Repuesto actualizarRepuesto(Long id, Repuesto detalles) {
        return repository.findById(id).map(repuesto -> {
            repuesto.setNombre(detalles.getNombre());
            repuesto.setCategoria(detalles.getCategoria());
            repuesto.setPrecio(detalles.getPrecio());
            repuesto.setStock(detalles.getStock());
            return repository.save(repuesto);
        }).orElseThrow(() -> new RuntimeException("Repuesto no encontrado"));
    }
}