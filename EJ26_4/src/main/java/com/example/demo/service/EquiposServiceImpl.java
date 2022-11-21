package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEquiposDAO;
import com.example.demo.dto.Equipos;

@Service
public class EquiposServiceImpl implements IEquiposService {

	@Autowired
	IEquiposDAO iEquiposDAO;

	@Override
	public List<Equipos> listarEquipos() {

		return iEquiposDAO.findAll();
	}

	@Override
	public Equipos guardarEquipos(Equipos equipos) {

		return iEquiposDAO.save(equipos);
	}

	@Override
	public Equipos equiposXID(String numserie) {

		return iEquiposDAO.findById(numserie).get();
	}

	@Override
	public Equipos actualizarEquipos(Equipos equipos) {

		return iEquiposDAO.save(equipos);
	}

	@Override
	public void eliminarEquipos(String numserie) {

		iEquiposDAO.deleteById(numserie);

	}

}