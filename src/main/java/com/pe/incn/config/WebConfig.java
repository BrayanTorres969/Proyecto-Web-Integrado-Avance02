package com.pe.incn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
    private LoginInterceptor loginInterceptor;
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/home", "/residentes/**","/universidades/**","/especialidades/**") // Agrega aquí todas las rutas que deseas proteger
                .excludePathPatterns("/login", "/logout", "/resources/**", "/static/**"); // Excluye las rutas públicas
    }

}
