package com.Yoboss1.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Yoboss1.modelo.*;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

	public Usuario findByEmail(String email);
	
}
