package com.apap.t1.service;

import java.util.List;

import com.apap.t1.model.PustakawanModel;

/**
* PustakawanService
*/
public interface PustakawanService {
	List <PustakawanModel> getPustakawanList();
	PustakawanModel getPustakawanById(int id);
	PustakawanModel getPustakawanByNip(String nip);
	void generateNip(PustakawanModel pustakawan);
	void addPustakawan(PustakawanModel pustakawan);
	void updatePustakawan(int id, PustakawanModel pustakawan);
	void deletePustakawan(int id);
}
