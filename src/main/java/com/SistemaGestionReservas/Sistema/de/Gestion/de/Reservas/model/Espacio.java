
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Espacio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEspacio;
    
    @NotBlank(message = "El nombre del espacio es obligatorio")
    @Size(min = 3, max = 30, message = "El nombre debe tener entre 3 y 30 caracteres")
    private String nombre;
    
    @NotBlank
    @Size(min = 3, max = 30)
    private String descripcion;
    
    
    @Min(900)@Max(10000)
    private long precioPorHora;
    
    @JsonIgnore
    @OneToMany(mappedBy = "espacio")
    private List<Reserva> listaReservas;

    public Espacio() {
    }

    public Espacio(long idEspacio, String nombre, String descripcion, long precioPorHora) {
        this.idEspacio = idEspacio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioPorHora = precioPorHora;
    }

    public long getIdEspacio() {
        return idEspacio;
    }

    public void setIdEspacio(long idEspacio) {
        this.idEspacio = idEspacio;
    }

    public @NotBlank(message = "El nombre del espacio es obligatorio") @Size(min = 3, max = 30, message = "El nombre debe tener entre 3 y 30 caracteres") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "El nombre del espacio es obligatorio") @Size(min = 3, max = 30, message = "El nombre debe tener entre 3 y 30 caracteres") String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank @Size(min = 3, max = 30) String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(@NotBlank @Size(min = 3, max = 30) String descripcion) {
        this.descripcion = descripcion;
    }

    @Min(900)
    @Max(10000)
    public long getPrecioPorHora() {
        return precioPorHora;
    }

    public void setPrecioPorHora(@Min(900) @Max(10000) long precioPorHora) {
        this.precioPorHora = precioPorHora;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }
}
