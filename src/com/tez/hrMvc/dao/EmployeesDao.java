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

import com.tez.hrMvc.model.Employees;

/**
 * Home object for domain model class Employees.
 *
 * @see com.tez.hrMvc.dao.Employees
 * @author Hibernate Tools
 */

@Repository
@Transactional
public class EmployeesDao {

	private static final Log log = LogFactory.getLog(EmployeesDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Employees transientInstance) {
		log.debug("persisting Employees instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Employees persistentInstance) {
		log.debug("removing Employees instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Employees merge(Employees detachedInstance) {
		log.debug("merging Employees instance");
		try {
			Employees result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Employees findById(Integer id) {
		log.debug("getting Employees instance with id: " + id);
		try {
			Employees instance = entityManager.find(Employees.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Employees> findAll() {
		Query query = entityManager.createQuery("FROM Employees");
		return query.getResultList();
	}

	public void supp(Integer id) {
		Query query = entityManager.createQuery("DELETE FROM Employees where employeeId=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}
}
