package com.java8.tuto.functionalprogramming.businesslogic;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import com.java8.tuto.functionalprogramming.model.Employee;

public class EmployeeService {

	
	public static List<Employee> sortByFirstName(List<Employee> employees, boolean ascending) {
		Comparator<Employee> compareFirstName = Comparator.comparing(Employee::getFirstName);
		Comparator<Employee> compareFirstNameReversed = compareFirstName.reversed();
		
		employees.sort((e1,e2)->
		ascending ?
				compareFirstName.compare(e1, e2) 
                : compareFirstNameReversed.compare(e1, e2)
		);
		return employees;
	}
	
	public static List<Employee> sortByAge(List<Employee> employees, Function<Employee, Integer> function) {		
		employees.sort((e1,e2)-> function.apply(e1).compareTo(function.apply(e2)));
		return employees;
	}
	
	public static List<Employee> increaseSalary(List<Employee> employees, Double increase, BinaryOperator<Double> increaseFunc){
		employees.stream()
				.forEach((e) -> e.setSalary(increaseFunc.apply(e.getSalary(),increase)));
		return employees;
	}
	
	
}
