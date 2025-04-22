
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.service;

import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Factura;
import java.util.List;

public interface IFacturaService {
    
    public Factura editFacturaEstado(long idFactura);
    
    public List <Factura> traerFacturas();
    
    public List <Factura> traerFacturaPorNombre(String nombre);
}
