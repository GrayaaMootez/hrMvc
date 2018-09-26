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

import com.tez.hrMvc.model.Jobs;

/**
 * Home object for domain model class Jobs.
 *
 * @see com.tez.hrMvc.dao.Jobs
 * @author Hibernate Tools
 */

@Repository
@Transactional
public class JobsDao {

	private static final Log log = LogFactory.getLog(JobsDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Jobs transientInstance) {
		log.debug("persisting Jobs instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Jobs persistentInstance) {
		log.debug("removing Jobs instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Jobs merge(Jobs detachedInstance) {
		log.debug("merging Jobs instance");
		try {
			Jobs result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Jobs findById(String id) {
		log.debug("getting Jobs instance with id: " + id);
		try {
			Jobs instance = entityManager.find(Jobs.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Jobs> findAll() {
		Query query = entityManager.createQuery("FROM Jobs");
		@SuppressWarnings("unchecked")
		List<Jobs> jobs = query.getResultList();
		return jobs;

	}

	public void supp(String id) {
		String hql = "DELETE FROM Jobs E WHERE E.jobId =:id ";
		Query query = entityManager.createQuery(hql);
		query.setParameter("id", id);
		int result = query.executeUpdate();
	}

}
