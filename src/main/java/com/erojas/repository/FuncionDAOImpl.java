package com.erojas.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.erojas.model.Funcion;
import com.erojas.model.Puesto;


@Stateless
public class FuncionDAOImpl implements FuncionDAO{

	@PersistenceContext(unitName = "EmployeePU")
	private EntityManager em;
	
	@Override
	public List<Funcion> listar(Puesto p) throws Exception {
		List<Funcion> lista = null;
		Query query = em.createQuery("FROM funcion f where f.puesto.idPuesto = ?1");
		query.setParameter(1, p.getIdPuesto());
		
		lista = (List<Funcion>)query.getResultList();
		return lista;
	}

}
