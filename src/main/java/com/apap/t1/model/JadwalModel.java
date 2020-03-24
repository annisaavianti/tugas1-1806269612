package com.apap.t1.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pustakawan_perpustakaan")
public class JadwalModel implements Serializable {
	@Id
	@ManyToOne
	@JoinColumn(name = "pustakawan_id")
	private PustakawanModel pustakawan;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "perpustakaan_id")
	private PerpustakaanModel perpustakaan;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "hari", nullable = false)
	private String hari;

	public PustakawanModel getPustakawan() {
		return pustakawan;
	}

	public void setPustakawan(PustakawanModel pustakawan) {
		this.pustakawan = pustakawan;
	}

	public PerpustakaanModel getPerpustakaan() {
		return perpustakaan;
	}

	public void setPerpustakaan(PerpustakaanModel perpustakaan) {
		this.perpustakaan = perpustakaan;
	}

	public String getHari() {
		return hari;
	}

	public void setHari(String hari) {
		this.hari = hari;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((perpustakaan == null) ? 0 : perpustakaan.hashCode());
		result = prime * result + ((pustakawan == null) ? 0 : pustakawan.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JadwalModel other = (JadwalModel) obj;
		if (perpustakaan == null) {
			if (other.perpustakaan != null)
				return false;
		} else if (!perpustakaan.equals(other.perpustakaan))
			return false;
		if (pustakawan == null) {
			if (other.pustakawan != null)
				return false;
		} else if (!pustakawan.equals(other.pustakawan))
			return false;
		return true;
	}
	
}
