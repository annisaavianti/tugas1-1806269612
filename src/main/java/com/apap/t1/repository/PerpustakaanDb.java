package com.apap.t1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.t1.model.PerpustakaanModel;

/**
* PerpustakaanDb
*/

@Repository
public interface PerpustakaanDb extends JpaRepository<PerpustakaanModel, Integer>{
	PerpustakaanModel findById(int id);
}
