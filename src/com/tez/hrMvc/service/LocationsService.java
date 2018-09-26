package com.tez.hrMvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tez.hrMvc.dao.LocationsDao;
import com.tez.hrMvc.model.Locations;

@Service
@Transactional
public class LocationsService {

	@Autowired
	LocationsDao dao;

	public void delete(Integer id) {
		dao.supp(id);
	}

	public void add(Locations location) {
		dao.persist(location);
	}

	public void update(Locations location) {
		dao.merge(location);
	}

	public Locations findById(Integer id) {
		return dao.findById(id);

	}

	public List<Locations> findAll() {
		return dao.findAll();

	}

	public void saveOrUpdate(Locations location) {

		if (location.getLocationId() == null) {
			dao.persist(location);
		} else {
			dao.merge(location);
		}

	}

}
