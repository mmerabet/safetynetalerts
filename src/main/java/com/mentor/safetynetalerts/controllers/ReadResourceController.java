package com.mentor.safetynetalerts.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mentor.safetynetalerts.service.PersonService;

@RestController
public class ReadResourceController {
	
	@Autowired
	private PersonService personService;
	
	
	@GetMapping(path="communityEmail")
	public Collection<String> getCommunityEmail(@RequestParam String city) {
		return personService.getCommunityEmail(city);
	}


}
