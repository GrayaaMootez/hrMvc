package com.tez.hrMvc.dao;
// Generated 17 janv. 2018 10:02:34 by Hibernate Tools 4.3.5.Final

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tez.hrMvc.model.EmpDetailsView;
import com.tez.hrMvc.model.EmpDetailsViewId;

/**
 * Home object for domain model class EmpDetailsView.
 * @see com.tez.hrMvc.dao.EmpDetailsView
 * @author Hibernate Tools
 */

@Repository
@Transactional
public class EmpDetailsViewDao {

	private static final Log log = LogFactory.getLog(EmpDetailsViewDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(EmpDetailsView transientInstance) {
		log.debug("persisting EmpDetailsView instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(EmpDetailsView persistentInstance) {
		log.debug("removing EmpDetailsView instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public EmpDetailsView merge(EmpDetailsView detachedInstance) {
		log.debug("merging EmpDetailsView instance");
		try {
			EmpDetailsView result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EmpDetailsView findById(EmpDetailsViewId id) {
		log.debug("getting EmpDetailsView instance with id: " + id);
		try {
			EmpDetailsView instance = entityManager.find(EmpDetailsView.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
