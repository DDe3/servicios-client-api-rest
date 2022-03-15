package com.example.demo.cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.to.Estudiante;
import com.example.demo.to.ListaEstudiante;

@Service
//@Component
public class EstudianteCliente {
	
	private static final String URL_API_ESTUDIANTE="http://localhost:8080/ApiEstudiantes/V2/estudiantes";
	
	
	//@Autowired
	private RestTemplate restTemplate;
	
	
	public Estudiante consultarEstudiante(Integer id) {
		// http://localhost:8080/ApiEstudiantes/V2/estudiantes/4
		
		restTemplate = new RestTemplate();
		
		
		Map<String, Integer> pathVariable = new HashMap<>();
		pathVariable.put("idEstudiante", id);
		Estudiante ret = restTemplate.getForObject(URL_API_ESTUDIANTE+"/{idEstudiante}", Estudiante.class, pathVariable);
		return ret;
		//Si no necesito mandar algo
		//restTemplate.getForObject(URL_API_ESTUDIANTE", Estudiante.class);
	}
	
	public List<Estudiante> consultarEstudiantes(Integer edad) {
		// http://localhost:8080/ApiEstudiantes/V2/estudiantes?edad=0
		restTemplate = new RestTemplate();
		ListaEstudiante lista = restTemplate.getForObject(URL_API_ESTUDIANTE+"/test?edad="+edad.toString(), ListaEstudiante.class);
		return lista.getLista();
	}
	
	public List<Estudiante> consultarEstudiantes2(Integer edad) {
		// http://localhost:8080/ApiEstudiantes/V2/estudiantes?edad=0
		restTemplate = new RestTemplate();
		Estudiante[] lista = restTemplate.getForObject(URL_API_ESTUDIANTE+"/test?edad="+edad.toString(), Estudiante[].class);
		return Arrays.asList(lista);
	}
	
	public String actualizar(Estudiante estu, Integer id)
	{
		restTemplate = new RestTemplate();
		Map<String, Integer> pathVariable = new HashMap<>();
		pathVariable.put("idEstudiante", id);
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        restTemplate.setRequestFactory(requestFactory);
		//restTemplate.put(URL_API_ESTUDIANTE+"/{idEstudiante}", estu, String.class, pathVariable);
		return restTemplate.patchForObject(URL_API_ESTUDIANTE+"/{idEstudiante}", estu, String.class, pathVariable);
	}
	
	public String insertar(Estudiante estu)
	{
		restTemplate = new RestTemplate();
		return restTemplate.postForObject(URL_API_ESTUDIANTE, estu, String.class);
	}
	
	/*
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	*/
	
}
