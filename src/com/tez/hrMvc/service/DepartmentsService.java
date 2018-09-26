package com.tez.hrMvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tez.hrMvc.dao.DepartmentsDao;
import com.tez.hrMvc.model.Departments;

@Service
@Transactional
public class DepartmentsService {

	@Autowired
	DepartmentsDao dao;

	public void addDeps(Departments dep) {
		dao.persist(dep);
	}

	public void updateDeps(Departments dep) {
		dao.merge(dep);
	}

	public Departments findDep(Integer id) {
		return dao.findById(id);
	}

	public List<Departments> allDeps() {
		return dao.findAll();
	}

	public void deleteDep(Integer id) {
		dao.supp(id);
	}

	public void saveOrUpdate(Departments dep) {

		if (dep.getDepartmentId() == null) {
			dao.persist(dep);
		} else {
			dao.merge(dep);
		}

	}
}
