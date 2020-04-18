package com.mentor.safetynetalerts.controllers;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.mentor.safetynetalerts.service.PersonService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ReadResourceController.class)
@AutoConfigureMockMvc
public class ReadResourceControllerTU {
	
	@Autowired
	MockMvc mockMVC;
	
	@MockBean
	PersonService personService;
	
	@Test
	void getCommunityEmail() throws Exception {
		//On mock le comportement de PersonService pour renvoyer des valeurs de mail
		Mockito.when(personService.getCommunityEmail("Culver")).thenReturn(Arrays.asList("a@a","b@b","c@c"));
		//On envoie une requete GET avec en parametre Culver
		mockMVC.perform(MockMvcRequestBuilders.get("/communityEmail").param("city", "Culver"))
		//On vérifie que le status de la reponse est 200
		.andExpect(MockMvcResultMatchers.status().isOk());
		//On vérifie que le service a bien était appelé avec le bon parametre 
		Mockito.verify(personService,Mockito.times(1)).getCommunityEmail("Culver");
		
	}

}
