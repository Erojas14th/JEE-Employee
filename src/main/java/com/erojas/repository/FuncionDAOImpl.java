package com.erojas.repository;

import java.util.List;

import javax.ejb.Stateless;

import com.erojas.model.Funcion;
import com.erojas.model.Puesto;


@Stateless
public class FuncionDAOImpl implements FuncionDAO{

	@Override
	public List<Funcion> listar(Puesto p) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
