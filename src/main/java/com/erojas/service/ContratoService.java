package com.erojas.service;

import com.erojas.model.Contrato;
import com.erojas.model.Persona;

public interface ContratoService  extends Service<Contrato>{
	int getSiguientePK(Persona persona);
}
