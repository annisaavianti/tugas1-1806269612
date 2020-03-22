package com.apap.t1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.t1.model.PustakawanModel;

/**
* PustakawanDb
*/
@Repository
public interface PustakawanDb extends JpaRepository<PustakawanModel, Integer>{
	PustakawanModel findById(int id);
	PustakawanModel findByNip(String nip);
}
