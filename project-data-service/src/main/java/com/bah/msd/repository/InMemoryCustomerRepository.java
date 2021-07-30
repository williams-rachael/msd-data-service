package com.bah.msd.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.bah.msd.domain.Customer;

@Component
public class InMemoryCustomerRepository {
	
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	public InMemoryCustomerRepository() {
		Customer c1 = new Customer(1, "Nicholas", "pass", "nichloa@bah.com");
		Customer c2 = new Customer(2, "Alisha", "pass", "alisha@bah.com");
		Customer c3 = new Customer(3, "Carsen", "pass", "carsen@bah.com");
		Customer c4 = new Customer(4, "Julia", "pass", "julie@bah.com");
		Customer c5 = new Customer(5, "Joel", "pass", "joel@bah.com");
		Customer c6 = new Customer(6, "Kimberly", "pass", "kimberly@bah.com");
		Customer c7 = new Customer(7, "Kyle", "pass", "kyle@bah.com");
		Customer c8 = new Customer(8, "Emily", "pass", "emily@bah.com");
		customerList.add(c1);
		customerList.add(c2);
		customerList.add(c3);
		customerList.add(c4);
		customerList.add(c5);
		customerList.add(c6);
		customerList.add(c7);
		customerList.add(c8);
	}
	
	public ArrayList<Customer> getCustomerList(){
		return customerList;
	}

	public Customer getCustomerById(long id) {
		Customer customer = null;
		for (int i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).getId() == id) {
				customer = customerList.get(i);
			}
		}
		return customer;
	}
	
}
