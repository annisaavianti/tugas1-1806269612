package com.apap.t1.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "perpustakaan")
public class PerpustakaanModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "nama", nullable = false)
	private String nama;
	
	@Size(max = 500)
	@Column(name = "lokasi", nullable = true)
	private String lokasi;
	
	@OneToMany(mappedBy = "perpustakaan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<PustakawanPerpusModel> setOfPustakawanPerpus = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getLokasi() {
		return lokasi;
	}

	public void setLokasi(String lokasi) {
		this.lokasi = lokasi;
	}

	public Set<PustakawanPerpusModel> getSetOfPustakawanPerpus() {
		return setOfPustakawanPerpus;
	}

	public void setSetOfPustakawanPerpus(Set<PustakawanPerpusModel> setOfPustakawanPerpus) {
		this.setOfPustakawanPerpus = setOfPustakawanPerpus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		PerpustakaanModel other = (PerpustakaanModel) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
