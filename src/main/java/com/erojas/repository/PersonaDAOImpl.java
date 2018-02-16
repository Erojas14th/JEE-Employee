package com.erojas.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.erojas.model.Persona;

@Stateless
public class PersonaDAOImpl implements PersonaDAO {

	@PersistenceContext(unitName = "EmployeePU")
	private EntityManager em;

	@Override
	public void registrar(Persona t) throws Exception {
		try {

			em.persist(t);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void modificar(Persona t) throws Exception {
		try {

			em.merge(t);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Persona> listar() throws Exception {
		List<Persona> lista = null;
		try {

			Query query = em.createQuery("FROM persona");
			lista = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public Persona listarPorId(Persona t) throws Exception {
		Persona per = new Persona();
		try {

			per = em.find(Persona.class, t.getIdPersona());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return per;
	}

}
