package com.uam.proyectoagiles.ServicioGestionUsuarios.Services;

import com.uam.proyectoagiles.ServicioGestionUsuarios.DTO.SalaDTO;
import com.uam.proyectoagiles.ServicioGestionUsuarios.Model.Sala;
import com.uam.proyectoagiles.ServicioGestionUsuarios.Repository.SalaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class SalaService implements ISalaService
{
    private final SalaRepository salaRepository;
    public SalaService(SalaRepository salaRepository)
    {
        this.salaRepository = salaRepository;
    }
    @Override
    public Sala registrarSala(SalaDTO dto) {
        if (salaRepository.existsByNombreSala(dto.getNombreSala())) {
            throw new IllegalArgumentException("Ya existe una sala con ese nombre");
        }

        Sala sala = new Sala();
        sala.setNombreSala(dto.getNombreSala());
        return salaRepository.save(sala);
    }

    @Override
    public List<Sala> listarSalas() {
        return salaRepository.findAll();
    }

    @Override
    public Sala obtenerPorId(UUID id) {
        return salaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sala no encontrada con ID: " + id));
    }
}