package com.uam.proyectoagiles.ServicioGestionUsuarios.DTO;

import com.uam.proyectoagiles.ServicioGestionUsuarios.Model.Rol;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UsuarioDTO
{

    @NotBlank(message = "Username es requerido")
    @Size(min = 3, max = 100, message = "Username debe tener entre 3 y 100 caracteres")
    private String usuario;

    @Email(message = "Email debe tener formato válido")
    @NotBlank(message = "Email es requerido")
    private String email;

    @NotBlank(message = "Password es requerido")
    @Size(min = 6, message = "Password debe tener al menos 6 caracteres")
    private String password;

    @NotNull(message = "Rol es requerido")
    private Rol rol;

    private Boolean activo = true;

    // Getters y setters
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
}