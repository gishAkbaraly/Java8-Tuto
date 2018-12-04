package com.java8.tuto.functionalprogramming.model;

import java.time.LocalDate;

public class Employee {
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private String function;
	private Double salary;
	private Genre genre;

	private Employee(EmployeeBuilder employeeBuilder) {
		firstName = employeeBuilder.firstName;
		lastName = employeeBuilder.lastName;
		birthDate = employeeBuilder.birthDate;
	    function = employeeBuilder.function;
	    salary = employeeBuilder.salary;
	    genre = employeeBuilder.genre;
	    
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public String getFunction() {
		return function;
	}

	public Genre getGenre() {
		return genre;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Employee employee = (Employee) o;

		if (birthDate != null ? !birthDate.equals(employee.birthDate) : employee.birthDate != null)
			return false;
		if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null)
			return false;
		if (function != null ? !function.equals(employee.function) : employee.function != null)
			return false;
		if (genre != employee.genre)
			return false;
		if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null)
			return false;
		if (salary != null ? !salary.equals(employee.salary) : employee.salary != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = firstName != null ? firstName.hashCode() : 0;
		result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
		result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
		result = 31 * result + (function != null ? function.hashCode() : 0);
		result = 31 * result + (salary != null ? salary.hashCode() : 0);
		result = 31 * result + (genre != null ? genre.hashCode() : 0);
		return result;
	}
	
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", function=" + function + ", salary=" + salary + ", genre=" + genre + "]";
	}

	public static class EmployeeBuilder {
		private String firstName;
		private String lastName;
		private LocalDate birthDate;
		private String function;
		private Double salary;
		private Genre genre;

		public EmployeeBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public EmployeeBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public EmployeeBuilder withBirthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public EmployeeBuilder withFunction(String function) {
			this.function = function;
			return this;
		}

		public EmployeeBuilder withSalary(Double salary) {
			this.salary = salary;
			return this;
		}

		public EmployeeBuilder withGenre(Genre genre) {
			this.genre = genre;
			return this;
		}

		public Employee build() {
			return new Employee(this);
		}
	}
}
