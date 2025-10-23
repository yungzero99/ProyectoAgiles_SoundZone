package com.uam.proyectoagiles.ServicioGestionUsuarios.Model;

import jakarta.persistence.Table;

@Table(name = "Rol")
public enum Rol
{
    ADMIN,
    TEMPORAL,
    TECNICO,
    DJ
}
