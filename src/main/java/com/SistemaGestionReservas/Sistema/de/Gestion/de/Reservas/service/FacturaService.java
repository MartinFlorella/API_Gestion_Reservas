
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.service;

import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Factura;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.repository.IFacturaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FacturaService implements IFacturaService{

    @Autowired
    private IFacturaRepository facturaRepo;
    
    @Override
    public Factura editFacturaEstado(long idFactura) {
        Factura factu = facturaRepo.findById(idFactura).orElse(null);
        factu.setEstado("Pagado");
        facturaRepo.save(factu);
        return factu;
    }

    @Override
    public List<Factura> traerFacturas() {
        return facturaRepo.findAll();
    }

    @Override
    public List<Factura> traerFacturaPorNombre(String nombre) {
        List <Factura> todasFacturas = facturaRepo.findAll();
        List <Factura> facturaFiltrada = new ArrayList<>();
        
        for(Factura factura : todasFacturas){
            if(factura.getReserva().getUsuario().getApellido().contains(nombre) ||factura.getReserva().getUsuario().getNombre().contains(nombre) ||
                    factura.getReserva().getEspacio().getDescripcion().contains(nombre) || factura.getReserva().getEspacio().getNombre().contains(nombre)){
                facturaFiltrada.add(factura);
            }
        }
        return facturaFiltrada;
    }
    
}
