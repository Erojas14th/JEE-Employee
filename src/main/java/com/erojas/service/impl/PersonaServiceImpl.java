package com.erojas.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.erojas.model.Persona;
import com.erojas.repository.PersonaDAO;
import com.erojas.service.PersonaService;

@Named
@RequestScoped
public class PersonaServiceImpl implements PersonaService{

	@EJB
	private PersonaDAO dao;
	
	@Override
	public void registrar(Persona t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(Persona t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<Persona> listar() throws Exception {
		return dao.listar();
	}

	@Override
	public Persona listarPorId(Persona t) throws Exception {
		return dao.listarPorId(t);
	}

}
