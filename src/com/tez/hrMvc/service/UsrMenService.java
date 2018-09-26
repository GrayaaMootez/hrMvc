package com.tez.hrMvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tez.hrMvc.dao.UsrMenDao;
import com.tez.hrMvc.model.UsrMen;

@Service
@Transactional
public class UsrMenService {

	@Autowired
UsrMenDao dao;

	public UsrMen findById(String id)
	{
		return dao.findById(id);
	}

}
