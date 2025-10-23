package com.uam.proyectoagiles.ServicioGestionUsuarios.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Usuario")
public class Usuario
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Username es requerido")
    @Size(min = 3, max = 100, message = "Username debe tener entre 3 y 100 caracteres")
    @Column(name = "usuario", unique = true, nullable = false, length = 100)
    private String usuario;

    // @Email
     private String email;

    @NotBlank(message = "Password hash es requerido")
    @Column(name = "passwd", nullable = false, length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Rol es requerido")
    @Column(nullable = false, length = 20)
    private Rol rol;

    @Column(name = "es_activo", nullable = false)
    private Boolean activo = true;

    // Campos de validez para usuario temporal
    @Column(name = "hora_inicio_validez")
    private LocalTime horaInicioValidez;

    @Column(name = "hora_fin_validez")
    private LocalTime horaFinValidez;

    // Relación con Sala: MANY_TO_MANY
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "usuarios_salas",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "sala_id")
    )
    private Set<Sala> salasPermitidas = new HashSet<>();

    // ------------------ Getters / Setters ------------------


    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getEmail() {return email; }

    public void setEmail(String email) { this.email = email;   }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }

    public LocalTime getHoraInicioValidez() { return horaInicioValidez; }
    public void setHoraInicioValidez(LocalTime horaInicioValidez) { this.horaInicioValidez = horaInicioValidez; }

    public LocalTime getHoraFinValidez() { return horaFinValidez; }
    public void setHoraFinValidez(LocalTime horaFinValidez) { this.horaFinValidez = horaFinValidez; }

    public Set<Sala> getSalasPermitidas() { return salasPermitidas; }
    public void setSalasPermitidas(Set<Sala> salasPermitidas) {
        this.salasPermitidas = (salasPermitidas == null) ? new HashSet<>() : salasPermitidas;
    }
}