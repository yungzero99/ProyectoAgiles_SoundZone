package com.uam.proyectoagiles.ServicioGestionUsuarios.DTO;

import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;
import java.util.Set;
import java.util.UUID;

public class UsuarioTemporalDTO {

    @NotNull(message = "Hora de inicio es requerida")
    private LocalTime horaInicioValidez;

    @NotNull(message = "Hora de fin es requerida")
    private LocalTime horaFinValidez;

    @NotNull(message = "Debe asociar al menos una sala")
    private Set<UUID> salasIds;
    /*
    getters/setters
     */
    public LocalTime getHoraInicioValidez() { return horaInicioValidez; }
    public void setHoraInicioValidez(LocalTime horaInicioValidez) { this.horaInicioValidez = horaInicioValidez; }

    public LocalTime getHoraFinValidez() { return horaFinValidez; }
    public void setHoraFinValidez(LocalTime horaFinValidez) { this.horaFinValidez = horaFinValidez; }

    public Set<UUID> getSalasIds() { return salasIds; }
    public void setSalasIds(Set<UUID> salasIds) { this.salasIds = salasIds; }
}