package com.tez.hrMvc.dao;
// Generated 23 f�vr. 2018 16:09:19 by Hibernate Tools 4.3.5.Final

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tez.hrMvc.model.UsrMen;

/**
 * Home object for domain model class UsrMen.
 * @see com.tez.hrMvc.dao.UsrMen
 * @author Hibernate Tools
 */
@Transactional
@Repository
public class UsrMenDao {

	private static final Log log = LogFactory.getLog(UsrMenDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(UsrMen transientInstance) {
		log.debug("persisting UsrMen instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(UsrMen persistentInstance) {
		log.debug("removing UsrMen instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public UsrMen merge(UsrMen detachedInstance) {
		log.debug("merging UsrMen instance");
		try {
			UsrMen result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UsrMen findById(String id) {
		log.debug("getting UsrMen instance with id: " + id);
		try {
			UsrMen instance = entityManager.find(UsrMen.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
