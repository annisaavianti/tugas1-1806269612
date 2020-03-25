package com.apap.t1.service;

import java.util.List;
import java.util.Optional;

import com.apap.t1.model.PerpustakaanModel;

/**
* PerpustakaanService
*/
public interface PerpustakaanService {
	List<PerpustakaanModel> getPerpustakaanList();
	Optional<PerpustakaanModel> getPerpustakaanById(int id);
	Optional<PerpustakaanModel> getPerpustakaanByNama(String nama);
	void addPerpustakaan(PerpustakaanModel perpustakaan);
	void deletePerpustakaan(int id);
}
