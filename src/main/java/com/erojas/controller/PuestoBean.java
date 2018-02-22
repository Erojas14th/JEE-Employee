package com.erojas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.erojas.model.Funcion;
import com.erojas.model.Puesto;
import com.erojas.service.FuncionService;
import com.erojas.service.PuestoService;

@Named
@ViewScoped
public class PuestoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Inject
	private PuestoService puestoService;
	@Inject
	private FuncionService funcionService;
	@Inject
	private Funcion funcion;
	@Inject
	private Puesto puesto;
	private List<Puesto> lstPuestos;
	private List<Funcion> lstFunciones;

	@PostConstruct
	public void init() {
		lstPuestos = new ArrayList<>();
		lstFunciones = new ArrayList<>();
		this.listar();
	}

	public void listar() {
		try {
			lstPuestos = puestoService.listar();
		} catch (Exception e) {

		}

	}

	public void seleccionar(Puesto pue) throws Exception {
		puesto = puestoService.listarPorId(pue);
		this.lstFunciones = funcionService.listar(puesto);
	}

	public void operar() throws Exception {
		puesto.setFunciones(lstFunciones);

		if (puesto.getIdPuesto() > 0) {
			puestoService.modificar(puesto);
		} else {
			puestoService.registrar(puesto);
		}

		// this.limpiarControles();
		this.listar();
	}

	public void agregar() {
		Funcion func = new Funcion();
		func.setNombre(funcion.getNombre());
		func.setDescripcion(funcion.getDescripcion());
		func.setPuesto(puesto);
		this.getLstFunciones().add(func);
	}

	public void remover(Funcion func) {
		this.lstFunciones.remove(func);
	}

	public void limpiarControles() {
		this.puesto.setFunciones(new ArrayList<>());
		this.lstFunciones.clear();
		this.lstFunciones = new ArrayList<>();
		this.puesto.setIdPuesto(0);
		this.puesto.setNombre(null);
		this.puesto.setSalarioBase(0.0);
		this.funcion.setIdFuncion(0);
		this.funcion.setNombre(null);
		this.funcion.setPuesto(null);
	}

	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	public Puesto getPuesto() {
		return puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}

	public List<Puesto> getLstPuestos() {
		return lstPuestos;
	}

	public void setLstPuestos(List<Puesto> lstPuestos) {
		this.lstPuestos = lstPuestos;
	}

	public List<Funcion> getLstFunciones() {
		return lstFunciones;
	}

	public void setLstFunciones(List<Funcion> lstFunciones) {
		this.lstFunciones = lstFunciones;
	}

	
}
