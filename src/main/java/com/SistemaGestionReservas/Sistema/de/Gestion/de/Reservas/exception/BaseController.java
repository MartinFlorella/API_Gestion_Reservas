
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class BaseController {
    
    @ExceptionHandler(ReservasException.class)
    public ResponseEntity<ExceptionDetails> handleDemoSpringCourseException(ReservasException ex) {
        ExceptionDetails details = ex.getDetails(); // Obtén el detalle de la excepción
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }
    
    /*
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ExceptionDetails> handleNoHandlerFoundException(NoHandlerFoundException ex) {
        ExceptionDetails details = new ExceptionDetails("Recurso no encontrado", "Por favor verifica la URL que has ingresado.");
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDetails> handleGeneralException(Exception ex) {
        ExceptionDetails details = new ExceptionDetails("Error inesperado", "Ha ocurrido un error. Por favor, intenta de nuevo más tarde.");
        return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }*/
}
