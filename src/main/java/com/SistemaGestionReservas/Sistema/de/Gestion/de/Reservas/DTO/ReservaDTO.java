
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReservaDTO implements Serializable{
    
    private Long idReserva;
    private LocalDateTime inicioReserva;
    private LocalDateTime finReserva;
    private Long idUsuario;
    private String nombreEspacio;

    public ReservaDTO(Long idReserva, LocalDateTime inicioReserva, LocalDateTime finReserva, Long idUsuario, String nombreEspacio) {
        this.idReserva = idReserva;
        this.inicioReserva = inicioReserva;
        this.finReserva = finReserva;
        this.idUsuario = idUsuario;
        this.nombreEspacio = nombreEspacio;
    }

    public ReservaDTO() {
    }
    
    
}
