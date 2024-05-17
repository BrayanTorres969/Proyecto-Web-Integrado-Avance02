package com.pe.incn.services;

import com.pe.incn.models.Usuario;
import com.pe.incn.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario login(String username, String password) {
		return usuarioRepository.findByUsernameAndPassword(username, password);
	}

}
