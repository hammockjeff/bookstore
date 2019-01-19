package org.homeproject.bookstore;

import java.util.ArrayList;

import junit.framework.TestCase;

public class MyLibraryTest extends TestCase {
	
	private Book b1;
	private Book b2;
	private Person p1;
	private Person p2;
	private MyLibrary ml;

	//test constructer
	public void testMyLibrary() {
		MyLibrary ml = new MyLibrary("Test");
		
		assertEquals("Test", ml.name);
		assertTrue(ml.books instanceof ArrayList);
		assertTrue(ml.people instanceof ArrayList);
		
//		Book b1 = new Book("The Grapes of wrath");
//		ml.books.add(b1);
//		assertEquals("Pig Latin", ml.books.);	
}
	
	public void setup() {
		b1 = new Book("The Bible");
		b2 = new Book("War and Peace");
		p1 = new Person();
		p2 = new Person();
		p1.setName("Fred");
		p2.setName("Ethel");
		ml = new MyLibrary("Borders");
	}
	
	public void testAddBook() {
		// create test object
		setup();
		// test initial size is 0
		assertEquals(0, ml.getBooks().size());
		ml.addBook(b1);
		ml.addBook(b2);
		assertEquals(2, ml.getBooks().size());
		assertEquals(0, ml.getBooks().indexOf(b1));
		assertEquals(1, ml.getBooks().indexOf(b2));
		
		ml.removeBook(b1);
		assertEquals(1, ml.getBooks().size());
		assertEquals(0, ml.getBooks().indexOf(b2));
		
		ml.removeBook(b2);
		assertEquals(0, ml.getBooks().size());
	}
	
	public void testCheckOut() {
		//set up book list
		setup();
		addItems();
		assertTrue ("Book Checkout Failed", ml.checkOut(b1,p1));
		
		assertEquals("Fred", b1.getPerson().getName());
		
		assertFalse ("Book already checked out", ml.checkOut(b1,p2));
		assertTrue("Book Checkin Failed", ml.checkIn(b1));
		
		assertFalse("Book was already checked in", ml.checkIn(b1));

		assertFalse ("Book was never checked out", ml.checkIn(b2));

		// maximum tests
		p1.setMaximumBooks(1);
		addItems();
		assertTrue ("First Book Checkout Failed", ml.checkOut(b2,p1));
		assertFalse("Second book should not have checked out", ml.checkOut(b1,p1));
	}

	private void addItems() {
		ml.addBook(b1);
		ml.addBook(b2);
		ml.addPerson(p1);
		ml.addPerson(p2);
	}
	
	public void testGetBooksForPerson() {
		setup();
		addItems();
		
		assertEquals(0, ml.getBooksForPerson(p1).size());
		
		ml.checkOut(b1, p1);
		ArrayList<Book> testBooks = ml.getBooksForPerson(p1);
		assertEquals(1, testBooks.size());
		assertEquals(0,testBooks.indexOf(b1));
		
		ml.checkOut(b2, p1);
		testBooks = ml.getBooksForPerson(p1);
		assertEquals(2, testBooks.size());
		assertEquals(1,testBooks.indexOf(b2));
		
	}
	
	public void testGetAvailableBooks(){
		setup();
		addItems();
		ArrayList<Book> testBooks = ml.getAvailableBooks();
		assertEquals(2, testBooks.size());
		assertEquals(1,testBooks.indexOf(b2));
		
		ml.checkOut(b1, p1);
		testBooks = ml.getAvailableBooks();
		assertEquals(1, testBooks.size());
		assertEquals(0,testBooks.indexOf(b2));

		ml.checkOut(b2, p2);
		testBooks = ml.getAvailableBooks();
		assertEquals(0, testBooks.size());

	}
	
	public void testGetUnAvailableBooks(){
		setup();
		addItems();
		ArrayList<Book> testBooks = ml.getUnAvailableBooks();
		assertEquals(0, testBooks.size());
		
		ml.checkOut(b1, p1);
		testBooks = ml.getUnAvailableBooks();
		assertEquals(1, testBooks.size());
		assertEquals(0,testBooks.indexOf(b1));

		ml.checkOut(b2, p1);
		testBooks = ml.getUnAvailableBooks();
		assertEquals(2, testBooks.size());
		assertEquals(1,testBooks.indexOf(b2));

	}
	
	public void testToString(){
		setup();
		addItems();
		assertEquals("Borders: 2 books; 2 people", ml.toString());
		
	}
	
}