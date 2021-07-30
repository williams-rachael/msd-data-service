package com.bah.msd.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bah.msd.domain.Registration;
import com.bah.msd.repository.InMemoryRegistrationRepository;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {
	
	@Autowired
	InMemoryRegistrationRepository regRepo;
	
	@GetMapping
	public Collection<Registration> getAll() {
		return regRepo.getRegistrationList();
	}

	@GetMapping("/{registrationId}")
	public Registration getRegistrationById(@PathVariable("registrationId") long id) {
		return regRepo.getRegisreationById(id);
	}

}
