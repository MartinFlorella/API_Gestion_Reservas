
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.controller;

import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Usuario;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.service.IUsuarioService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UsuarioController {
    
    @Autowired
    public IUsuarioService usuarioServ;
    
    @PostMapping("usuario/guardar")
    public String saveUsuario( @Valid @RequestBody Usuario usuario){
        usuarioServ.saveUsuario(usuario);
        return "Guardado Correctamente!";
    }

    
    @GetMapping("/usuario/traer")
    public List <Usuario> traerUsuarios(){
        return usuarioServ.getUsuarios();
    }
    
    @DeleteMapping("usuario/borrar/{idUsuario}")
    public String borrarUsuario(@PathVariable long idUsuario){
        usuarioServ.deleteUsuario(idUsuario);
        return "Usuario Eliminado";
    }
    
    @PutMapping("usuario/editar")
    public Usuario editarUsuario(@RequestBody Usuario usuario){
        usuarioServ.editUsuario(usuario);
        return usuario;
    }
    
    public Usuario buscarUsuarioPorNombre(@PathVariable String nombre) {
        return usuarioServ.buscarPorNombre(nombre).orElse(null);
    }
    
    @GetMapping("/usuario/traerPorNombre/{nombre}")
    public List <Usuario> traerUsuarioPorNombre(@PathVariable String nombre){
        return usuarioServ.traerPorNombre(nombre);
    }
       
}
