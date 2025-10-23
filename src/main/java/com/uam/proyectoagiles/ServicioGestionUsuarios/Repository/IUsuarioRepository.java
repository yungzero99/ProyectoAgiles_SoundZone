package com.uam.proyectoagiles.ServicioGestionUsuarios.Repository;

import com.uam.proyectoagiles.ServicioGestionUsuarios.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, UUID>
{

    boolean existsByUsuario(String usuario);

    boolean existsByEmail(String email);
}