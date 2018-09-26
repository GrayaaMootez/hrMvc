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

import com.tez.hrMvc.model.Regions;

/**
 * Home object for domain model class Regions.
 *
 * @see com.tez.hrMvc.dao.Regions
 * @author Hibernate Tools
 */

@Repository
@Transactional
public class RegionsDao {

	private static final Log log = LogFactory.getLog(RegionsDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Regions transientInstance) {
		log.debug("persisting Regions instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Regions persistentInstance) {
		log.debug("removing Regions instance");
		try {
			entityManager.remove(entityManager.contains(persistentInstance) ? persistentInstance
					: entityManager.merge(persistentInstance));
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Regions merge(Regions detachedInstance) {
		log.debug("merging Regions instance");
		try {
			Regions result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Regions findById(Integer id) {
		log.debug("getting Regions instance with id: " + id);
		try {
			Regions instance = entityManager.find(Regions.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Regions> findAll() {
		Query query = entityManager.createQuery("FROM Regions");
		@SuppressWarnings("unchecked")
		List<Regions> regions = query.getResultList();
		return regions;

	}

	public void supp(Integer id) {
		String hql = "DELETE FROM Regions E WHERE E.id.regionId =:id ";
		Query query = entityManager.createQuery(hql);
		query.setParameter("id", id);
		int result = query.executeUpdate();
	}

}
