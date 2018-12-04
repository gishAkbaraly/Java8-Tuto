package com.java8.tuto.functionalprogramming.main;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static java.time.Month.*;
import static java.time.temporal.ChronoUnit.DAYS;

import com.java8.tuto.functionalprogramming.businesslogic.EmployeeService;
import com.java8.tuto.functionalprogramming.model.Employee;

public class Main {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
				new Employee.EmployeeBuilder().withFunction("DEVELOPER").withSalary(1000.0).build(),
				new Employee.EmployeeBuilder().withFunction("MANAGER").withSalary(730.0).build(), 
				new Employee.EmployeeBuilder().withFunction("DEVELOPER").withSalary(880.0).build(),
				new Employee.EmployeeBuilder().withFunction("MANAGER").withSalary(715.0).build());
		
		Function<Employee, Integer> getAgeInDays = (e) -> Long.valueOf(DAYS.between(LocalDate.now(), e.getBirthDate())).intValue();
		
		//EmployeeService.sortByAge(employees,getAgeInDays);
		
		employees = EmployeeService.increaseSalary(employees, 1.50, (salary, percent)-> salary * percent);
		System.out.println(employees);
		
	}
}
