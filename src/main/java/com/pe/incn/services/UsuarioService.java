package com.pe.incn.services;

import com.pe.incn.models.Usuario;


public interface UsuarioService {

	Usuario login(String username, String password);

}
