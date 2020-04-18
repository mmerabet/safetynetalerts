package com.mentor.safetynetalerts.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.safetynetalerts.models.Person;
import com.mentor.safetynetalerts.repositories.DataRepository;

@Service
public class PersonService {
	
	@Autowired
	private DataRepository dataRepository;

	public Collection<String> getCommunityEmail(String city) {
		Collection<String> collectionEmails = new HashSet<String>();
		for ( Person person : dataRepository.getPersonsByCity(city)) {
			collectionEmails.add(person.getEmail());
		}
		return collectionEmails;
	}

}
