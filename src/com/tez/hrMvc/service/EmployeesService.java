package com.tez.hrMvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tez.hrMvc.dao.EmployeesDao;
import com.tez.hrMvc.model.Employees;

@Service
@Transactional
public class EmployeesService {

	@Autowired
	EmployeesDao dao;

	public Employees findById(Integer id) {
		return dao.findById(id);

	}

	public List<Employees> findAll() {
		return dao.findAll();
	}

	public void delete(Integer id) {
		dao.supp(id);
	}

	public void update(Employees emp) {
		dao.merge(emp);
	}

	public void add(Employees emp) {
		dao.persist(emp);
	}

	public void saveOrUpdate(Employees emp) {

		if (emp.getEmployeeId() == null) {
			dao.persist(emp);
		} else {
			dao.merge(emp);
		}

	}

}
