package com.pe.incn.controllers;

import com.pe.incn.models.Usuario;
import com.pe.incn.services.UsuarioServiceImpl;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@Autowired
	private UsuarioServiceImpl usuarioService;

	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}

	@PostMapping("/login")
	public String processLogin(@RequestParam String usuario, @RequestParam String contra, Model model,
			HttpSession session) {

		Usuario usuarioLogin = usuarioService.login(usuario, contra);

		if (usuarioLogin != null) {
			System.out.println(usuarioLogin.getUsername());
			// model.addAttribute("usuarioLogin", usuarioLogin);
			session.setAttribute("usuarioLogin", usuarioLogin);
			return "redirect:/home";
		} else {
			model.addAttribute("error", "Usuario o contraseña incorrectos. Inténtelo de nuevo.");
			return "login";
		}

	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

}
