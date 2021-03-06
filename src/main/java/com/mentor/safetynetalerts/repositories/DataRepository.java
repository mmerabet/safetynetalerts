package com.mentor.safetynetalerts.repositories;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mentor.safetynetalerts.models.Database;
import com.mentor.safetynetalerts.models.Person;

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
	
	//Méthode pour recuperer les Persons
	public Collection<Person> getPersonsByCity(String city){
		Collection<Person> collectionPersons = new ArrayList<Person>();
		for (Person person : database.getPersons()) {
			if (person.getCity().equalsIgnoreCase(city)) {
				collectionPersons.add(person);
			}
		}
		return collectionPersons;
	}
	
	
//	On test notre mappeur
//	public static void main(String[] args) throws IOException {
//		DataRepository dataRepository = new DataRepository();
//		System.out.println(dataRepository.database.getPersons().size());
//	}

}
