
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.service;

import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Reserva;
import java.util.List;


public interface IReservaService {
    //alta de Reserva
    public String RegistarReserva(Reserva reserva);
    
    //baja de Reserva
    public String deleteReserva(Long idReserva);
    
   //Traer la lista de los Espacio
    public List<Reserva> getReservas();
    
    //lectura de un solo Espacio
    public Reserva  findReserva(Long idReserva);
   
    //Modificar Espacio
    public void editReserva(Reserva reserva);
    
    //Mostar reservas de un espacio
    public List<Reserva> getReservaEspacios(Long idEspacio);
    
    public List <Reserva> traerReservasPorNombre(String nombre);
}
