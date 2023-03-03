package com.YobossApp_11.Yobossapp.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.YobossApp_11.Yobossapp.models.UsuarioModel;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final UsuarioModel usuarioModel;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return usuarioModel.getPassword();
    }
    @Override
    public String getUsername() {
        return usuarioModel.getEmail();
    }
    @Override
    public boolean isAccountNonExpired() {
        
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        
        return true;
        }

    @Override
    public boolean isCredentialsNonExpired() {
        
        return true;
    }

    @Override
    public boolean isEnabled() {
        
        return true;   }

  
    public String getNombre(){
        return usuarioModel.getNombre();
    }

}
