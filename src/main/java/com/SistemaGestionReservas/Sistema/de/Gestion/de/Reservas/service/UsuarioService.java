
package com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.service;

import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.model.Usuario;
import com.SistemaGestionReservas.Sistema.de.Gestion.de.Reservas.repository.IUsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private IUsuarioRepository usuarioRepo;

    @Override
    public void saveUsuario(Usuario usuario) {
            
        usuarioRepo.save(usuario);
    
    }

    @Override
    public void deleteUsuario(Long idUsuario) {

        usuarioRepo.deleteById(idUsuario);
    
    }

    @Override
    public List<Usuario> getUsuarios() {

        List<Usuario> listaUsuarios = usuarioRepo.findAll();
        
        return listaUsuarios;
    }

    @Override
    public Usuario findUsuario(Long idUsuario) {

        Usuario usuario = usuarioRepo.findById(idUsuario).orElse(null);
        return usuario;
    
    }

    @Override
    public void editUsuario(Usuario usuario) {

        usuarioRepo.save(usuario);
    
    }

    @Override
    public Optional<Usuario> buscarPorNombre(String nombre) {
List<Usuario> usuarios = usuarioRepo.findAll();
        // Filtrar usuarios que coincidan con el nombre
        return usuarios.stream()
                       .filter(usuario -> usuario.getNombre().equalsIgnoreCase(nombre))
                       .findFirst(); // Devuelve el primer usuario que coincida}
    
}

    @Override
    public List<Usuario> traerPorNombre(String nombre) {
        List <Usuario> listaUsuarios = usuarioRepo.findAll();
        List <Usuario> listaFiltrada = new ArrayList<>();
        
        for(Usuario user : listaUsuarios){
            if(user.getNombre().contains(nombre) || user.getApellido().contains(nombre)){
                listaFiltrada.add(user);
            }
        }
        return listaFiltrada;
    }
}