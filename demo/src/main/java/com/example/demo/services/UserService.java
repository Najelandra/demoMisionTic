package com.example.demo.services;

import com.example.demo.entities.UserEntity;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {
    private UserRepository repo;

    public UserService(UserRepository repo){
        this.repo = repo;
    }

    public UserEntity createUser(UserEntity nuevoUsuario){
        return this.repo.save(nuevoUsuario);
    }

    public UserEntity findUserByEmail(String email){
        return this.repo.findByEmail(email);
    }
    public UserEntity getOrCreateUser(Map<String ,Object> usuarioDatos){
        String email = (String) usuarioDatos.get("email");

        UserEntity usuario = findUserByEmail(email);
        if(usuario == null){
        String nickName = (String) usuarioDatos.get("nickname");
        String picture = (String) usuarioDatos.get("picture");
        String auth0Id = (String) usuarioDatos.get("sub");

        UserEntity nuevoU = new UserEntity();
        nuevoU.setEmail(email);
        nuevoU.setAuth0_id(auth0Id);
        nuevoU.setImage(picture);

        return createUser(nuevoU);
        }
        System.out.println(usuario.getEmail());
        return usuario;
    }
}
