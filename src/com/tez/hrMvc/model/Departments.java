package com.tez.hrMvc.model;
// Generated 2 juin 2018 14:26:26 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Departments generated by hbm2java
 */
@Entity
@Table(name = "DEPARTMENTS")
public class Departments implements java.io.Serializable {

	private Integer departmentId;
	private Employees employees;
	private Locations locations;
	private String departmentName;
	private Set<Employees> employeeses = new HashSet<Employees>(0);
	private Set<JobHistory> jobHistories = new HashSet<JobHistory>(0);

	public Departments() {
	}

	@Transient
	public boolean isNew() {
		return (this.getDepartmentId() == null);
	}

	public Departments(Integer departmentId, String departmentName) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}

	public Departments(Integer departmentId, Employees employees, Locations locations, String departmentName,
			Set<Employees> employeeses, Set<JobHistory> jobHistories) {
		this.departmentId = departmentId;
		this.employees = employees;
		this.locations = locations;
		this.departmentName = departmentName;
		this.employeeses = employeeses;
		this.jobHistories = jobHistories;
	}

	@Id

	@Column(name = "DEPARTMENT_ID", unique = true, nullable = false, precision = 4, scale = 0)
	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MANAGER_ID")
	public Employees getEmployees() {
		return this.employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOCATION_ID")
	public Locations getLocations() {
		return this.locations;
	}

	public void setLocations(Locations locations) {
		this.locations = locations;
	}

	@Column(name = "DEPARTMENT_NAME", nullable = false, length = 30)
	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departments")
	public Set<Employees> getEmployeeses() {
		return this.employeeses;
	}

	public void setEmployeeses(Set<Employees> employeeses) {
		this.employeeses = employeeses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departments")
	public Set<JobHistory> getJobHistories() {
		return this.jobHistories;
	}

	public void setJobHistories(Set<JobHistory> jobHistories) {
		this.jobHistories = jobHistories;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departmentId == null) ? 0 : departmentId.hashCode());
		result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Departments other = (Departments) obj;
		if (departmentId == null) {
			if (other.departmentId != null) {
				return false;
			}
		} else if (!departmentId.equals(other.departmentId)) {
			return false;
		}
		if (departmentName == null) {
			if (other.departmentName != null) {
				return false;
			}
		} else if (!departmentName.equals(other.departmentName)) {
			return false;
		}
		return true;
	}

}
