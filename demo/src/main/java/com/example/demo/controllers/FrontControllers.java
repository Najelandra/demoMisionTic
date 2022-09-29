package com.example.demo.controllers;

import com.example.demo.entities.Task;
import com.example.demo.entities.UserEntity;
import com.example.demo.services.TaskServices;
import com.example.demo.services.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FrontControllers {

    TaskServices servicio;
    UserService servicioUsuario;

    public FrontControllers(TaskServices servicio, UserService servicioUsuario){
        this.servicioUsuario = servicioUsuario;
        this.servicio = servicio;
    }

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal){ //OidcUser devuelve info del usuario, nombre, foto perfil, id
        if(principal!= null){
        UserEntity usuario = this.servicioUsuario.getOrCreateUser(principal.getClaims()); //así se envía la información al servicio
        model.addAttribute("usuario", usuario); //para poder usar la info del usuario en el front

            System.out.println(principal.getClaims()); //imprimir lo que devuelve Auth0 del usuario
        /*
        * {sub=auth0|6330f47088cb57e1fd8e6277, email_verified=false, iss=https://dev-isaxls1t.us.auth0.com/, nonce=4Lu5FOLVU1kBPIl1IgzT-qO6BOdjNxmTIMI1rCZ6gds,
        * picture=https://s.gravatar.com/avatar/8d6ae69503cf39f7e7f841709e56868e?s=480&r=pg&d=https%3A%2F%2Fcdn.auth0.com%2Favatars%2Fna.png, sid=_T8XNyKjg88tgy6JAEYo664dZulBoIs_, aud=[uiY3u7e76CEa9gPRwz7sohrZHDVs26Xt], updated_at=2022-09-26T01:34:16.480Z, nickname=namesiasb, name=namesiasb@unal.edu.co, exp=2022-09-26T11:34:17Z, iat=2022-09-26T01:34:17Z, email=namesiasb@unal.edu.co}
        * */
        }
        return "index";
    }

    @GetMapping("/tasks")
    //los controladores de thymeleaf, reciben variables que se conocen como el modelo
    public String Tasks(Model model){
        List<Task> tareas = this.servicio.getTaskList();
        model.addAttribute("Tareas",tareas);
        //este el el html que contiene los cards
        return "tasks";
    }

    @GetMapping("/tasks/new")
    public String newTask(Model model){
        model.addAttribute("task", new Task());
        return "newTask";
    }
}
