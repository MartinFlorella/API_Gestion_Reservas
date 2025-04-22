
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Future;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idReserva;
    
    @Future
    private LocalDateTime inicioReserva;
    @Future
    private LocalDateTime finReserva;
    
    @ManyToOne
    @JoinColumn(name ="idUsuario")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name ="idEspacio")
    private Espacio espacio;
    
    @JsonIgnore
    @OneToOne(mappedBy = "reserva")
    private Factura factura;

    public Reserva() {
    }

    public Reserva(long idReserva, LocalDateTime inicioReserva, LocalDateTime finReserva, Usuario usuario, Espacio espacio) {
        this.idReserva = idReserva;
        this.inicioReserva = inicioReserva;
        this.finReserva = finReserva;
        this.usuario = usuario;
        this.espacio = espacio;
    }
    
}
