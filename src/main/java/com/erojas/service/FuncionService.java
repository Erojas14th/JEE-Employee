package com.erojas.service;

import java.util.List;

import com.erojas.model.Funcion;
import com.erojas.model.Puesto;

public interface FuncionService {
	public List<Funcion> listar(Puesto p) throws Exception;
}
