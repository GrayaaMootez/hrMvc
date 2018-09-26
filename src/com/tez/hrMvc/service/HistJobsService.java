package com.tez.hrMvc.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tez.hrMvc.dao.JobHistoryDao;
import com.tez.hrMvc.model.JobHistory;

@Service
@Transactional
public class HistJobsService {

	@Autowired
	private JobHistoryDao dao;


	public List<JobHistory> findAll()
	{
		return dao.findAll();
	}


	public JobHistory findById(int emp,Date dat)
	{
		return dao.findById2(emp,dat);
	}
}
