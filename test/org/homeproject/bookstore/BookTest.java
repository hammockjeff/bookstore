package org.homeproject.bookstore;

import junit.framework.TestCase;

public class BookTest extends TestCase {
	public void testBook() {
		Book b1 = new Book("Moby Dick");
		assertEquals("Moby Dick", b1.title);
		assertEquals("unknown author", b1.author);
	}
	
	public void testGetPerson() {
		Book b2 = new Book("War and Peace");
		Person p2 = new Person();
		p2.setName("Elvis");
		b2.setPerson(p2);
		
//		Person testPerson = b2.getPerson();
//		String testName = testPerson.getName();
		
		String testName = b2.getPerson().getName();
		assertEquals("Elvis", testName);	
		
	}
	
	public void testToString() {
		Book b2 = new Book("War and Peace");
		Person p2 = new Person();
		p2.setName("Elvis");

		
		assertEquals("War and Peace by unknown author; Available", b2.toString());
		b2.setAuthor("Leo Tolstoy");
		assertEquals("War and Peace by Leo Tolstoy; Available", b2.toString());

	}
	
}
