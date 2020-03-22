package com.apap.t1.service;

import java.util.List;
import java.util.Optional;

import com.apap.t1.model.SpesialisasiModel;

/**
* SpesialisasiService
*/
public interface SpesialisasiService {
	List <SpesialisasiModel> getSpesialisasiList();
	Optional<SpesialisasiModel> getSpesialisasiById(int id);
}
