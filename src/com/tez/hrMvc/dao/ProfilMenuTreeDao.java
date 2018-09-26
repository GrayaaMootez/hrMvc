package com.tez.hrMvc.dao;
// Generated 23 f�vr. 2018 16:09:19 by Hibernate Tools 4.3.5.Final

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tez.hrMvc.model.ProfilMenuTree;

/**
 * Home object for domain model class ProfilMenuTree.
 *
 * @see com.tez.hrMvc.dao.ProfilMenuTree
 * @author Hibernate Tools
 */
@Transactional
@Repository
public class ProfilMenuTreeDao {

	private static final Log log = LogFactory.getLog(ProfilMenuTreeDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(ProfilMenuTree transientInstance) {
		log.debug("persisting ProfilMenuTree instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(ProfilMenuTree persistentInstance) {
		log.debug("removing ProfilMenuTree instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ProfilMenuTree merge(ProfilMenuTree detachedInstance) {
		log.debug("merging ProfilMenuTree instance");
		try {
			ProfilMenuTree result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProfilMenuTree findById(int id) {
		log.debug("getting ProfilMenuTree instance with id: " + id);
		try {
			ProfilMenuTree instance = entityManager.find(ProfilMenuTree.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ProfilMenuTree> findbyUrl(String url) {
		Query query = entityManager.createQuery("FROM ProfilMenuTree where menuTree.url=:url");
		query.setParameter("url", url);
		List<ProfilMenuTree> l = query.getResultList();
		return l;
	}
}
