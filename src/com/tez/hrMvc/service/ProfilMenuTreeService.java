package com.tez.hrMvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tez.hrMvc.dao.ProfilMenuTreeDao;
import com.tez.hrMvc.model.ProfilMenuTree;

@Service
@Transactional
public class ProfilMenuTreeService {

	@Autowired
	ProfilMenuTreeDao dao;

	public List<ProfilMenuTree> findbyUrl(String url) {

		return dao.findbyUrl(url);
	}

}
