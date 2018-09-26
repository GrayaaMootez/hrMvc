package com.tez.hrMvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tez.hrMvc.dao.CountriesDao;
import com.tez.hrMvc.model.Countries;

@Service
@Transactional
public class CountriesService {

	@Autowired
	CountriesDao dao;

	public void addCountrie(Countries countrie) {
		dao.persist(countrie);
	}

	public void updateCountrie(Countries countrie) {
		dao.merge(countrie);
	}

	public Countries findCountrie(String id) {
		return dao.findById(id);
	}

	public List<Countries> allCountrie() {
		return dao.findAll();
	}

	public void deleteCountrie(String id) {
		dao.supp(id);
	}

	public void saveOrUpdate(Countries count) {

		if (count.getCountryId() == null) {
			dao.persist(count);
		} else {
			dao.merge(count);
		}

	}
}
