package com.YobossApp_11.Yobossapp.controllers;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.YobossApp_11.Yobossapp.models.UsuarioModel;
import com.YobossApp_11.Yobossapp.services.UsuarioService;

@RestController
@RequestMapping("/api")


public class UsuarioController {
    @Autowired
    UsuarioService usuarioService; 

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios(); 
    }


    @PostMapping( value = "/registro")
    @CrossOrigin(origins = {"http://localhost:8082" , "http://localhost:3000"})
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }


  
}
