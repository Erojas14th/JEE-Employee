package com.erojas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.erojas.model.Config;
import com.erojas.service.ConfigService;

@Named
@ViewScoped
public class ConfigBean implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ConfigService service;
	@Inject
	private Config config;
	private List<Config> lstConfig;

	@PostConstruct
	public void init() {
		lstConfig = new ArrayList<>();
		this.listar();
	}

	public void listar() {
		try {
			lstConfig = service.listar();
		} catch (Exception e) {

		}

	}

	public void seleccionar(Config con) throws Exception {
		Thread.sleep(3000);
		config = service.listarPorId(con);
	}

	public void operar() throws Exception {
		Thread.sleep(3000);
		if (config.getId() > 0) {
			service.modificar(config);
		} else {
			service.registrar(config);
		}

		// this.limpiarControles();
		this.listar();		
	}

	public void agregar() {
		Config conf = new Config();
		conf.setNombre(config.getNombre());
		conf.setValor(config.getValor());
		this.lstConfig.add(conf);
	}

	public void remover(Config conf) {
		this.lstConfig.remove(conf);
	}

	public void limpiarControles() {
		this.lstConfig.clear();
		this.lstConfig = new ArrayList<>();
		this.config.setId((short) 0);
		this.config.setNombre(null);
		this.config.setValor(null);
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public List<Config> getLstConfig() {
		return lstConfig;
	}

	public void setLstConfig(List<Config> lstConfig) {
		this.lstConfig = lstConfig;
	}
	
}
