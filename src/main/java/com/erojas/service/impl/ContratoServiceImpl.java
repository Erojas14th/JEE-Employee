package com.erojas.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.erojas.model.Contrato;
import com.erojas.model.Persona;
import com.erojas.repository.ContratoDAO;
import com.erojas.service.ContratoService;

@Named
@RequestScoped
public class ContratoServiceImpl implements ContratoService{

	@EJB
	private ContratoDAO dao;

	@Override
	public void registrar(Contrato t) throws Exception {		
		dao.registrar(t);
	}

	@Override
	public void modificar(Contrato t) throws Exception {
		dao.modificar(t);
	}

	@Override
	public List<Contrato> listar() throws Exception {		
		return dao.listar();
	}

	@Override
	public Contrato listarPorId(Contrato t) throws Exception {
		return dao.listarPorId(t);
	}

	@Override
	public int getSiguientePK(Persona persona) {
		
		return dao.getSiguientePK(persona);
	}


}
