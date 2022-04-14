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

import com.loca.dao.ContratDao;
import com.loca.exception.ResourceNotFoundException;
import com.loca.modal.BienImmobilier;
import com.loca.modal.Contrat;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")

public class ContratController {
@Autowired
private ContratDao contratDao;

@GetMapping("/contrats")
public List<Contrat> getAllContrat() {
	return contratDao.findAll();
}



@GetMapping("/contrats/{id}")
public ResponseEntity<Contrat> getContratById(@PathVariable(value = "id") Long contratId)
		throws ResourceNotFoundException {
	Contrat contrat = contratDao.findById(contratId)
			.orElseThrow(() -> new ResourceNotFoundException("contrat not found for this id :: " + contratId));
	return ResponseEntity.ok().body(contrat);
}
  
@PostMapping("/contrats")
public Contrat createContrat(  @Validated @RequestBody Contrat contrat) {
	return contratDao.save(contrat);
}





@PutMapping("/contrats/{id}")
public ResponseEntity<Contrat> updateContrat(@PathVariable(value = "id") Long contratID,
		@Validated @RequestBody Contrat contartDetails) throws ResourceNotFoundException {
	Contrat contrat = contratDao.findById(contratID)
			.orElseThrow(() -> new ResourceNotFoundException("bien not found for this id :: " + contratID));
	contrat.setContratname(contartDetails.getContratname());
	contrat.setDateDebut(contartDetails.getDateDebut());
	contrat.setLocalisation(contartDetails.getLocalisation());
	contrat.setDateFin(contartDetails.getDateFin());
	contrat.setName(contartDetails.getName());
	contrat.setEmail(contartDetails.getEmail());
	contrat.setContrat(contartDetails.isContrat());
	

	final Contrat updatedContrat = contratDao.save(contrat);
	return ResponseEntity.ok(updatedContrat);

}




@DeleteMapping("/contrats/{id}")
public Map<String, Boolean> deleteContrat(@PathVariable(value = "id") Long contratId)
		throws ResourceNotFoundException {
	Contrat contrat = contratDao.findById(contratId)
			.orElseThrow(() -> new ResourceNotFoundException("Contrat not found for this id :: " + contratId));

	contratDao.delete(contrat);
	Map<String, Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return response;
}





	
	
}
