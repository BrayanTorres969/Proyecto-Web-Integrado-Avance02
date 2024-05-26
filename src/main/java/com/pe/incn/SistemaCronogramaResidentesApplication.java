package com.pe.incn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.pe.incn")
public class SistemaCronogramaResidentesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaCronogramaResidentesApplication.class, args);
	}

}
