package com.home.practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {

	public static void main(String[] args) throws IOException {

		List<Employee> employees = new ArrayList<>();
		FileWriter fw = new FileWriter(new File("C:/Users/Baba/persons.txt"));
		for (int i = 0; i < 10; i++)
			employees.add(EmployeeFactory.getEmployee());
		for (Employee e : employees) {
			fw.write(e.getName() + "   " + e.getAge() + "   " + e.getSalary() + "\n");
		}
		fw.close();
		SalaryComparator sc = new SalaryComparator();
		Collections.sort(employees,sc);
		fw = new FileWriter(new File("C:/Users/Baba/personSorted.txt"));
		for (Employee e : employees) {
			fw.write(e.getName() + "   " + e.getAge() + "   " + e.getSalary() + "\n");
		}
		fw.close();
	}
}

class SalaryComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return (int) o1.getSalary() - (int) o2.getSalary();
	}

}

class AgeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getAge() - o2.getAge();
	}

}

class EmployeeFactory {
	static Employee getEmployee() {
		Employee employee = new Employee();
		employee.setName(CommonUtils.getRandomString().toLowerCase());
		employee.setAge(Math.abs(CommonUtils.getRandomNumber(60)));
		employee.setSalary(CommonUtils.getRandomDouble());
		return employee;
	}
}

class Employee {
	
	private String name;

	private int age;

	private double salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
