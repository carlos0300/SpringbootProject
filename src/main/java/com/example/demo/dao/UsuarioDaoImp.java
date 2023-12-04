package com.example.demo.dao;

import com.example.demo.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    EntityManager manager;

    @Override
    @Transactional
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        TypedQuery<Usuario> typedQuery = manager.createQuery(query, Usuario.class);
        return typedQuery.getResultList();
    }

    @Override
    public void eliminar(long id) {
        Usuario usuario = manager.find(Usuario.class, id);
        manager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        manager.merge(usuario);
    }

    @Override
    @Transactional
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email" ;
        TypedQuery<Usuario> typedQuery = manager.createQuery(query, Usuario.class)
                .setParameter("email", usuario.getEmail());

        List<Usuario> lista = typedQuery.getResultList();

        if (lista.isEmpty()){
            return null;
        }
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        if(argon2.verify(lista.get(0).getPassword(), usuario.getPassword())){ //verifica que la contraseña de la base de datos y la contraseña ingresada sean las mismas
            return lista.get(0);
        }
        return null;
    }

}



