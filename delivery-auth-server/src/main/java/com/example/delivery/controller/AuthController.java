package com.example.delivery.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/*
 	Aqui implemento uma Controllermuito importante, 
 	pois ela será consultada sempre pelo Client para validar 
 	se o token informado ainda é válido, caso não tenha acesso 
 	ou o token informado seja inválido uma mensagem de não 
 	autorizado é retornada.
 */

@RestController
@RequestMapping("/")
public class AuthController {

	@RequestMapping("/user")
    public Principal getCurrentLoggedInUser(Principal user) {
        return user;
    }
	
}
