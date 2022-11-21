package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.dto.Reserva;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="investigadores")
public class Investigadores {

	//Atributos de entidad investigadores
	@Id
	private String dni;
	@Column(name = "nomapels")
	private String nomapels;

	@ManyToOne
    @JoinColumn(name="facultad")
    private Facultad facultad;
    @OneToMany
    @JoinColumn(name="dni")
    private List<Reserva> reserva;
	
	//Constructores
	
	public Investigadores() {
	}

	public Investigadores(String dni, String nomapels, Facultad facultad) {
		this.dni = dni;
		this.nomapels = nomapels;
		this.facultad = facultad;
	}

	
	//Getters y Setters

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNomapels() {
		return nomapels;
	}

	public void setNomapels(String nomapels) {
		this.nomapels = nomapels;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dni")
	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	
	@Override
	public String toString() {
		return "Investigadores [dni=" + dni + ", nomapels=" + nomapels + ", facultad=" + facultad + "]";
	}

}