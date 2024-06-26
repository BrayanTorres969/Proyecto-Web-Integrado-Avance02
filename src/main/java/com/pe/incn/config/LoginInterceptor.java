package com.pe.incn.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor  {
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute("usuarioLogin") == null) {
        	System.out.println("Interceptado: Intento de acceso a ruta protegida sin iniciar sesión.");
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }

}
