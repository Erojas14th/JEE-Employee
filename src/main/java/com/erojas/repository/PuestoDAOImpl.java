package com.erojas.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.erojas.model.Persona;
import com.erojas.model.Puesto;

@Stateless
public class PuestoDAOImpl implements PuestoDAO{

	@PersistenceContext(unitName = "EmployeePU")
	private EntityManager em;
	
	
	@Override
	public void registrar(Puesto t) throws Exception {
		em.persist(t);
		
	}

	@Override
	public void modificar(Puesto t) throws Exception {
		 em.merge(t);
		
	}

	@Override
	public List<Puesto> listar() throws Exception {
		List<Puesto> lista = null;
		try {

			Query query = em.createQuery("FROM puesto");
			lista = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public Puesto listarPorId(Puesto t) throws Exception {
		Puesto pues = new Puesto();
		try {

			pues = em.find(Puesto.class, t.getIdPuesto());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pues;
	}

}
