package com.cooksys.java_jaxbclasses;

import java.util.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Library {
	
	@XmlElement
	private String name;
	
	@XmlElementWrapper
	@XmlElement(name="librarian")
	private List<Librarian> librarians;
	
	@XmlElementWrapper
	@XmlElement(name="author")
	private List<Author> authors;
	
	public Library () {}
	
	public Library (String name, List<Librarian> librarians, List<Author> authors) {
		this.name = name;
		this.librarians = librarians;
		this.authors = authors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Librarian> getLibrarians() {
		return librarians;
	}

	public void setLibrarians(List<Librarian> librarians) {
		this.librarians = librarians;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
	
}
