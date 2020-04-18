package com.mentor.safetynetalerts.repositories;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mentor.safetynetalerts.models.Database;

@Repository
public class DataRepository {
	
	//C'est ce qui permet de mapper du Json en objet Java.
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	//C'est le fichier json en mémoire
	private static Database database;
	
	
	//On va charger le fichiers data.json en mémoire dans l'objet Database
	public DataRepository() throws IOException {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("data.json");
		database = objectMapper.readerFor(Database.class).readValue(inputStream);
	}
	
	public static void main(String[] args) throws IOException {
		DataRepository dataRepository = new DataRepository();
		System.out.println(dataRepository.database.getPersons().size());
	}

}
