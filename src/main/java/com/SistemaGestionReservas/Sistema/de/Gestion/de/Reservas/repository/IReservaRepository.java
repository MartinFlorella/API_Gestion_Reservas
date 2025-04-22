/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.repository;

import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservaRepository extends JpaRepository <Reserva , Long>{
    
}
