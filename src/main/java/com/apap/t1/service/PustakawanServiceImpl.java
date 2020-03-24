package com.apap.t1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.t1.model.PustakawanModel;
import com.apap.t1.repository.PustakawanDb;

/**
 * PustakawanServiceImpl
 */
@Service
@Transactional
public class PustakawanServiceImpl implements PustakawanService{
	@Autowired
	private PustakawanDb pustakawanDb;
	
	@Override
	public List<PustakawanModel> getPustakawanList() {
		return pustakawanDb.findAll();
	}
	
	@Override
	public PustakawanModel getPustakawanById(int id) {
		return pustakawanDb.findById(id);
	}
	
	@Override
	public PustakawanModel getPustakawanByNip(String nip) {
		return pustakawanDb.findByNip(nip);
	}
	
	@Override
	public void generateNip(PustakawanModel pustakawan) {
		pustakawan.setNip(pustakawan.generateNip());
	}
	
	@Override
	public void addPustakawan(PustakawanModel pustakawan) {
		this.generateNip(pustakawan);
		for (PustakawanModel p : this.getPustakawanList()) {
			if (p.getNip().equals(pustakawan.getNip())) {
				this.generateNip(pustakawan);
			}
		}
		pustakawanDb.save(pustakawan);
	}

	@Override
	public void updatePustakawan(int id, PustakawanModel updatePustakawan) {
		PustakawanModel pustakawan = this.getPustakawanById(id);
		pustakawan.setNama(updatePustakawan.getNama());
		pustakawan.setTempat_lahir(updatePustakawan.getTempat_lahir());
		pustakawan.setTanggal_lahir(updatePustakawan.getTanggal_lahir());
		pustakawan.setJenis_kelamin(updatePustakawan.getJenis_kelamin());
		pustakawan.setSetOfSpesialisasi(updatePustakawan.getSetOfSpesialisasi());
	}

	public void deletePustakawan(int id) {
		pustakawanDb.delete(this.getPustakawanById(id));
	}

	@Override
	public void addJadwal(int id, PustakawanModel updatePustakawan) {
		PustakawanModel pustakawan = this.getPustakawanById(id);
		pustakawan.setSetOfJadwal(updatePustakawan.getSetOfJadwal());
	}
	
}
