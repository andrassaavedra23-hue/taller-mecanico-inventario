package com.taller.inventario.controller;

import com.taller.inventario.entity.Repuesto;
import com.taller.inventario.service.RepuestoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController le dice a Spring: "Esto es una API REST, convierte todo a JSON automáticamente"
@RestController
// @RequestMapping define la ruta base en la URL. Ojo: usa la 's' al final de repuestos
@RequestMapping("/api/repuestos")
public class RepuestoController {

    // Conectamos el Controller con el Service
    private final RepuestoService service;

    public RepuestoController(RepuestoService service) {
        this.service = service;
    }

    // 1. CREAR (POST) - Recibe datos por el body de la petición
    @PostMapping
    public ResponseEntity<Repuesto> crearRepuesto(@RequestBody Repuesto repuesto) {
        Repuesto nuevo = service.guardarRepuesto(repuesto);
        return ResponseEntity.ok(nuevo); // Devuelve 200 OK con el repuesto guardado (y su ID generado)
    }

    // 2. LISTAR TODOS (GET)
    @GetMapping
    public ResponseEntity<List<Repuesto>> listarRepuestos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // 3. BUSCAR POR ID (GET) - Ejemplo: /api/repuestos/1
    @GetMapping("/{id}")
    public ResponseEntity<Repuesto> buscarRepuesto(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok) // Si lo encuentra, devuelve 200 OK
                .orElse(ResponseEntity.notFound().build()); // Si no, devuelve 404 Not Found
    }

    // 4. ELIMINAR (DELETE) - Ejemplo: /api/repuestos/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRepuesto(@PathVariable Long id) {
        service.eliminarRepuesto(id);
        return ResponseEntity.noContent().build(); // Devuelve 204 No Content (sin cuerpo)
    }
    // AQUÍ ESTÁ EL PUT
    @PutMapping("/{id}")
    public ResponseEntity<Repuesto> actualizarRepuesto(@PathVariable Long id, @RequestBody Repuesto detalles) {
        try {
            Repuesto actualizado = service.actualizarRepuesto(id, detalles);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}