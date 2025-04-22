
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.controller;

import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Factura;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.service.IFacturaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FacturaController {
    
    @Autowired
    private IFacturaService facturaServ;
    
    @PutMapping("/factura/editarEstado/{idFactura}")
    public Factura editarEstadoFactura (@PathVariable long idFactura){
        return facturaServ.editFacturaEstado(idFactura);
    }
    
    @GetMapping("/factura/traer")
    public List <Factura> traerFacturas(){
        return facturaServ.traerFacturas();
    }
    
    @GetMapping("/factura/traerPorNombre/{nombre}")
    public List <Factura> traerFacturasPorNombre(@PathVariable String nombre){
        return facturaServ.traerFacturaPorNombre(nombre);
    }

}
