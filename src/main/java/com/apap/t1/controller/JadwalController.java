package com.apap.t1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.t1.model.JadwalModel;
import com.apap.t1.model.PerpustakaanModel;
import com.apap.t1.model.PustakawanModel;
import com.apap.t1.service.PerpustakaanService;
import com.apap.t1.service.PustakawanService;

/**
 * JadwalController
 */
@Controller
public class JadwalController {
	@Autowired
	private PustakawanService pustakawanService;
	
	@Autowired
	private PerpustakaanService perpustakaanService;
	
	@RequestMapping(value = "/jadwal/tambah/{nip}", method = RequestMethod.GET)
	private String tambahJadwal(@PathVariable(value = "nip") String nip, Model model) {
		JadwalModel newJadwal = new JadwalModel();
		List <PerpustakaanModel> perpusList = perpustakaanService.getPerpustakaanList();
		PustakawanModel pustakawan = pustakawanService.getPustakawanByNip(nip);
		newJadwal.setPustakawan(pustakawan);
		model.addAttribute("jadwalObj", newJadwal);
		model.addAttribute("perpusList", perpusList);
		model.addAttribute("pustakawan", pustakawan);
		model.addAttribute("pustakawan_id", pustakawan.getId());
		model.addAttribute("filteredPerpus", pustakawan.getSetOfJadwal());
		model.addAttribute("nav", "Tambah Jadwal Pustakawan");
		return "tambahJadwal";
	}
	
	@RequestMapping(value = "/jadwal/tambah/{nip}", method = RequestMethod.POST)
	private String tambahJadwalSubmit(@ModelAttribute JadwalModel jadwal, @RequestParam(value = "perpustakaan", required = true) PerpustakaanModel perpustakaan, @RequestParam(value = "hari") String hari, @RequestParam(value = "pustakawan", required = true) PustakawanModel pustakawan, Model model) 	{
		jadwal.setPustakawan(pustakawanService.getPustakawanById(pustakawan.getId()));
		jadwal.setPerpustakaan(perpustakaanService.getPerpustakaanById(perpustakaan.getId()).get());
		jadwal.setHari(hari);
		pustakawan.getSetOfJadwal().add(jadwal);
		pustakawanService.addJadwal(pustakawan.getId(), pustakawan);
		model.addAttribute("nav", "Tambah Jadwal Pustakawan");
		return "tambah";
	}
	
	@RequestMapping(value = "/jadwal/delete/{pustakawan_id}")
	private String hapusJadwal(@PathVariable(value = "pustakawan_id") int pustakawan_id, Model model) {
		pustakawanService.deleteJadwal(pustakawan_id);
		model.addAttribute("nav", "Hapus Pustakawan");
		return "hapus";
	}
}
