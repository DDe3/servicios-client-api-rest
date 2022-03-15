package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.cliente.EstudianteCliente;
import com.example.demo.service.IMatriculaService;
import com.example.demo.to.Estudiante;

@SpringBootApplication
public class ServiciosClientApiRestApplication implements CommandLineRunner {

	@Autowired
	private IMatriculaService matriculaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ServiciosClientApiRestApplication.class, args);
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		System.out.println("HOLA");
		this.matriculaService.gestionMatricula();
		
	}

}
