package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cliente.EstudianteCliente;
import com.example.demo.to.Estudiante;

@Service
public class MatriculaServiceImpl implements IMatriculaService{

	@Autowired
	private EstudianteCliente estudianteCliente;
	
	@Override
	public void gestionMatricula() {
		Estudiante e = estudianteCliente.consultarEstudiante(4);
		System.out.println(e);
		List<Estudiante> estudiantes = estudianteCliente.consultarEstudiantes(0);
		estudiantes.forEach(es -> System.out.println(es));
		//System.out.println(estudiantes);
		//Estudiante estu = new Estudiante(null,"Fernando", "Guevara", "Magdalena", 20);
		//System.out.println(estudianteCliente.insertar(estu));
		Estudiante estu2 = new Estudiante(null,"Actualizado", "Guevara", "Magdalena", 20);
		System.out.println(estudianteCliente.actualizar(estu2, 4));
	}
	
	
	
}
