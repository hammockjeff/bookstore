package org.homeproject.bookstore;

public class Book {

	 String title;
	 String author;
	 Person person;

	public Book(String string) {
		this.title = string;
		this.author = "unknown author";
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setPerson(Person p2) {
		this.person = p2;
	}

	public Person getPerson() {
		return this.person;
	}
	
	public String toString() {
		String bookString;
		String available;
		
		if (this.person == null) {
			available = "Available";
		} else {
			available = "Checked out to " + this.person.getName();
		}
		
		
		bookString = this.title + " by " + this.author + "; " + available;
		
		return bookString;
		
	}

}
