package com.uam.proyectoagiles.ServicioGestionUsuarios.Repository;

import com.uam.proyectoagiles.ServicioGestionUsuarios.Model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SalaRepository extends JpaRepository<Sala, UUID>
{
}
