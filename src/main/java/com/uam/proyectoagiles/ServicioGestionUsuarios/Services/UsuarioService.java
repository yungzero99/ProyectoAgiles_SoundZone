package com.uam.proyectoagiles.ServicioGestionUsuarios.Services;

import com.uam.proyectoagiles.ServicioGestionUsuarios.DTO.UsuarioDTO;
import com.uam.proyectoagiles.ServicioGestionUsuarios.DTO.UsuarioTemporalDTO;
import com.uam.proyectoagiles.ServicioGestionUsuarios.Model.Rol;
import com.uam.proyectoagiles.ServicioGestionUsuarios.Model.Sala;
import com.uam.proyectoagiles.ServicioGestionUsuarios.Model.Usuario;
import com.uam.proyectoagiles.ServicioGestionUsuarios.Repository.IUsuarioRepository;
import com.uam.proyectoagiles.ServicioGestionUsuarios.Repository.SalaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements IUsuarioService
{

    private final IUsuarioRepository usuarioRepository;
    private final SalaRepository salaRepository;

    public UsuarioService(IUsuarioRepository usuarioRepository , SalaRepository salaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.salaRepository = salaRepository;
    }

    @Override
    @Transactional
    public Usuario registrarUsuario(UsuarioDTO dto) {
        // Validar duplicados
        if (usuarioRepository.existsByUsuario(dto.getUsuario())) {
            throw new IllegalArgumentException("El username ya está registrado");
        }
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("El email ya está registrado");
        }

        Usuario usuario = new Usuario();
        usuario.setUsuario(dto.getUsuario());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword()); // más adelante se encripta
        usuario.setRol(dto.getRol());
        usuario.setActivo(dto.getActivo());

        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public Usuario registrarUsuarioTemporal(UsuarioTemporalDTO dto, String rolSolicitante)
    {

        if (!"ADMIN".equalsIgnoreCase(rolSolicitante)) {
            throw new SecurityException("Solo el usuario ADMIN puede crear usuarios temporales");
        }

        Usuario usuario = new Usuario();

        // Generar username automático
        String username = "temp-" + UUID.randomUUID().toString().substring(0, 8);
        usuario.setUsuario(username);


        usuario.setEmail(username + "@temporal.local");

        // Generar contraseña automática de 6 caracteres
        usuario.setPassword(generarContrasenia());

        usuario.setRol(Rol.TEMPORAL);
        usuario.setActivo(true);
        usuario.setHoraInicioValidez(dto.getHoraInicioValidez());
        usuario.setHoraFinValidez(dto.getHoraFinValidez());

        Set<Sala> salas = dto.getSalasIds().stream()
                .map(id -> salaRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Sala no encontrada: " + id)))
                .collect(Collectors.toSet());
        usuario.setSalasPermitidas(salas);

        return usuarioRepository.save(usuario);
    }

    private String generarContrasenia()
    {
        SecureRandom random = new SecureRandom();
        String ALFANUM = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        return random.ints(6, 0, ALFANUM.length())
                .mapToObj(ALFANUM::charAt)
                .map(Object::toString)
                .reduce("", String::concat);
    }
}