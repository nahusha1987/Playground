package com.home.practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample {
	public static void main(String[] args) throws IOException {
		List<Person> persons = new ArrayList<>();
		FileWriter fw = new FileWriter(new File("C:/Users/Baba/persons.txt"));
		for(int i = 0; i < 50; i++ )
			persons.add(PersonFactory.getPerson());
		for(Person p : persons) {
			fw.write(p.getName() + "   " + p.getAge() + "   " + p.getSalary() + "\n");
		}
		fw.close();
		Collections.sort(persons);
		fw = new FileWriter(new File("C:/Users/Baba/personSorted.txt"));
		for(Person p : persons) {
			fw.write(p.getName() + "   " + p.getAge() + "   " + p.getSalary() + "\n");
		}
		fw.close();
	}
}


class PersonFactory {
	static Person getPerson() {
		Person person = new Person();
		person.setName(CommonUtils.getRandomString().toLowerCase());
		person.setAge(Math.abs(CommonUtils.getRandomNumber(60)));
		person.setSalary(CommonUtils.getRandomDouble());
		return person;
	}
}
class Person implements Comparable<Person> {
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

	@Override
	public int compareTo(Person o) {
		//return this.getName().compareTo(o.getName());
		return this.getAge() -o.getAge();
	}
	
	
}