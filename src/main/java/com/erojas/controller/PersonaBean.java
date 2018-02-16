package com.erojas.controller;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

import com.erojas.model.Persona;
import com.erojas.service.PersonaService;

@Named
@RequestScoped
public class PersonaBean {

	@Inject
	private PersonaService ps;
	private List<Persona> lstPersonas;
	@Inject
	private Persona persona;
	private Date fechaSeleccionada;
	private UploadedFile foto;
	private String titulo;
	
	@PostConstruct
	public void init() {
		this.listar();
		this.titulo = "Registrar";
	}
	
	// Metodos
	
	public void seleccionar(Persona per) throws Exception {
		persona = ps.listarPorId(per);
		Calendar cal = Calendar.getInstance();
		cal.set(persona.getFechaNac().getYear(), persona.getFechaNac().getMonthValue(),
				persona.getFechaNac().getDayOfMonth());
		this.fechaSeleccionada = cal.getTime();
		this.titulo = "Modificar";
	}

	public void operar() {
		try {
			if (foto != null) {
				persona.setFoto(foto.getContents());
			}

			if (fechaSeleccionada != null) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(fechaSeleccionada);
				LocalDate local = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
				persona.setFechaNac(local);
			}

			if (persona.getIdPersona() > 0) {
				ps.modificar(persona);
			} else {
				ps.registrar(persona);
			}
			this.listar();
		} catch (Exception e) {

		}
	}

	public void listar() {
		try {
			lstPersonas = ps.listar();
		} catch (Exception e) {

		}

	}
	
	
	
	
	// Getter and setters......

	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}

	public void setLstPersonas(List<Persona> lstPersonas) {
		this.lstPersonas = lstPersonas;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Date getFechaSeleccionada() {
		return fechaSeleccionada;
	}

	public void setFechaSeleccionada(Date fechaSeleccionada) {
		this.fechaSeleccionada = fechaSeleccionada;
	}

	public UploadedFile getFoto() {
		return foto;
	}

	public void setFoto(UploadedFile foto) {
		this.foto = foto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	
}
