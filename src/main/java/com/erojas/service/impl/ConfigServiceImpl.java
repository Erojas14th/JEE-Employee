package com.erojas.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.erojas.model.Config;
import com.erojas.repository.ConfigDAO;
import com.erojas.service.ConfigService;

@Named
@RequestScoped
public class ConfigServiceImpl implements ConfigService{

	@EJB
	private ConfigDAO dao;
	
	@Override
	public void registrar(Config t) throws Exception {
		dao.registrar(t);		
	}

	@Override
	public void modificar(Config t) throws Exception {
		dao.modificar(t);		
	}

	@Override
	public List<Config> listar() throws Exception {
		return dao.listar();
	}

	@Override
	public Config listarPorId(Config t) throws Exception { 
		return dao.listarPorId(t);
	}


	
}
