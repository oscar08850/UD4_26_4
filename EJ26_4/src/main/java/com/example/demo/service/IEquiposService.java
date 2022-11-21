package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Equipos;

public interface IEquiposService {

	// Metodos del CRUD
	public List<Equipos> listarEquipos();l

	public Equipos guardarEquipos(Equipos equipos);

	public Equipos equiposXID(String numserie);

	public Equipos actualizarEquipos(Equipos equipos);

	public void eliminarEquipos(String numserie);

}
