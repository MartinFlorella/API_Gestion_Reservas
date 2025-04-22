
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.service;

import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Espacio;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Factura;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Reserva;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Usuario;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.repository.IEspacioRepository;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.repository.IFacturaRepository;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.repository.IReservaRepository;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.repository.IUsuarioRepository;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService implements IReservaService{

    @Autowired
    private IReservaRepository reservaRepo;
    
    @Autowired
    
    private IUsuarioRepository usuarioRepo;
    
    @Autowired 
    private IEspacioRepository espacioRepo;
    
    @Autowired
    private IFacturaRepository facturaRepo;
    
    @Autowired
    private EmailService emailService;
    
    @Override
    public String RegistarReserva(Reserva reserva) {
         Long idEspacio = reserva.getEspacio().getIdEspacio();
    LocalDateTime inicioReserva = reserva.getInicioReserva();
    LocalDateTime finReserva = reserva.getFinReserva();

    // Verificar si el espacio existe
    Espacio espacio = espacioRepo.findById(idEspacio).orElse(null);
    if (espacio == null) {
        return "Error: El espacio con ID " + idEspacio + " no existe.";
    }

    // Obtener todas las reservas y verificar si hay conflicto de fechas
    List<Reserva> reservasExistentes = reservaRepo.findAll();

    for (Reserva reserv : reservasExistentes) {
        if (reserv.getEspacio().getIdEspacio() == idEspacio &&
            reserv.getInicioReserva().isBefore(finReserva) &&
            reserv.getFinReserva().isAfter(inicioReserva)) {
            return "Error: Ya existe una reserva para este espacio en el rango de fechas especificado.";
        }
    }
    
    // Paso 1: Guardar la reserva primero
    reservaRepo.save(reserva);

    // Paso 2: Crear la factura después de guardar la reserva
    Duration duracion = Duration.between(inicioReserva, finReserva);
    long horasReserva = duracion.toHours();
    
    // Calcular el monto total (precio por hora * horas de reserva)
    long montoPorHora = espacioRepo.findById(idEspacio).orElse(null).getPrecioPorHora();
    long montoTotal = horasReserva * montoPorHora;

    Factura nuevaFactura = new Factura();
    nuevaFactura.setMontoTotal((double) montoTotal);
    nuevaFactura.setFechaEmision(LocalDate.now());
    nuevaFactura.setReserva(reserva); // Aquí la reserva ya está guardada y tiene un ID
    nuevaFactura.setEstado("pendiente");

    // Paso 3: Guardar la factura
    facturaRepo.save(nuevaFactura);
    Usuario user = usuarioRepo.findById(reserva.getUsuario().getIdUsuario()).orElse(null);
    String emailUsuario =  user.getEmail();
    String asunto = "Confirmación de Reserva";
    String mensaje = "Estimado " + user.getNombre() + ",\n\n" +
                     "Su reserva ha sido confirmada en el espacio " + espacio.getNombre() + 
                     " desde " + reserva.getInicioReserva() + " hasta " + reserva.getFinReserva() + ".\n" +
                     "Monto total: $" + montoTotal + ".\n\n" + 
                     "Gracias por su preferencia.";

    emailService.sendEmail(emailUsuario, asunto, mensaje);
    
    return "Reserva guardada exitosamente." + " Espacio: " + espacio.getDescripcion() + 
           " Usuario: " + user.getNombre() + 
           " Inicio reserva: " + reserva.getInicioReserva() + 
           " Fin reserva: " + reserva.getFinReserva();
    
    }

    @Override
    public String deleteReserva(Long idReserva) {
        List <Factura> listaFacturas = facturaRepo.findAll();
        List<Factura> facturasAEliminar = new ArrayList<>();
        for(Factura factura : listaFacturas){
            if(factura.getReserva().getIdReserva() == idReserva){
                facturasAEliminar.add(factura);
            }
        }
        facturaRepo.deleteAll(facturasAEliminar);
        reservaRepo.deleteById(idReserva);
        return "Reserva eliminada correctamente";
    }

    @Override
    public List<Reserva> getReservas() {
        return reservaRepo.findAll();
    }

    @Override
    public Reserva findReserva(Long idReserva) {
        return reservaRepo.findById(idReserva).orElse(null);
    }

    @Override
    public void editReserva(Reserva reserva) {
        this.RegistarReserva(reserva);
    }

    @Override
    public List<Reserva> getReservaEspacios(Long idEspacio ) {
 
            List<Reserva> listaReservas = reservaRepo.findAll();
            List<Reserva> listaFiltrada = new ArrayList();
            
            for(Reserva reserva : listaReservas ){
                if(reserva.getEspacio().getIdEspacio() == idEspacio)
                    listaFiltrada.add(reserva);
            }
            return listaFiltrada;
    
    }

    @Override
    public List<Reserva> traerReservasPorNombre(String nombre) {
        List <Reserva> todasReservas = reservaRepo.findAll();
        List <Reserva> reservaFiltrada = new ArrayList<>();
        
        for(Reserva reserva : todasReservas){
            if(reserva.getUsuario().getApellido().contains(nombre) || reserva.getUsuario().getNombre().contains(nombre) || 
                    reserva.getEspacio().getDescripcion().contains(nombre) || reserva.getEspacio().getNombre().contains(nombre)){
                reservaFiltrada.add(reserva);
            }
        }
        return reservaFiltrada;
    }
    
}
