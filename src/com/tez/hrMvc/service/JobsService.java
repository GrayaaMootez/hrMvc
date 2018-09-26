package com.tez.hrMvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tez.hrMvc.dao.JobsDao;
import com.tez.hrMvc.model.Jobs;

@Service
@Transactional
public class JobsService {

	@Autowired
	JobsDao dao;

	public void addJob(Jobs job) {
		dao.persist(job);
	}

	public void updateJob(Jobs job) {
		dao.merge(job);
	}

	public Jobs findJob(String id) {
		return dao.findById(id);
	}

	public List<Jobs> allJobs() {
		return dao.findAll();
	}

	public void deleteJob(String id) {
		dao.supp(id);
	}

	public void saveOrUpdate(Jobs job) {

		if (job.getJobId() == null) {
			dao.persist(job);
		} else {
			dao.merge(job);
		}

	}
}
