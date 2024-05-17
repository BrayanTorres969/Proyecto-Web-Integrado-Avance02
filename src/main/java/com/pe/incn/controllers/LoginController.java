package com.pe.incn.controllers;

import com.pe.incn.models.Usuario;
import com.pe.incn.services.UsuarioServiceImpl;
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
    public String showLoginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String usuario, @RequestParam String contra, Model model){

        Usuario usuarioLogin = usuarioService.login(usuario, contra);

        if (usuarioLogin != null){
            System.out.println("login exitoso");
            return "redirect:/home";
        }else {
            model.addAttribute("error", "Usuario o contraseña incorrectos. Inténtelo de nuevo.");
            return "login";
        }

    }

}
