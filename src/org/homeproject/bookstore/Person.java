package org.homeproject.bookstore;

public class Person {
	// fields
	private String name; // name of the person
	private int maximumBooks; // most books the person can check out
	// constructors
	public Person() {
		name = "unknown name";
		maximumBooks = 3;
		}
	
	public Person(String patronName) {
		name = patronName;
		maximumBooks = 3;
		}
	
	
	//methods

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaximumBooks() {
		return maximumBooks;
	}
	public void setMaximumBooks(int maximumBooks) {
		this.maximumBooks = maximumBooks;
	}
	
	public String toString() {
		return this.getName() + " (" + this.getMaximumBooks() + " books)";
	}

}
