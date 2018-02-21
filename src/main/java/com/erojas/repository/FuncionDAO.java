package com.erojas.repository;

import java.util.List;

import javax.ejb.Local;

import com.erojas.model.Funcion;
import com.erojas.model.Puesto;

@Local
public interface FuncionDAO  {

	public List<Funcion> listar(Puesto p) throws Exception;
}
