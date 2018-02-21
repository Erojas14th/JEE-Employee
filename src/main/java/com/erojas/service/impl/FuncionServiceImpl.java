package com.erojas.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.erojas.model.Funcion;
import com.erojas.model.Puesto;
import com.erojas.repository.FuncionDAO;
import com.erojas.service.FuncionService;

@Named
public class FuncionServiceImpl implements FuncionService{
	@EJB
	private FuncionDAO dao;

	@Override
	public List<Funcion> listar(Puesto p) throws Exception {
		return dao.listar(p);
	}
}
