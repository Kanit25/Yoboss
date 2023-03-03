package com.YobossApp_11.Yobossapp.controllers;

import java.util.Objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.YobossApp_11.Yobossapp.models.UsuarioModel;

@RestController
@RequestMapping("/api")


    public class LoginService {
        @Autowired
        private  LoginService userService;


        @GetMapping("/login")
          
        public ModelAndView login() {
         ModelAndView mav = new ModelAndView("login");
            mav.addObject("user", new UsuarioModel());
            return mav;
        }

        @PostMapping(value = "/login")
        @CrossOrigin(origins = {"http://localhost:3000"})
        public String login(@ModelAttribute("user") UsuarioModel user ) {
    
            UsuarioModel oauthUser = userService.login(user.getEmail(), user.getPassword());
           
        
            System.out.print(oauthUser);
            if(Objects.nonNull(oauthUser))
            {
         
            return "redirect:/";
           
           
            } else {
            return "redirect:/login";
           
           
            }

}

        private UsuarioModel login(String nombre, String password) {
            return null;
        }
}
