package com.bah.msd.api;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.bah.msd.domain.Registration;
import com.bah.msd.repository.RegistrationRepository;

@RestController
@RequestMapping("/registrations")
public class RegistrationAPI {
	
	@Autowired
	RegistrationRepository regRepo;
	
	@GetMapping
	public Iterable<Registration> getAll() {
		return regRepo.findAll();
	}

	@GetMapping("/{registrationId}")
	public Optional<Registration> getRegistrationById(@PathVariable("registrationId") long id) {
		return regRepo.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody Registration newRegistration, UriComponentsBuilder uri){
		if (newRegistration.getId() != 0 || newRegistration.getEvent_id() == 0 
				|| newRegistration.getCustomer_id() == 0 || newRegistration.getRegistration_date() == null) {
			return ResponseEntity.badRequest().build();
		}
		
		newRegistration = regRepo.save(newRegistration);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
				.buildAndExpand(newRegistration.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
	}
	
	@PutMapping("/{registrationId}")
	public ResponseEntity<?> putCustomer(@RequestBody Registration newRegistration, 
			@PathVariable("registrationId") long registrationId){
		if (newRegistration.getId() != registrationId || newRegistration.getEvent_id() == 0 
				|| newRegistration.getCustomer_id() == 0 ) {
			return ResponseEntity.badRequest().build();
		}
		newRegistration = regRepo.save(newRegistration);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{registrationId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("registrationId") long id){
		regRepo.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
