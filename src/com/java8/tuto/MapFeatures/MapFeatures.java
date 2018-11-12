package com.java8.tuto.MapFeatures;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class MapFeatures {

	public static void main(String[] args) {
		Map<String, Integer> stockProduit = new HashMap<>();

		// putIfAbsent 
		
		stockProduit.putIfAbsent("REF-001", 10);
		// return {REF-001=10}

		stockProduit.putIfAbsent("REF-001", 20);
		// return {REF-001=10} because key=REF-001 is already present in the map
		
		
		//Init map with random value
		for (int i = 2; i < 10; i++) {		
			stockProduit.putIfAbsent("REF-00"+i, getStreamOfRandomInts(5,20));
		}
		
		
		// forEach 
		// return all couples of the map
		stockProduit.forEach((key,value) -> System.out.println("Key => "+key+" Value => "+value));
		
		// compute
		stockProduit.compute("REF-001", (key, value) -> null);
		//The couple with key : "REF-001" is deleted from the map
		
		stockProduit.compute("REF-002", (key, value) -> value + 10);
		// Update the value of key : "REF-002" by 10
		
		
		//computeIfAbsent
		stockProduit.computeIfAbsent("REF-001", value -> 5);
		stockProduit.get("REF-001"); // Return 5, 
		
		stockProduit.computeIfAbsent("REF-001", value -> 15);
		stockProduit.get("REF-001"); // Return 5, beacause value of REF-001 is not null
		
		//computeIfPresent
		stockProduit.computeIfPresent("REF-001", (key,value) -> value + 10);
		stockProduit.get("REF-001"); // return 15
		
		stockProduit.computeIfPresent("REF-001", (key,value) -> value + 5);
		stockProduit.get("REF-001"); // return 20 beacause : 15 + 5 ==> 20
		
		stockProduit.computeIfPresent("REF-001", (key,value) -> null); // remove the couple with key "REF-001" from the map
		
		stockProduit.computeIfPresent("REF-50", (key,value) -> 20); // won't add to the map
		
		
		//getOrdefault
		
		stockProduit.getOrDefault("REF-001", -1); // return -1 because "REF-001" dors not exist anymore
		stockProduit.getOrDefault("REF-002", -1); // return value of "REF-002"
		

		//remove
		stockProduit.computeIfAbsent("REF-001", value -> 15);
		
		stockProduit.remove("REF-001", 5); // won't delete because value does not match
		stockProduit.remove("REF-001", 15); // delete succesfull

		
		//merge
		stockProduit.merge("REF-002", 100, (v1, v2)-> v1+v2);

		//replace 
		stockProduit.put("REF-001", 1);
		stockProduit.replace("REF-001", 5, 2); // won't change because the old value does not match
		stockProduit.replace("REF-001", 1, 2); // value will change from 1 to 2
		
		//replaceAll
		//replace all the value where value is even 
		stockProduit.replaceAll((key, value)-> value%2 == 0 ? value+ 100 : value);
		
		//Trick : How to sort a sort a map 
		//Sort by value 
		
		Map<String, Integer> sortedMapByValue = stockProduit.entrySet().stream()
												.sorted(Map.Entry.comparingByValue())
												.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
												(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		//Map<Striung, Ineteger>
		Map<String, Integer> sortedMapByKey = stockProduit.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		System.out.println(sortedMapByKey);
		
		System.out.println("REF-010".compareTo("REF-002"));
	}

	public static int getStreamOfRandomInts(int min, int max) {
		Random r = new Random();
		return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
	}

}
