package com.erojas.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.erojas.model.Puesto;
import com.erojas.repository.PuestoDAO;
import com.erojas.service.PuestoService;

@Named
@RequestScoped
public class PuestoServiceImpl implements PuestoService{
	@EJB
	private PuestoDAO dao;

	@Override
	public void registrar(Puesto t) throws Exception {
		dao.registrar(t);		
	}

	@Override
	public void modificar(Puesto t) throws Exception {
		dao.modificar(t);		
	}

	@Override
	public List<Puesto> listar() throws Exception {
		return dao.listar();
	}

	@Override
	public Puesto listarPorId(Puesto t) throws Exception {		
		return dao.listarPorId(t);
	}	
}
