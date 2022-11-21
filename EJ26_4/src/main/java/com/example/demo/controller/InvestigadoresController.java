package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.Investigadores;
import com.example.demo.service.InvestigadoresServiceImpl;


@RestController
@RequestMapping("/api")

public class InvestigadoresController {

	
	@Autowired
	InvestigadoresServiceImpl InvestigadoresServiceImpl;
	
	@GetMapping("/investigadores")
	public List<Investigadores> listarInvestigadores(){
		return InvestigadoresServiceImpl.listarInvestigadores();
	}
	
	@PostMapping("/investigadores")
	public Investigadores salvarInvestigadores(@RequestBody Investigadores investigadores) {
		
		return InvestigadoresServiceImpl.guardarInvestigadores(investigadores);
	}
	
	@GetMapping("/investigadores/{dni}")
	public Investigadores investigadoresXID(@PathVariable(name="dni") String dni) {
		
		Investigadores investigadores_xid= new Investigadores();
		
		investigadores_xid=InvestigadoresServiceImpl.investigadoresXID(dni);
		
		System.out.println("Investigadores XID: "+investigadores_xid);
		
		return investigadores_xid;
	}
	
	@PutMapping("/investigadores/{dni}")
	public Investigadores actualizarInvestigadores(@PathVariable(name="dni")String dni,@RequestBody Investigadores investigadores) {
		
		Investigadores investigadores_seleccionado= new Investigadores();
		Investigadores investigadores_actualizado= new Investigadores();
		
		investigadores_seleccionado= InvestigadoresServiceImpl.investigadoresXID(dni);
		investigadores_seleccionado.setNomapels(investigadores.getNomapels());
		investigadores_seleccionado.setFacultad(investigadores.getFacultad());

		investigadores_actualizado = InvestigadoresServiceImpl.actualizarInvestigadores(investigadores_seleccionado);
		
		System.out.println("Los investigadores actualizado es: "+ investigadores_actualizado);
		
		return investigadores_actualizado;
	}
	
	@DeleteMapping("/investigadores/{dni}")
	public void eleiminarInvestigadores(@PathVariable(name="dni")String dni) {
		InvestigadoresServiceImpl.eliminarInvestigadores(dni);
	}
	
	
}