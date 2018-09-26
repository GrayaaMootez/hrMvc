package com.tez.hrMvc.dao;
// Generated 23 f�vr. 2018 16:09:19 by Hibernate Tools 4.3.5.Final

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tez.hrMvc.model.UsrMenTree;
import com.tez.hrMvc.model.UsrMenTreeId;

/**
 * Home object for domain model class UsrMenTree.
 * @see com.tez.hrMvc.dao.UsrMenTree
 * @author Hibernate Tools
 */
@Transactional
@Repository
public class UsrMenTreeDao {

	private static final Log log = LogFactory.getLog(UsrMenTreeDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(UsrMenTree transientInstance) {
		log.debug("persisting UsrMenTree instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(UsrMenTree persistentInstance) {
		log.debug("removing UsrMenTree instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public UsrMenTree merge(UsrMenTree detachedInstance) {
		log.debug("merging UsrMenTree instance");
		try {
			UsrMenTree result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UsrMenTree findById(UsrMenTreeId id) {
		log.debug("getting UsrMenTree instance with id: " + id);
		try {
			UsrMenTree instance = entityManager.find(UsrMenTree.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
