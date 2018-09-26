package com.tez.hrMvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tez.hrMvc.dao.MenuTreeDao;
import com.tez.hrMvc.model.MenuTree;


@Service
@Transactional
public class MenuTreeService {

	@Autowired
	MenuTreeDao dao;

	public List<MenuTree> findAll()

	{
		return dao.findAll();

	}

	public List<MenuTree> root()

	{
		return dao.root();

	}


	public MenuTree findById(int id)

	{
		return dao.findById(id);

	}

}
