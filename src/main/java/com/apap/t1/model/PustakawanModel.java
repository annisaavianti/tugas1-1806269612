package com.apap.t1.model;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.text.RandomStringGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pustakawan")
public class PustakawanModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "nama", nullable = false)
	private String nama;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "nip", nullable = false, unique =true)
	private String nip;
	
	@Size(max = 100)
	@Column(name = "tempat_lahir", nullable = true)
	private String tempat_lahir;
	
	@NotNull
	@Column(name = "tanggal_lahir", nullable = false)
	private Date tanggal_lahir;
	
	@NotNull
	@Column(name = "jenis_kelamin", nullable = false)
	private int jenis_kelamin;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "spesialisasi_pustakawan", 
			joinColumns = { @JoinColumn(name = "pustakawan_id") },
			inverseJoinColumns = { @JoinColumn(name = "spesialisasi_id") })
	private Set<SpesialisasiModel> setOfSpesialisasi = new HashSet<>(); //dibuat Set agar tidak ada data duplikat
	
	@OneToMany(mappedBy ="pustakawan", cascade = CascadeType.ALL)
	private Set<JadwalModel> setOfJadwal; //dibuat Set agar tidak ada data duplikat

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

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getTempat_lahir() {
		return tempat_lahir;
	}

	public void setTempat_lahir(String tempat_lahir) {
		this.tempat_lahir = tempat_lahir;
	}

	public Date getTanggal_lahir() {
		return tanggal_lahir;
	}

	public void setTanggal_lahir(Date tanggal_lahir) {
		this.tanggal_lahir = tanggal_lahir;
	}

	public int getJenis_kelamin() {
		return jenis_kelamin;
	}

	public void setJenis_kelamin(int jenis_kelamin) {
		this.jenis_kelamin = jenis_kelamin;
	}

	public Set<SpesialisasiModel> getSetOfSpesialisasi() {
		return setOfSpesialisasi;
	}

	public void setSetOfSpesialisasi(Set<SpesialisasiModel> setOfSpesialisasi) {
		this.setOfSpesialisasi = setOfSpesialisasi;
	}

	public Set<JadwalModel> getSetOfJadwal() {
		return setOfJadwal;
	}

	public void setSetOfJadwal(Set<JadwalModel> setOfJadwal) {
		this.setOfJadwal = setOfJadwal;
	}
	
	@Override
	public int hashCode() {
		Objects.hash(id);
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
		PustakawanModel other = (PustakawanModel) obj;
		if (id != other.id)
			return false;
		return true;
	}

	//method untuk generate NIP
	public String generateNip() { 
		return LocalDate.now().getYear() + new SimpleDateFormat("ddMMyy").format(getTanggal_lahir()) + this.getJenis_kelamin() + new RandomStringGenerator.Builder().withinRange('A','Z').build().generate(2);
	}
}