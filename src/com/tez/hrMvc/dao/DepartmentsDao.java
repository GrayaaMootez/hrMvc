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

import com.tez.hrMvc.model.Departments;

/**
 * Home object for domain model class Departments.
 * @see com.tez.hrMvc.dao.Departments
 * @author Hibernate Tools
 */
@Repository
@Transactional
public class DepartmentsDao {

	private static final Log log = LogFactory.getLog(DepartmentsDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Departments transientInstance) {
		log.debug("persisting Departments instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Departments persistentInstance) {
		log.debug("removing Departments instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Departments merge(Departments detachedInstance) {
		log.debug("merging Departments instance");
		try {
			Departments result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Departments findById(Integer id) {
		log.debug("getting Departments instance with id: " + id);
		try {
			Departments instance = entityManager.find(Departments.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}


	public List<Departments> findAll() {
		Query query = entityManager.createQuery("FROM Departments");
		@SuppressWarnings("unchecked")
		List<Departments> deps = query.getResultList();
		return deps;

	}

	public void supp(Integer id) {
		String hql = "DELETE FROM Departments E WHERE E.departmentId =:id ";
		Query query = entityManager.createQuery(hql);
		query.setParameter("id", id);
		int result = query.executeUpdate();
	}
}
