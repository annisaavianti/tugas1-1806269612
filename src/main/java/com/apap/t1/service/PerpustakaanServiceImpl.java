package com.apap.t1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.t1.model.PerpustakaanModel;
import com.apap.t1.repository.PerpustakaanDb;

/**
 * PerpustakaanServiceImpl
 */
@Service
@Transactional
public class PerpustakaanServiceImpl implements PerpustakaanService{

	@Autowired
	private PerpustakaanDb perpustakaanDb;
	
	@Override
	public List<PerpustakaanModel> getPerpustakaanList() {
		return perpustakaanDb.findAll();
	}

	@Override
	public Optional<PerpustakaanModel> getPerpustakaanById(int id) {
		return perpustakaanDb.findById(id);
	}

	@Override
	public Optional<PerpustakaanModel> getPerpustakaanByNama(String nama) {
		return perpustakaanDb.findByNama(nama);
	}
	
	@Override
	public void addPerpustakaan(PerpustakaanModel perpustakaan) {
		perpustakaanDb.save(perpustakaan);
	}

	@Override
	public void deletePerpustakaan(int id) {
		perpustakaanDb.delete(this.getPerpustakaanById(id).get());
	}
}
