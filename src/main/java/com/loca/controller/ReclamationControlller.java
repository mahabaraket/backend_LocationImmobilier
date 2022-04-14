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
import org.springframework.web.bind.annotation.RestController;

import com.loca.dao.ReclamationDao;
import com.loca.exception.ResourceNotFoundException;
import com.loca.modal.BienImmobilier;
import com.loca.modal.Reclamation;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ReclamationControlller {

	@Autowired
	private ReclamationDao reclamationDao ; 
	
	
	@GetMapping("/reclamations")
	public List<Reclamation> getAllReclamation() {
		return reclamationDao.findAll();
	}
	
	
	@GetMapping("/reclamations/{id}")
	public ResponseEntity<Reclamation> getReclamationById(@PathVariable(value = "id") Long reclamationId) 
			throws ResourceNotFoundException {
		Reclamation reclamation = reclamationDao.findById(reclamationId)
						.orElseThrow(() -> new ResourceNotFoundException("reclamation not found for this id :: " + reclamationId));
				return ResponseEntity.ok().body(reclamation);
			}
	
	
	@PostMapping("/reclamations")
	public Reclamation createReclamation(  @Validated @RequestBody Reclamation reclamation) {
		return reclamationDao.save(reclamation);
	}
	
	
	@PutMapping("/reclamations/{id}")
	public ResponseEntity<Reclamation> updateReclamation(@PathVariable(value = "id") Long reclamationId,
			@Validated @RequestBody Reclamation reclamationDetails) throws ResourceNotFoundException {
		Reclamation reclamation = reclamationDao.findById(reclamationId)
				.orElseThrow(() -> new ResourceNotFoundException("Reclamation not found for this id :: " + reclamationId));
		
		reclamation.setType(reclamationDetails.getType());
		reclamation.setPhoto(reclamationDetails.getPhoto());
		reclamation.setDate(reclamationDetails.getDate());
		reclamation.setDescription(reclamationDetails.getDescription());
		reclamation.setstatus(reclamationDetails.getstatus());



		final Reclamation updatedReclamation = reclamationDao.save(reclamation);
		return ResponseEntity.ok(updatedReclamation);
	
}
	@DeleteMapping("/reclamations/{id}")
	public Map<String, Boolean> deleteReclamation(@PathVariable(value = "id") Long reclamationId)
			throws ResourceNotFoundException {
		Reclamation reclamation = reclamationDao.findById(reclamationId)
				.orElseThrow(() -> new ResourceNotFoundException("reclamation not found for this id :: " + reclamationId));

		reclamationDao.delete(reclamation);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
	}
	

