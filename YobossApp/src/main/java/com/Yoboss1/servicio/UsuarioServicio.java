package com.Yoboss1.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.Yoboss1.controlador.dto.UsuarioRegistroDTO;
import com.Yoboss1.modelo.Usuario;


public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
	
}
