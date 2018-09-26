package com.tez.hrMvc.dao;
// Generated 23 f�vr. 2018 16:09:19 by Hibernate Tools 4.3.5.Final

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tez.hrMvc.model.Profil;

/**
 * Home object for domain model class Profil.
 * @see com.tez.hrMvc.dao.Profil
 * @author Hibernate Tools
 */
@Transactional
@Repository
public class ProfilDao {

	private static final Log log = LogFactory.getLog(ProfilDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Profil transientInstance) {
		log.debug("persisting Profil instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Profil persistentInstance) {
		log.debug("removing Profil instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Profil merge(Profil detachedInstance) {
		log.debug("merging Profil instance");
		try {
			Profil result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Profil findById(int id) {
		log.debug("getting Profil instance with id: " + id);
		try {
			Profil instance = entityManager.find(Profil.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
