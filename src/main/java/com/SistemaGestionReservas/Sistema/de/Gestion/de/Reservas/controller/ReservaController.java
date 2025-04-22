
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.controller;

import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Reserva;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.service.IReservaService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservaController {
    
    @Autowired
    private IReservaService reservaServi;
    
    @PostMapping("/reserva/crear")
    public String registrarReserva(@RequestBody @Valid Reserva reserva){
       return reservaServi.RegistarReserva(reserva);
    }
    
    @GetMapping("/reserva/traer")
    public List <Reserva> TraerReservas(){
        return reservaServi.getReservas();
    }
    
    @DeleteMapping("reserva/borrar/{idReserva}")
    public String borrarReserva(@PathVariable long idReserva){
        reservaServi.deleteReserva(idReserva);
        return "Reserva Eliminado";
    }
    
    @GetMapping("/reserva/traerPorNombre/{nombre}")
    public List <Reserva> TraerReservasPorNombre(@PathVariable String nombre){
        return reservaServi.traerReservasPorNombre(nombre);
    }
}
