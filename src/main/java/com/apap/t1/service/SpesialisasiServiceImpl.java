package com.apap.t1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.t1.model.SpesialisasiModel;
import com.apap.t1.repository.SpesialisasiDb;

/**
 * SpesialisasiServiceImpl
 */
@Service
@Transactional
public class SpesialisasiServiceImpl implements SpesialisasiService{
	@Autowired
	private SpesialisasiDb spesialisasiDb;
	
	@Override
	public List<SpesialisasiModel> getSpesialisasiList() {
		return spesialisasiDb.findAll();
	}
	
	@Override
	public Optional<SpesialisasiModel> getSpesialisasiById(int id) {
		return spesialisasiDb.findById(id);
	}
}
