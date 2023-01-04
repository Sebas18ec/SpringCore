package com.pp.web.servicio;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.pp.web.dto.*;
import com.pp.web.entidad.*;


public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
	
	public Usuario actualizarUsuario(Usuario usuario);
	
	public void eliminarUsuario(Long id);
	
}
