package com.apap.t1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.t1.model.SpesialisasiModel;

/**
* SpesialisasiDb
*/
@Repository
public interface SpesialisasiDb extends JpaRepository<SpesialisasiModel, Integer>{
	Optional<SpesialisasiModel> findById(int id);
}
