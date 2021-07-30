package com.bah.msd.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bah.msd.domain.Customer;
import com.bah.msd.repository.InMemoryCustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	InMemoryCustomerRepository customerRepo;
	
	@GetMapping
	public Collection<Customer> getAll() {
		return customerRepo.getCustomerList();
	}

	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable("customerId") long id) {
		return customerRepo.getCustomerById(id);
	}

}
