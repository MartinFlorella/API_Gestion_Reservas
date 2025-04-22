
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.service;

import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Espacio;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.repository.IEspacioRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspacioService implements IEspacioService{

    @Autowired
    private IEspacioRepository espacioRepo;
      
    @Override
    public void saveEspacio(Espacio espacio) {
            
           espacioRepo.save(espacio);
           
    }

    @Override
    public void deleteEspacio(Long idEspacio) {

        espacioRepo.deleteById(idEspacio);
    
    }

    @Override
    public List<Espacio> getEspacios() {
        List<Espacio> listaEspacioss = espacioRepo.findAll(); 
       
        return listaEspacioss ;
    }

    @Override
    public Espacio findEspacio(Long idEspacio) {

    Espacio espacio = espacioRepo.findById(idEspacio).orElse(null);
        return espacio;
    }

    @Override
    public void editEspacio(Espacio espacio) {

        espacioRepo.save(espacio);
    
    }

    @Override
    public Espacio buscarPorNombre(String nombre) {

           List<Espacio> listaEspacios = espacioRepo.findAll(); 
    for (Espacio espacio : listaEspacios) {
        if (espacio.getNombre().equals(nombre)) {
            return espacio;
        }
    }
    
    return null; 
   
}

    @Override
    public List<Espacio> traerEspacioPorNombre(String nombre) {
        List <Espacio> listaEspacios = espacioRepo.findAll();
        List <Espacio> listaFiltrada = new ArrayList<> ();
        
        for(Espacio espacio : listaEspacios){
            if(espacio.getNombre().contains(nombre) || espacio.getDescripcion().contains(nombre)){
                listaFiltrada.add(espacio);
            }
                
        }
        return listaFiltrada;
    }
}
