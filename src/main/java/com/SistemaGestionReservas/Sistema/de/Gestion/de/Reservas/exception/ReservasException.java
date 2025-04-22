
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.exception;


public class ReservasException extends RuntimeException{
    
     private ExceptionDetails details;

    // Constructor que solo acepta el mensaje de error
    public ReservasException(String message) {
        super(message);
    }

    // Constructor que acepta tanto el mensaje de error como detalles adicionales
    public ReservasException(String message, ExceptionDetails details) {
        super(message);
        this.details = details;
    }

    public ExceptionDetails getDetails() {
        return details;
    }

    public void setDetails(ExceptionDetails details) {
        this.details = details;
    }
}
