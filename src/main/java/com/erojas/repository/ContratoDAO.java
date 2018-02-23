package com.erojas.repository;

import javax.ejb.Local;

import com.erojas.model.Contrato;
import com.erojas.model.Persona;

@Local
public interface ContratoDAO extends DAO<Contrato> {
	int getSiguientePK(Persona persona);
}
