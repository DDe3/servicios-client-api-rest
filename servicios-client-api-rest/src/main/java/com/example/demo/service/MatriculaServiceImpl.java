package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Links;
import org.springframework.stereotype.Service;

import com.example.demo.cliente.EstudianteCliente;
import com.example.demo.to.CuentaBancariaTo;
import com.example.demo.to.CuentaHabienteTo;
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

	@Override
	public void gestionCuentaHabientes() {
		List<CuentaHabienteTo> chts = estudianteCliente.buscarTodos();

		chts.forEach(ch -> {
			List<Link> links = ch.getLinks().toList();
			links.forEach(l -> System.out.println(l.getHref()));
			System.out.println("/////////////////");
			ch.getCuentas().forEach( cb -> {
				List<Link> linksCB = cb.getLinks().toList();
				linksCB.forEach(l -> System.out.println(l.getHref()));
			});
		});
		System.out.println("/////////////////////");
		String url = chts.get(0).getLinks().toList().get(0).getHref();
		CuentaHabienteTo chto = estudianteCliente.buscarCuentaHabiente(url);
		System.out.println(chto);
	}
	
	
	
	
	
}
