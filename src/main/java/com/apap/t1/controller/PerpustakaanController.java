package com.apap.t1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.t1.model.PerpustakaanModel;
import com.apap.t1.service.PerpustakaanService;

/**
 * PerpustakaanController
 */
@Controller
public class PerpustakaanController {
	@Autowired
	private PerpustakaanService perpustakaanService;
	
	@RequestMapping("/perpustakaan")
	private String daftarPerpustakaan(Model model) {
		List <PerpustakaanModel> perpustakaanList = perpustakaanService.getPerpustakaanList();
		model.addAttribute("perpustakaanList", perpustakaanList);
		model.addAttribute("nav", "Daftar Perpustakaan");
		return "daftarPerpustakaan";   
	}
	
	@RequestMapping(value = "/perpustakaan/tambah", method = RequestMethod.GET)
	private String tambahPerpustakaan(Model model) {
		PerpustakaanModel perpustakaan = new PerpustakaanModel();
		perpustakaan.setId(perpustakaan.getId());
		model.addAttribute("perpustakaanObj", perpustakaan);
		model.addAttribute("nav", "Tambah Perpustakaan");
		return "tambahPerpustakaan";
	}
	
	@RequestMapping(value = "/perpustakaan/tambah", method = RequestMethod.POST)
	private String tambahPerpustakaanSimpan(@ModelAttribute PerpustakaanModel perpustakaan, Model model) {
		perpustakaanService.addPerpustakaan(perpustakaan);
		model.addAttribute("nav", "Tambah Perpustakaan");
		return "tambah";		
	}
	
	@RequestMapping(value = "/perpustakaan/delete/{id}")
	private String hapusPerpustakaan(@PathVariable(value = "id") int id, Model model) {
		perpustakaanService.deletePerpustakaan(id);
		model.addAttribute("nav", "Hapus Perpustakaan");
		return "hapus";
	}
}
