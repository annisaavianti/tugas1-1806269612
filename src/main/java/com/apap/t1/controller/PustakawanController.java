package com.apap.t1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.t1.model.PustakawanModel;
import com.apap.t1.model.SpesialisasiModel;
import com.apap.t1.service.PustakawanService;
import com.apap.t1.service.SpesialisasiService;

/**
 * PustakawanController
 */

@Controller
public class PustakawanController {
	@Autowired
	private PustakawanService pustakawanService;
	
	@Autowired
	private SpesialisasiService spesialisasiService;
	
	@RequestMapping("/")
	private String home(Model model) {
		List <PustakawanModel> pustakawanList = pustakawanService.getPustakawanList();
		List <SpesialisasiModel> spesialisasiList = spesialisasiService.getSpesialisasiList();
		model.addAttribute("pustakawanList", pustakawanList);
		model.addAttribute("spesialisasiList", spesialisasiList);
		model.addAttribute("nav", "Sistem Informasi Pustakawan");
		return "home";   
	}
	
	@RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.GET)
	private String tambahPustakawan(Model model) {
		List <SpesialisasiModel> spesialisasiList = spesialisasiService.getSpesialisasiList();
		PustakawanModel pustakawan = new PustakawanModel();
		pustakawan.setId(pustakawan.getId());
		model.addAttribute("spesialisasiList", spesialisasiList);
		model.addAttribute("pustakawanObj", pustakawan);
		model.addAttribute("nav", "Tambah Pustakawan");
		return "tambahPustakawan";
	}
	
	//msh belum bisa euy pusing
	/*@RequestMapping(value="/pustakawan/tambah", method = RequestMethod.POST, params={"tambah"})
    private String tambahSpesialisasi(@RequestParam (value ="setOfSpesialisasi") Set<SpesialisasiModel> spesialisasi, @ModelAttribute PustakawanModel pustakawan, BindingResult bindingResult, Model model) {
		List <SpesialisasiModel> spesialisasiList = spesialisasiService.getSpesialisasiList();
		if (pustakawan.getSetOfSpesialisasi() == new HashSet<SpesialisasiModel>(spesialisasi)) {
			for (SpesialisasiModel s : spesialisasi) {
				SpesialisasiModel spesialisasiId = spesialisasiService.getSpesialisasiById(s.getId());
				pustakawan.getSetOfSpesialisasi().add(spesialisasiId);
			}
		}		
		model.addAttribute("pustakawanObj", pustakawan);
		model.addAttribute("nama", pustakawan.getNama());
		model.addAttribute("tempat_lahir", pustakawan.getTempat_lahir());
		model.addAttribute("tanggal_lahir", pustakawan.getTanggal_lahir());
		model.addAttribute("jenis_kelamin", pustakawan.getJenis_kelamin());
		model.addAttribute("spesialisasiList", spesialisasiList);
		model.addAttribute("daftarSpesialisasi", pustakawan.getSetOfSpesialisasi());
		model.addAttribute("d", spesialisasi);
		model.addAttribute("nav", "Tambah Pustakawan");
		return "tambahPustakawan";
    }*/
	
	@RequestMapping(value = "/pustakawan/tambah", method = RequestMethod.POST, params={"simpan"} )
	private String tambahPustakawanSimpan(@RequestParam(value="spesialisasi", required = false) SpesialisasiModel spesialisasi, @ModelAttribute PustakawanModel pustakawan, Model model) {
		pustakawanService.addPustakawan(pustakawan);
		if (!(spesialisasi == null)) {
			Optional<SpesialisasiModel> spesialisasiId = spesialisasiService.getSpesialisasiById(spesialisasi.getId());
			pustakawan.getSetOfSpesialisasi().add(spesialisasiId.get());
		}
		model.addAttribute("nav", "Tambah Pustakawan");
		return "tambah";		
	}
	
	@RequestMapping(value = "/pustakawan", method = RequestMethod.GET)
	public String lihatPustakawan(@RequestParam(value = "nip", required = true) String nip, Model model) {
		PustakawanModel pustakawan = pustakawanService.getPustakawanByNip(nip);
		model.addAttribute("pustakawan", pustakawan);
		model.addAttribute("nav", "Detail Pustakawan");
		return "lihatDetailPustakawan";
	}
	
	@RequestMapping(value = "/pustakawan/update/{id}", method = RequestMethod.GET)
	private String ubahPustakawan(@PathVariable(value = "id") int id, Model model) {
		List <SpesialisasiModel> spesialisasiList = spesialisasiService.getSpesialisasiList();
		PustakawanModel pustakawan = pustakawanService.getPustakawanById(id);
		model.addAttribute("spesialisasiList", spesialisasiList);
		model.addAttribute("pustakawan", pustakawan);
		model.addAttribute("nav", "Ubah Pustakawan");
		return "ubahPustakawan";
	}
	
	@RequestMapping(value = "/pustakawan/update/{id}", method = RequestMethod.POST)
	private String ubahPustakawanSimpan(@ModelAttribute PustakawanModel updatePustakawan, @PathVariable(value = "id") int id, Model model) {
		pustakawanService.updatePustakawan(id, updatePustakawan);
		model.addAttribute("nav", "Ubah Pustakawan");
		return "ubah";
	}
	
	@RequestMapping(value = "/pustakawan/delete/{id}")
	private String hapusPustakawan(@PathVariable(value = "id") int id, Model model) {
		pustakawanService.deletePustakawan(id);
		model.addAttribute("nav", "Hapus Pustakawan");
		return "hapus";
	}

}
