package com.example.demo.to;

import java.io.Serializable;
import java.math.BigDecimal;


import org.springframework.hateoas.RepresentationModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class CuentaBancariaTo extends RepresentationModel<CuentaBancariaTo> implements Serializable {
	
	private Integer id;
	private String nombre;
	private BigDecimal saldo;
;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "CuentaBancariaTo [id=" + id + ", nombre=" + nombre + ", saldo=" + saldo;
	}
	
	
	
	
	
	

}
