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
 * Locations generated by hbm2java
 */
@Entity
@Table(name = "LOCATIONS")
public class Locations implements java.io.Serializable {

	private Integer locationId;
	private Countries countries;
	private String streetAddress;
	private String postalCode;
	private String city;
	private String stateProvince;
	private Set<Departments> departmentses = new HashSet<Departments>(0);

	public Locations() {
	}

	@Transient
	public boolean isNew() {
		return (this.getLocationId() == null);
	}

	public Locations(Integer locationId, String city) {
		this.locationId = locationId;
		this.city = city;
	}

	public Locations(Integer locationId, Countries countries, String streetAddress, String postalCode, String city,
			String stateProvince, Set<Departments> departmentses) {
		this.locationId = locationId;
		this.countries = countries;
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.city = city;
		this.stateProvince = stateProvince;
		this.departmentses = departmentses;
	}

	@Id

	@Column(name = "LOCATION_ID", unique = true, nullable = false, precision = 4, scale = 0)
	public Integer getLocationId() {
		return this.locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COUNTRY_ID")
	public Countries getCountries() {
		return this.countries;
	}

	public void setCountries(Countries countries) {
		this.countries = countries;
	}

	@Column(name = "STREET_ADDRESS", length = 40)
	public String getStreetAddress() {
		return this.streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	@Column(name = "POSTAL_CODE", length = 12)
	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Column(name = "CITY", nullable = false, length = 30)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "STATE_PROVINCE", length = 25)
	public String getStateProvince() {
		return this.stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "locations")
	public Set<Departments> getDepartmentses() {
		return this.departmentses;
	}

	public void setDepartmentses(Set<Departments> departmentses) {
		this.departmentses = departmentses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((locationId == null) ? 0 : locationId.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((stateProvince == null) ? 0 : stateProvince.hashCode());
		result = prime * result + ((streetAddress == null) ? 0 : streetAddress.hashCode());
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
		Locations other = (Locations) obj;
		if (city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!city.equals(other.city)) {
			return false;
		}
		if (locationId == null) {
			if (other.locationId != null) {
				return false;
			}
		} else if (!locationId.equals(other.locationId)) {
			return false;
		}
		if (postalCode == null) {
			if (other.postalCode != null) {
				return false;
			}
		} else if (!postalCode.equals(other.postalCode)) {
			return false;
		}
		if (stateProvince == null) {
			if (other.stateProvince != null) {
				return false;
			}
		} else if (!stateProvince.equals(other.stateProvince)) {
			return false;
		}
		if (streetAddress == null) {
			if (other.streetAddress != null) {
				return false;
			}
		} else if (!streetAddress.equals(other.streetAddress)) {
			return false;
		}
		return true;
	}

}
