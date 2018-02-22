package com.erojas.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.erojas.model.Config;

@Stateless
public class ConfigDAOImpl  implements ConfigDAO{

	@PersistenceContext(unitName = "EmployeePU")
	private EntityManager em;
	
	@Override
	public void registrar(Config t) throws Exception {
		em.persist(t);
		
	}

	@Override
	public void modificar(Config t) throws Exception {
		em.merge(t);
		
	}

	@Override
	public List<Config> listar() throws Exception {
		List<Config> lista = null;
		Query query = em.createQuery("FROM config ");
		lista = (List<Config>) query.getResultList();
		return lista;
	}

	@Override
	public Config listarPorId(Config t) throws Exception {
		Config conf = new Config();
		List<Config> lista = new ArrayList<>();
		Query query = em.createQuery("FROM config c where c.id = ?1");
		query.setParameter(1, t.getId());

		lista = (List<Config>) query.getResultList();

		if (lista != null && !lista.isEmpty()) {
			conf = lista.get(0);
		}
		return conf;
	}
	
}
