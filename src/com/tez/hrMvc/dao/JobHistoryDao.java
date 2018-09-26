package com.tez.hrMvc.dao;
// Generated 17 janv. 2018 10:02:34 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tez.hrMvc.model.JobHistory;
import com.tez.hrMvc.model.JobHistoryId;

/**
 * Home object for domain model class JobHistory.
 *
 * @see com.tez.hrMvc.dao.JobHistory
 * @author Hibernate Tools
 */

@Repository
@Transactional
public class JobHistoryDao {

	private static final Log log = LogFactory.getLog(JobHistoryDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(JobHistory transientInstance) {
		log.debug("persisting JobHistory instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(JobHistory persistentInstance) {
		log.debug("removing JobHistory instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public JobHistory merge(JobHistory detachedInstance) {
		log.debug("merging JobHistory instance");
		try {
			JobHistory result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public JobHistory findById(JobHistoryId id) {
		log.debug("getting JobHistory instance with id: " + id);
		try {
			JobHistory instance = entityManager.find(JobHistory.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<JobHistory> findAll() {
		Query query = entityManager.createQuery("FROM JobHistory");
		return query.getResultList();
	}

	public JobHistory findById2(int emp, Date d) {
		Query query = entityManager
				.createQuery("FROM JobHistory e where e.id.employeeId=:id and e.id.startDate=:d");
		query.setParameter("id", emp);
		query.setParameter("d", d);
		return (JobHistory) query.getSingleResult();
	}
}
