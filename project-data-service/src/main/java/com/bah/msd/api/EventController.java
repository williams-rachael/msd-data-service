package com.bah.msd.api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bah.msd.domain.Event;
import com.bah.msd.repository.InMemoryEventRepository;

@RestController
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	InMemoryEventRepository eventRepo;
	
	@GetMapping
	public Collection<Event> getAll() {
		return eventRepo.getEventList();
	}

	@GetMapping("/{eventId}")
	public Event getEventById(@PathVariable("eventId") long id) {
		return eventRepo.getEventById(id);
	}

}
