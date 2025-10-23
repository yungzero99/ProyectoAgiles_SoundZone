package com.uam.proyectoagiles.ServicioGestionUsuarios.Controller;


import com.uam.proyectoagiles.ServicioGestionUsuarios.DTO.UsuarioDTO;
import com.uam.proyectoagiles.ServicioGestionUsuarios.DTO.UsuarioTemporalDTO;
import com.uam.proyectoagiles.ServicioGestionUsuarios.Model.Usuario;
import com.uam.proyectoagiles.ServicioGestionUsuarios.Services.IUsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController
{

    private final IUsuarioService usuarioService;

    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrarUsuario(@Valid @RequestBody UsuarioDTO dto)
    {
        Usuario nuevoUsuario = usuarioService.registrarUsuario(dto);
        return ResponseEntity.status(201).body(nuevoUsuario);
    }
    @PostMapping("/temporales")
    public ResponseEntity<Usuario> registrarTemporal(
            @RequestHeader("X-ROL") String rolSolicitante,
            @Valid @RequestBody UsuarioTemporalDTO dto) {

        Usuario nuevoUsuario = usuarioService.registrarUsuarioTemporal(dto, rolSolicitante);
        return ResponseEntity.status(201).body(nuevoUsuario);
    }
}
