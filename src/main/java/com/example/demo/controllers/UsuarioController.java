package com.example.demo.controllers;

import com.example.demo.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable int id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Carlos");
        usuario.setApellido("Ardila");
        usuario.setEmail("cardila@correo.com");
        usuario.setTelefono("6805412");

        return usuario;
    }

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuario(){

        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setNombre("Carlos");
        usuario.setApellido("Ardila");
        usuario.setEmail("cardila@correo.com");
        usuario.setTelefono("6805412");

        Usuario usuario2 = new Usuario();
        usuario2.setNombre("Jesus");
        usuario2.setApellido("Navarro");
        usuario2.setEmail("cardila@correo.com");
        usuario2.setTelefono("7541236");

        Usuario usuario3 = new Usuario();
        usuario3.setNombre("Jose");
        usuario3.setApellido("Fonseca");
        usuario3.setEmail("cardila@correo.com");
        usuario3.setTelefono("8945264");

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        return usuarios;
    }

    @RequestMapping(value = "usuario2")
    public Usuario editar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Carlos");
        usuario.setApellido("Ardila");
        usuario.setEmail("cardila@correo.com");
        usuario.setTelefono("6805412");

        return usuario;
    }

    @RequestMapping(value = "usuario3")
    public Usuario eliminar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Carlos");
        usuario.setApellido("Ardila");
        usuario.setEmail("cardila@correo.com");
        usuario.setTelefono("6805412");

        return usuario;
    }

    @RequestMapping(value = "usuario4")
    public Usuario buscar(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Carlos");
        usuario.setApellido("Ardila");
        usuario.setEmail("cardila@correo.com");
        usuario.setTelefono("6805412");

        return usuario;
    }
}
