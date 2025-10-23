package com.uam.proyectoagiles.ServicioGestionUsuarios.Services;

import com.uam.proyectoagiles.ServicioGestionUsuarios.DTO.SalaDTO;
import com.uam.proyectoagiles.ServicioGestionUsuarios.Model.Sala;

import java.util.List;
import java.util.UUID;

public interface ISalaService
{
    Sala registrarSala(SalaDTO dto);
    List<Sala> listarSalas();
    Sala obtenerPorId(UUID id);
}
