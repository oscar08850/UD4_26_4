package com.example.demo.dto;

import java.sql.Date;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "reserva")
public class Reserva {
	// Atributos de entidad reserva
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "comienzo")
	private Date comienzo;
	@Column(name = "fin")
	private Date fin;

	@ManyToOne
	@JoinColumn(name = "numserie")
	private Equipos numserie;
	@ManyToOne
	@JoinColumn(name = "dni")
	private Investigadores dni;

	// Constructores

	public Reserva() {
	}

	public Reserva(int id, Equipos numserie, Investigadores dni, Date comienzo, Date fin) {
		this.id = id;
		this.numserie = numserie;
		this.dni = dni;
		this.comienzo = comienzo;
		this.fin = fin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getComienzo() {
		return comienzo;
	}

	public void setComienzo(Date comienzo) {
		this.comienzo = comienzo;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public Equipos getNumserie() {
		return numserie;
	}

	public void setNumserie(Equipos numserie) {
		this.numserie = numserie;
	}

	public Investigadores getDni() {
		return dni;
	}

	public void setDni(Investigadores dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", comienzo=" + comienzo + ", fin=" + fin + ", numserie=" + numserie + ", dni="
				+ dni + "]";
	}

}
