package com.uam.proyectoagiles.ServicioGestionUsuarios.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class SalaDTO
{
    @NotBlank(message = "Nombre de sala es requerido")
    @Column(name = "nombre_sala", nullable = false, unique = true)
    private String nombreSala;

    public @NotBlank(message = "Nombre de sala es requerido") String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(@NotBlank(message = "Nombre de sala es requerido") String nombreSala) {
        this.nombreSala = nombreSala;
    }
}
