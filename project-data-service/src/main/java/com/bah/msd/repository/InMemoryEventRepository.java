package com.bah.msd.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.bah.msd.domain.Event;

@Component
public class InMemoryEventRepository {
	
	ArrayList<Event> eventList = new ArrayList<Event>();
	
	public InMemoryEventRepository() {
		Event e1 = new Event(100, "CNF001", "All-Java Conference", "Lectures and exhibits covering all Java topics");
		Event e2 = new Event(101, "CNC001", "Rock Concert", "Full blown rock concert");
		eventList.add(e1);
		eventList.add(e2);
	}
	
	public ArrayList<Event> getEventList(){
		return eventList;
	}

	public Event getEventById(long id) {
		Event event = null;
		for (int i = 0; i < eventList.size(); i++) {
			if (eventList.get(i).getId() == id) {
				event = eventList.get(i);
			}
		}
		return event;
	}

}
