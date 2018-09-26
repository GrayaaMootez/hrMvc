package com.tez.hrMvc.model;
// Generated 2 juin 2018 14:26:26 by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProfilMenuTreeId generated by hbm2java
 */
@Embeddable
public class ProfilMenuTreeId implements java.io.Serializable {

	private BigDecimal codeProfil;
	private BigDecimal menuId;

	public ProfilMenuTreeId() {
	}

	public ProfilMenuTreeId(BigDecimal codeProfil, BigDecimal menuId) {
		this.codeProfil = codeProfil;
		this.menuId = menuId;
	}

	@Column(name = "CODE_PROFIL", nullable = false, scale = 0)
	public BigDecimal getCodeProfil() {
		return this.codeProfil;
	}

	public void setCodeProfil(BigDecimal codeProfil) {
		this.codeProfil = codeProfil;
	}

	@Column(name = "MENU_ID", nullable = false, scale = 0)
	public BigDecimal getMenuId() {
		return this.menuId;
	}

	public void setMenuId(BigDecimal menuId) {
		this.menuId = menuId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProfilMenuTreeId))
			return false;
		ProfilMenuTreeId castOther = (ProfilMenuTreeId) other;

		return ((this.getCodeProfil() == castOther.getCodeProfil()) || (this.getCodeProfil() != null
				&& castOther.getCodeProfil() != null && this.getCodeProfil().equals(castOther.getCodeProfil())))
				&& ((this.getMenuId() == castOther.getMenuId()) || (this.getMenuId() != null
						&& castOther.getMenuId() != null && this.getMenuId().equals(castOther.getMenuId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCodeProfil() == null ? 0 : this.getCodeProfil().hashCode());
		result = 37 * result + (getMenuId() == null ? 0 : this.getMenuId().hashCode());
		return result;
	}

}
