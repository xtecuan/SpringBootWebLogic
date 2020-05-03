package com.livejournal.xtecuan.samples.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xtecuan
 */
@Entity
@Table(name = "REGIONS")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Regions.findAll", query = "SELECT r FROM Regions r"),
		@NamedQuery(name = "Regions.findByRegionId", query = "SELECT r FROM Regions r WHERE r.regionId = :regionId"),
		@NamedQuery(name = "Regions.findByRegionName", query = "SELECT r FROM Regions r WHERE r.regionName = :regionName") })
public class Regions implements Serializable {

	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "REGION_ID")
	private BigDecimal regionId;
	@Size(max = 25)
	@Column(name = "REGION_NAME")
	private String regionName;

	public Regions() {
	}

	public Regions(BigDecimal regionId) {
		this.regionId = regionId;
	}

	public BigDecimal getRegionId() {
		return regionId;
	}

	public void setRegionId(BigDecimal regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (regionId != null ? regionId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Regions)) {
			return false;
		}
		Regions other = (Regions) object;
		if ((this.regionId == null && other.regionId != null)
				|| (this.regionId != null && !this.regionId.equals(other.regionId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "sv.com.fedecredito.ejemplos.jsfbasics.entities.Regions[ regionId=" + regionId + " ]";
	}

}
