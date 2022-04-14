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

import com.loca.dao.DemandeLocationDao;
import com.loca.exception.ResourceNotFoundException;

import com.loca.modal.DemandeLocation;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")


public class DemandeLocationController {
	
	@Autowired
	private DemandeLocationDao demandeLocationDao ;

	
	@GetMapping("/demandeslocation")
	public List<DemandeLocation> getAlldemande(){
		return demandeLocationDao.findAll();
	}
	
	@GetMapping("/demandeslocation/{id}")
	public ResponseEntity<DemandeLocation> getDemandeById(@PathVariable(value = "id") Long demandeid) throws ResourceNotFoundException{
		DemandeLocation demande = demandeLocationDao.findById(demandeid)
				.orElseThrow(() -> new ResourceNotFoundException("Demande de Location not found for this id :: " + demandeid));
		return ResponseEntity.ok().body(demande);
	}
	
	@PostMapping("/demandeslocation")
	public DemandeLocation createDemmande(  @Validated @RequestBody DemandeLocation demande) {
		return demandeLocationDao.save(demande);
	}
	
	@PutMapping("/demandeslocation/{id}")
	public ResponseEntity<DemandeLocation> updateDemande(@PathVariable(value = "id") Long demandeId,
			@Validated @RequestBody DemandeLocation demandeDetails) throws ResourceNotFoundException {
		DemandeLocation demande = demandeLocationDao.findById(demandeId)
				.orElseThrow(() -> new ResourceNotFoundException("demande location not found for this id :: " + demandeId));
	
		demande.setFirstName(demandeDetails.getFirstName());
		demande.setCin(demandeDetails.getCin());
		demande.setLastName(demandeDetails.getLastName());
		demande.setPhone(demandeDetails.getPhone());
		demande.setDateDeb(demandeDetails.getDateDeb());
		demande.setDateFin(demandeDetails.getDateFin());
		demande.setLocalisation(demandeDetails.getLocalisation());



		demande.setCheckIn(demandeDetails.getCheckIn());
		demande.setCheckOut(demandeDetails.getCheckOut());
		final DemandeLocation updateDemande = demandeLocationDao.save(demande);
		return ResponseEntity.ok(updateDemande);
	
}
	

	@DeleteMapping("/demandeslocation/{id}")
	public Map<String, Boolean> deleteDemande(@PathVariable(value = "id") Long demandeId)
			throws ResourceNotFoundException {
		DemandeLocation demande = demandeLocationDao.findById(demandeId)
				.orElseThrow(() -> new ResourceNotFoundException("demande location not found for this id :: " + demandeId));

		demandeLocationDao.delete(demande);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}

	

