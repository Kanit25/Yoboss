package com.YobossApp_11.Yobossapp.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.YobossApp_11.Yobossapp.models.UsuarioModel;
import com.YobossApp_11.Yobossapp.repositories.UsuarioRepository;



@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       UsuarioModel usuario = usuarioRepository
            .findOneByEmail(email)
            .orElseThrow(()-> new UsernameNotFoundException("El usuerio con el email"+email+"no existe."));

        return new UserDetailsImpl(usuario);

    }

    
    
}
