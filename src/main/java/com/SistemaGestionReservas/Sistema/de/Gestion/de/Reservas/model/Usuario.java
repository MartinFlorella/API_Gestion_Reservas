
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;
    
    @NotNull
   @NotBlank(message = "El nombre del estudiante es obligatorio")
    @Size(min = 3, max = 15, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;
   
    @NotNull
    @Size(min = 3, max = 50)
    private String apellido;
   
    @NotNull
    @Email(message = "El correo electrónico no es válido")
    private String email;
    
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Reserva> listaReservas;

    public Usuario() {
    }

    public Usuario(long idUsuario, String nombre, String apellido, String email) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }
    
    
}

    

