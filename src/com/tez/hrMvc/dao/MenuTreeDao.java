package com.tez.hrMvc.dao;
// Generated 8 f�vr. 2018 09:35:12 by Hibernate Tools 4.3.5.Final

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tez.hrMvc.model.MenuTree;

/**
 * Home object for domain model class MenuTree.
 *
 * @see com.tez.hrMvc.dao.MenuTree
 * @author Hibernate Tools
 */
@Transactional
@Repository
public class MenuTreeDao {

	private static final Log log = LogFactory.getLog(MenuTreeDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(MenuTree transientInstance) {
		log.debug("persisting MenuTree instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(MenuTree persistentInstance) {
		log.debug("removing MenuTree instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public MenuTree merge(MenuTree detachedInstance) {
		log.debug("merging MenuTree instance");
		try {
			MenuTree result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MenuTree findById(Integer id) {
		log.debug("getting MenuTree instance with id: " + id);
		try {
			MenuTree instance = entityManager.find(MenuTree.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<MenuTree> findAll() {

		String hql = "FROM MenuTree m";
		Query query = entityManager.createQuery(hql);
		return query.getResultList();

	}

	public List<MenuTree> root() {

		String hql = "FROM MenuTree m where m.menuTree is null";
		Query query = entityManager.createQuery(hql);
		List<MenuTree> l = query.getResultList();
		return l;

	}
}
