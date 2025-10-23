package com.uam.proyectoagiles.ServicioGestionUsuarios.Services;

import com.uam.proyectoagiles.ServicioGestionUsuarios.DTO.UsuarioDTO;
import com.uam.proyectoagiles.ServicioGestionUsuarios.DTO.UsuarioTemporalDTO;
import com.uam.proyectoagiles.ServicioGestionUsuarios.Model.Usuario;

public interface IUsuarioService
{
    Usuario registrarUsuario(UsuarioDTO dto);
    Usuario registrarUsuarioTemporal(UsuarioTemporalDTO dto, String rolSolicitante);
}