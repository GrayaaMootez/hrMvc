package com.tez.hrMvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tez.hrMvc.dao.RegionsDao;
import com.tez.hrMvc.model.Regions;

@Service
@Transactional
public class RegionService {

	@Autowired
	RegionsDao dao;

	public Regions findRegions(Integer id) {

		return dao.findById(id);
	}

	public List<Regions> regions() {

		return dao.findAll();
	}

	public void addRegion(Regions reg) {

		dao.persist(reg);

}

	public void UpdateRegion(Regions reg) {

		dao.merge(reg);

	}

	public void deleteRegion(Integer id) {

		dao.supp(id);

	}

	public void saveOrUpdate(Regions reg) {

		if (reg.getRegionId() == null) {
			dao.persist(reg);
		} else {
			dao.merge(reg);
		}

	}

}
