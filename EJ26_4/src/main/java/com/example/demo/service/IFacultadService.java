package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Facultad;

public interface IFacultadService {

	// Metodos del CRUD
	public List<Facultad> listarFacultad();

	public Facultad guardarFacultad(Facultad facultad);

	public Facultad facultadXID(int codigo);

	public Facultad actualizarFacultad(Facultad facultad);

	public void eliminarFacultad(int codigo);

}
