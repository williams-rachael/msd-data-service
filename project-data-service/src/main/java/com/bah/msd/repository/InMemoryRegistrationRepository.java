package com.bah.msd.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Component;

import com.bah.msd.domain.Registration;

@Component
public class InMemoryRegistrationRepository {
	
	ArrayList<Registration> regList = new ArrayList<Registration>();
	
	public InMemoryRegistrationRepository() {
		Registration r1 = new Registration(1, 1, 1, new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime(), 
				"looking forward to the event");
		Registration r2 = new Registration(2, 1, 2, new GregorianCalendar(2019, Calendar.JANUARY, 5).getTime(), 
				"is parking available?");
		regList.add(r1);
		regList.add(r2);
	}

	public ArrayList<Registration> getRegistrationList(){
		return regList;
	}

	public Registration getRegisreationById(long id) {
		Registration registration = null;
		for (int i = 0; i < regList.size(); i++) {
			if (regList.get(i).getId() == id) {
				registration = regList.get(i);
			}
		}
		return registration;
	}
	
}
