package com.cooksys.java_jaxbclasses;

import java.util.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Author {
	
	@XmlAttribute(name="author")
	private String name;
	
	@XmlElement(name="book")
	private List<Book> books;
	
	public Author () {}
	
	public Author (String name, List<Book> books) {
		this.name = name;
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", books=" + books + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
}
