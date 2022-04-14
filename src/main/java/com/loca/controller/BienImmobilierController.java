package com.loca.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.loca.dao.BienImmobilierDao;
import com.loca.exception.ResourceNotFoundException;
import com.loca.modal.BienImmobilier;
import com.loca.modal.User;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")

public class BienImmobilierController {
	@Autowired
	private BienImmobilierDao bienImmobilerDao ;
	
	@GetMapping("/biens")
	public List<BienImmobilier> getAllBien() {
		return bienImmobilerDao.findAll();
	}
	
	@GetMapping("/biens/{id}")
	public ResponseEntity<BienImmobilier> getBienById(@PathVariable(value = "id") Long bienId)
			throws ResourceNotFoundException {
		BienImmobilier bien = bienImmobilerDao.findById(bienId)
				.orElseThrow(() -> new ResourceNotFoundException("Bien not found for this id :: " + bienId));
		return ResponseEntity.ok().body(bien);
	}
	
	@PostMapping("/biens")
	public BienImmobilier createBien(  @Validated @RequestBody BienImmobilier bien) {
		return bienImmobilerDao.save(bien);
	}
	
	
	
	@PutMapping("/biens/{id}")
	public ResponseEntity<BienImmobilier> updateBien(@PathVariable(value = "id") Long bienId,
			@Validated @RequestBody BienImmobilier bienDetails) throws ResourceNotFoundException {
		BienImmobilier bien = bienImmobilerDao.findById(bienId)
				.orElseThrow(() -> new ResourceNotFoundException("bien not found for this id :: " + bienId));
		bien.setPrix(bienDetails.getPrix());
		bien.setTypologie(bienDetails.getTypologie());
		bien.setAdress(bienDetails.getAdress());
		bien.setEtat(bienDetails.getEtat());
		bien.setEtage(bienDetails.getEtage());
		bien.setPicbyte(bienDetails.getPicbyte());
		bien.setComposition(bienDetails.getComposition());
		bien.setSuperficie(bienDetails.getSuperficie());
		bien.setProprietaire(bienDetails.getProprietaire());



		final BienImmobilier updatedBien = bienImmobilerDao.save(bien);
		return ResponseEntity.ok(updatedBien);
	
}
	

	@DeleteMapping("/biens/{id}")
	public Map<String, Boolean> deleteBien(@PathVariable(value = "id") Long bienId)
			throws ResourceNotFoundException {
		BienImmobilier bien = bienImmobilerDao.findById(bienId)
				.orElseThrow(() -> new ResourceNotFoundException("bien not found for this id :: " + bienId));

		bienImmobilerDao.delete(bien);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
