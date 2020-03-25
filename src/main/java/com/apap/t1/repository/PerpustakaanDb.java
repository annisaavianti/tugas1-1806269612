package com.apap.t1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.t1.model.PerpustakaanModel;

/**
* PerpustakaanDb
*/

@Repository
public interface PerpustakaanDb extends JpaRepository<PerpustakaanModel, Integer>{
	Optional<PerpustakaanModel> findById(int id);
	Optional<PerpustakaanModel> findByNama(String nama);
}
