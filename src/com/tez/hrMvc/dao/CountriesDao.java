package com.tez.hrMvc.dao;
// Generated 17 janv. 2018 10:02:34 by Hibernate Tools 4.3.5.Final

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tez.hrMvc.model.Countries;

/**
 * Home object for domain model class Countries.
 * @see com.tez.hrMvc.dao.Countries
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class CountriesDao {

	private static final Log log = LogFactory.getLog(CountriesDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Countries transientInstance) {
		log.debug("persisting Countries instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Countries persistentInstance) {
		log.debug("removing Countries instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Countries merge(Countries detachedInstance) {
		log.debug("merging Countries instance");
		try {
			Countries result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Countries findById(String id) {
		log.debug("getting Countries instance with id: " + id);
		try {
			Countries instance = entityManager.find(Countries.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Countries> findAll()
	{
		Query query = entityManager.createQuery("FROM Countries");
		@SuppressWarnings("unchecked")
		List<Countries> countries = query.getResultList();
		return countries;

	}

	public void supp(String id) {
		String hql = "DELETE FROM Countries E WHERE E.countryId =:id ";
		Query query = entityManager.createQuery(hql);
		query.setParameter("id", id);
		int result = query.executeUpdate();
	}
}
