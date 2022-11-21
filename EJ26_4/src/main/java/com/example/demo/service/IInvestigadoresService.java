package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Investigadores;

public interface IInvestigadoresService {

	// Metodos del CRUD
	public List<Investigadores> listarInvestigadores();

	public Investigadores guardarInvestigadores(Investigadores investigadores);

	public Investigadores investigadoresXID(String dni);

	public Investigadores actualizarInvestigadores(Investigadores investigadores);

	public void eliminarInvestigadores(String investigadores);

}
