package com.java8.tuto.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.java8.tuto.model.Person;

public class Stream {
	
	public static void main(String[] args) {
		List<Person> listPerson = Arrays.asList(
				new Person("Julien", "Mathieu", 50, 30),
				new Person("Julien", "Boucher", 35, 5),
				new Person("Laurent", "Michot", 42, 12),
				new Person("Candice", "Lerman", 25, 1)
		);
		
		/*
		 * Nous allons explorer les stream à travers un petit use case ( pour que cela reste un peu rigolo)
		 * Nous sommes une entreprise en pleine croissance, et nous avons à notre disposition une liste de nos employées 
		 * Regardons ce qu'on peut faire avec 
		 */
		
		// Notre PDG, Gérard, voudrait connaitre le nom de tous ses employés
		listPerson.stream()
				  .forEach(p-> System.out.println(p.getName())); //print the name of all the person in the list
		
		/* Gérard souhaite récompenser les personnes ayant une ancienneté de plus de 10 ans dans l'entreprise, 
		* pour les remercier de leur travail de puis le début. Nous devons donc dans un premier temps récupéré cette catégorie de population dans notre liste
		regardons comment récupéré cette infos en utilisant les stream */
		
		List<Person> result = listPerson.stream()
				  .filter(p -> p.getSeniority() > 10)
				  .collect(Collectors.toList());
		
		
		
		listPerson.stream()
				  .map(p-> {
					  p.setAge(p.getAge()+100);
					  return p.getAge();
				  });
				  
		
		
				  
						 
		
	}
}
