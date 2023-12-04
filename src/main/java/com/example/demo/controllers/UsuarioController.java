package com.example.demo.controllers;

import com.example.demo.dao.UsuarioDao;
import com.example.demo.models.Usuario;
import com.example.demo.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;
    @RequestMapping(value = "api/usuario/{id}")
    public Usuario getUsuario(@PathVariable int id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Carlos");
        usuario.setApellido("Ardila");
        usuario.setEmail("cardila@correo.com");
        usuario.setTelefono("6805412");

        return usuario;
    }

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuario(@RequestHeader(value = "Authorization") String token){

        String userId = jwtUtil.getKey(token);

        if(userId == null){
            return new ArrayList<>();
        }

        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrar(@RequestBody Usuario usuario){

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024, 1, usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.registrar(usuario);
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

    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable long id){
        usuarioDao.eliminar(id);
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
