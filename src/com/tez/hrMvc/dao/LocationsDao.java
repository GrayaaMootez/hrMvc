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

import com.tez.hrMvc.model.Locations;

/**
 * Home object for domain model class Locations.
 *
 * @see com.tez.hrMvc.dao.Locations
 * @author Hibernate Tools
 */

@Repository
@Transactional
public class LocationsDao {

	private static final Log log = LogFactory.getLog(LocationsDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Locations transientInstance) {
		log.debug("persisting Locations instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Locations persistentInstance) {
		log.debug("removing Locations instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Locations merge(Locations detachedInstance) {
		log.debug("merging Locations instance");
		try {
			Locations result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Locations findById(Integer id) {
		log.debug("getting Locations instance with id: " + id);
		try {
			Locations instance = entityManager.find(Locations.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Locations> findAll() {
		Query query = entityManager.createQuery("FROM Locations");
		return query.getResultList();
	}

	public void supp(Integer id) {
		Query query = entityManager.createQuery("DELETE FROM Locations WHERE locationId=:id");
		query.setParameter("id", id);
		query.executeUpdate();

	}
}
