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
		 * Nous allons explorer les stream � travers un petit use case ( pour que cela reste un peu rigolo)
		 * Nous sommes une entreprise en pleine croissance, et nous avons � notre disposition une liste de nos employ�es 
		 * Regardons ce qu'on peut faire avec 
		 */
		
		// Notre PDG, G�rard, voudrait connaitre le nom de tous ses employ�s
		listPerson.stream()
				  .forEach(p-> System.out.println(p.getName())); //print the name of all the person in the list
		
		/* G�rard souhaite r�compenser les personnes ayant une anciennet� de plus de 10 ans dans l'entreprise, 
		* pour les remercier de leur travail de puis le d�but. Nous devons donc dans un premier temps r�cup�r� cette cat�gorie de population dans notre liste
		regardons comment r�cup�r� cette infos en utilisant les stream */
		
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
