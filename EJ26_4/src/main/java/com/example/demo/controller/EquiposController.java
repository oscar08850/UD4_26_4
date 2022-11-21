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
import com.example.demo.dto.Equipos;
import com.example.demo.service.EquiposServiceImpl;


@RestController
@RequestMapping("/api")

public class EquiposController {

	
	@Autowired
	EquiposServiceImpl EquiposServiceImpl;
	
	@GetMapping("/equipos")
	public List<Equipos> listarEquipos(){
		return EquiposServiceImpl.listarEquipos();
	}
	
	@PostMapping("/equipos")
	public Equipos salvarEquipos(@RequestBody Equipos equipos) {
		
		return EquiposServiceImpl.guardarEquipos(equipos);
	}
	
	@GetMapping("/equipos/{numserie}")
	public Equipos equiposXID(@PathVariable(name="numserie") String numserie) {
		
		Equipos equipo_xid= new Equipos();
		
		equipo_xid=EquiposServiceImpl.equiposXID(numserie);
		
		System.out.println("Equipo XID: "+equipo_xid);
		
		return equipo_xid;
	}
	
	@PutMapping("/equipos/{numserie}")
	public Equipos actualizarEquipos(@PathVariable(name="numserie")String numserie,@RequestBody Equipos equipos) {
		
		Equipos equipos_seleccionado= new Equipos();
		Equipos equipos_actualizado= new Equipos();
		
		equipos_seleccionado= EquiposServiceImpl.equiposXID(numserie);
		equipos_seleccionado.setNombre(equipos.getNombre());
		equipos_seleccionado.setFacultad(equipos.getFacultad());

		equipos_actualizado = EquiposServiceImpl.actualizarEquipos(equipos_seleccionado);
		
		System.out.println("El equipo actualizado es: "+ equipos_actualizado);
		
		return equipos_actualizado;
	}
	
	@DeleteMapping("/equipos/{numserie}")
	public void eleiminarEquipos(@PathVariable(name="numserie")String numserie) {
		EquiposServiceImpl.eliminarEquipos(numserie);
	}
	
	
}

