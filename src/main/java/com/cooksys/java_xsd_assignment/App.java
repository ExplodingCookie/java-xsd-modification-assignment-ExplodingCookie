package com.cooksys.java_xsd_assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.cooksys.java_jaxbclasses.Library;
import com.cooksys.java_jaxbclasses.Librarian;
import com.cooksys.java_jaxbclasses.MySchemaOutputResolver;
import com.cooksys.java_jaxbclasses.Author;
import com.cooksys.java_jaxbclasses.Book;

public class App 
{
	public static Marshaller createMarshaller (JAXBContext context) {
		try {
			return context.createMarshaller();
		} catch (JAXBException e) {
			System.out.println("ERROR: Marshaller creation failed.");
		}
		return null;
	}
	
	public static Unmarshaller createUnmarshaller (JAXBContext context) {
		try {
			return context.createUnmarshaller();
		} catch (JAXBException e) {
			System.out.println("ERROR: Unmarshaller creation failed.");
		}
		return null;
	}
	
    public static void main( String[] args )
    {
    	JAXBContext context = null;
        try {
        	context = JAXBContext.newInstance(Library.class, Librarian.class, Author.class, Book.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR: JAXB Context creation failed.");
		}
        
        Marshaller m = createMarshaller(context);
        Unmarshaller um = createUnmarshaller(context);
        
        List<Librarian> librarians = new ArrayList<Librarian>();
        librarians.add(new Librarian(23, 31567, "Jasmine"));
        librarians.add(new Librarian(61, 54376, "Gregor"));
        
        List<Book> author1Books = new ArrayList<Book>();
        author1Books.add(new Book("mystery", "1998", "Flames of Avarice"));
        author1Books.add(new Book("mystery", "1999", "Cut from the Cold"));
        author1Books.add(new Book("mystery", "2000", "Into the Triangle"));
        
        List<Book> author2Books = new ArrayList<Book>();
        author2Books.add(new Book("action", "2010", "Warrunner"));
        author2Books.add(new Book("action", "2012", "Warrunner 2: Revenge"));
        author2Books.add(new Book("action", "2014", "Warrunner 3: A New World"));
        author2Books.add(new Book("action", "2012", "Warrunner 4: Ender"));
        
        List<Author> authors = new ArrayList<Author>();
        authors.add(new Author("E. Jaygen", author1Books));
        authors.add(new Author("R. Santiago", author2Books));
        
        Library library = new Library("Library of Byhalia", librarians, authors);
        
        try {
        	m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        	m.marshal(library, new FileOutputStream("MyLibrary.xml"));
        } catch (JAXBException e) {
        	System.out.println("ERROR: Failed to marshall the file.");
        } catch (FileNotFoundException e) {
        	System.out.println("ERROR: File not found.");
        }
        
        try {
			Library unmarshalledLib = (Library) um.unmarshal(new FileInputStream("MyLibrary.xml"));
			System.out.println(unmarshalledLib);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		} catch (JAXBException e) {
			System.out.println("Unable to unmarshall file.");
			e.printStackTrace();
		}
        
        try {
        	context.generateSchema(new MySchemaOutputResolver("MyLibrary.xsd"));
        } catch (IOException e) {
        	System.out.println("Schema generation failed.");
        }
    }
}
