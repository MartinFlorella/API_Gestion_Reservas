
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Factura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;
    private Double montoTotal;
    private LocalDate fechaEmision;
    private String estado;
    
    @OneToOne
    @JoinColumn(name = "reserva_id")  
    private Reserva reserva;

    public Factura() {
    }

    public Factura(Long idFactura, Double montoTotal, LocalDate fechaEmision, Reserva reserva) {
        this.idFactura = idFactura;
        this.montoTotal = montoTotal;
        this.fechaEmision = fechaEmision;
        this.reserva = reserva;
    }
    
    
    

}
