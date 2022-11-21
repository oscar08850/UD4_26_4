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
import com.example.demo.dto.Reserva;
import com.example.demo.service.ReservaServiceImpl;


@RestController
@RequestMapping("/api")

public class ReservaController {

	
	@Autowired
	ReservaServiceImpl ReservaServiceImpl;
	
	@GetMapping("/reservas")
	public List<Reserva> listarReserva(){
		return ReservaServiceImpl.listarReserva();
	}
	
	@PostMapping("/reservas")
	public Reserva salvarReservas(@RequestBody Reserva reserva) {
		
		return ReservaServiceImpl.guardarReserva(reserva);
	}
	
	@GetMapping("/reservas/{id}")
	public Reserva reservaXID(@PathVariable(name="id") int id) {
		
		Reserva reserva_xid= new Reserva();
		
		reserva_xid=ReservaServiceImpl.reservaXID(id);
		
		System.out.println("Reserva XID: "+reserva_xid);
		
		return reserva_xid;
	}
	
	@PutMapping("/reservas/{id}")
	public Reserva actualizarReserva(@PathVariable(name="id")int id,@RequestBody Reserva reserva) {
		
		Reserva reserva_seleccionado= new Reserva();
		Reserva reserva_actualizado= new Reserva();
		
		reserva_seleccionado= ReservaServiceImpl.reservaXID(id);
		reserva_seleccionado.setNumserie(reserva.getNumserie());
		reserva_seleccionado.setDni(reserva.getDni());
		reserva_seleccionado.setComienzo(reserva.getComienzo());
		reserva_seleccionado.setFin(reserva.getFin());

		reserva_actualizado = ReservaServiceImpl.actualizarReserva(reserva_seleccionado);
		
		System.out.println("La reserva actualizado es: "+ reserva_actualizado);
		
		return reserva_actualizado;
	}
	
	@DeleteMapping("/reservas/{id}")
	public void eleiminarReserva(@PathVariable(name="id")int id) {
		ReservaServiceImpl.eliminarReserva(id);
	}
	
	
}