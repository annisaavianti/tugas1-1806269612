package com.apap.t1.service;

import java.util.List;

import com.apap.t1.model.PerpustakaanModel;

/**
* PerpustakaanService
*/
public interface PerpustakaanService {
	List<PerpustakaanModel> getPerpustakaanList();
	PerpustakaanModel getPerpustakaanById(int id);
	void addPerpustakaan(PerpustakaanModel perpustakaan);
	void deletePerpustakaan(int id);
}
