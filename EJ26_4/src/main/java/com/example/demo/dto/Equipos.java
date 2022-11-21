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
@Table(name = "equipos")
public class Equipos {

	// Atributos de entidad Equipos
	@Id
	private String numserie;
	@Column(name = "nombre")
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "facultad")
	private Facultad facultad;
	@OneToMany
	@JoinColumn(name = "numserie")
	private List<Reserva> reserva;

	// Constructores

	public Equipos() {

	}

	public Equipos(String numserie, String nombre, Facultad facultad) {
		this.numserie = numserie;
		this.nombre = nombre;
		this.facultad = facultad;

	}

	// Getters y Setters

	public String getNumserie() {
		return numserie;
	}

	public void setNumserie(String numserie) {
		this.numserie = numserie;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	/**
	 * @return the usuario
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "numserie")
	public List<Reserva> getReserva() {
		return reserva;
	}

	/**
	 * @param usuario the video to set
	 */
	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	// Metodo impresion de datos por consola

	@Override
	public String toString() {
		return "Equipos [numserie=" + numserie + ", nombre=" + nombre + ", facultad=" + facultad + "]";
	}
}