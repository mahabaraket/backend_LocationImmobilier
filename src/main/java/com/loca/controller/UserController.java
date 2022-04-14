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

import com.loca.dao.UserDao;
import com.loca.exception.ResourceNotFoundException;
import com.loca.modal.User;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")

public class UserController {

	
	@Autowired
	private UserDao userDao ; 
	
	
	@GetMapping("/users")
	public List<User> getAllUser() {
		return userDao.findAll();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
			throws ResourceNotFoundException {
		User user = userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		return ResponseEntity.ok().body(user);
	}
	
	
	@PostMapping("/users")
	public User createUser(@Validated @RequestBody User user) {
		return userDao.save(user);
	}
	
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
			@Validated @RequestBody User userDetails) throws ResourceNotFoundException {
		User user = userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setEmail(userDetails.getEmail());
		user.setSpecialite(userDetails.getSpecialite());

		user.setPassword(userDetails.getPassword());
		final User updatedUser = userDao.save(user);
		return ResponseEntity.ok(updatedUser);
	
}
	
	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
			throws ResourceNotFoundException {
		User user = userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

		userDao.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}