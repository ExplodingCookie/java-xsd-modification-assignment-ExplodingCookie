package com.cooksys.java_jaxbclasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Librarian {

	@XmlAttribute(name="age")
	private int age;

	@XmlAttribute(name="salary")
	private int salary;

	@XmlValue
	private String name;

	public Librarian() {
	}

	public Librarian(int age, int salary, String name) {
		this.age = age;
		this.salary = salary;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Librarian [age=" + age + ", salary=" + salary + ", name=" + name + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
