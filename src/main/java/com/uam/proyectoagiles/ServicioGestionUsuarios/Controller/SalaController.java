package com.uam.proyectoagiles.ServicioGestionUsuarios.Controller;


import com.uam.proyectoagiles.ServicioGestionUsuarios.DTO.SalaDTO;
import com.uam.proyectoagiles.ServicioGestionUsuarios.Model.Sala;
import com.uam.proyectoagiles.ServicioGestionUsuarios.Services.ISalaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/salas")
public class SalaController {

    private final ISalaService salaService;

    public SalaController(ISalaService salaService) {
        this.salaService = salaService;
    }

    // POST — Crear sala
    @PostMapping
    public ResponseEntity<Sala> registrarSala(@Valid @RequestBody SalaDTO dto) {
        Sala sala = salaService.registrarSala(dto);
        return ResponseEntity.status(201).body(sala);
    }

    // GET — Listar todas las salas
    @GetMapping
    public ResponseEntity<List<Sala>> listarSalas() {
        return ResponseEntity.ok(salaService.listarSalas());
    }

    // GET — Obtener sala por ID
    @GetMapping("/{id}")
    public ResponseEntity<Sala> obtenerSala(@PathVariable UUID id) {
        Sala sala = salaService.obtenerPorId(id);
        return ResponseEntity.ok(sala);
    }
}