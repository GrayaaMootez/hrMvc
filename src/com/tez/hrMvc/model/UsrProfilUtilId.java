package com.tez.hrMvc.model;
// Generated 2 juin 2018 14:26:26 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UsrProfilUtilId generated by hbm2java
 */
@Embeddable
public class UsrProfilUtilId implements java.io.Serializable {

	private BigDecimal codeProfil;
	private String util;

	public UsrProfilUtilId() {
	}

	public UsrProfilUtilId(BigDecimal codeProfil, String util) {
		this.codeProfil = codeProfil;
		this.util = util;
	}

	@Column(name = "CODE_PROFIL", nullable = false, scale = 0)
	public BigDecimal getCodeProfil() {
		return this.codeProfil;
	}

	public void setCodeProfil(BigDecimal codeProfil) {
		this.codeProfil = codeProfil;
	}

	@Column(name = "UTIL", nullable = false, length = 120)
	public String getUtil() {
		return this.util;
	}

	public void setUtil(String util) {
		this.util = util;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UsrProfilUtilId))
			return false;
		UsrProfilUtilId castOther = (UsrProfilUtilId) other;

		return ((this.getCodeProfil() == castOther.getCodeProfil()) || (this.getCodeProfil() != null
				&& castOther.getCodeProfil() != null && this.getCodeProfil().equals(castOther.getCodeProfil())))
				&& ((this.getUtil() == castOther.getUtil()) || (this.getUtil() != null && castOther.getUtil() != null
						&& this.getUtil().equals(castOther.getUtil())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCodeProfil() == null ? 0 : this.getCodeProfil().hashCode());
		result = 37 * result + (getUtil() == null ? 0 : this.getUtil().hashCode());
		return result;
	}

}
