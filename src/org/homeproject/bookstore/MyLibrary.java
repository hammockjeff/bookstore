package org.homeproject.bookstore;
// library class
import java.util.ArrayList;

public class MyLibrary {

	 String name;
	 ArrayList<Book> books;
	 ArrayList<Person> people;

	public MyLibrary(String name) {
		this.name = name;
		books = new ArrayList<Book>();
		people = new ArrayList<Person>();
		
	}

	public String getName() {
		return name;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public ArrayList<Person> getPeople() {
		return people;
	}

	public void addBook(Book b1) {
		this.books.add(b1);
	}

	public void removeBook(Book b1) {
		this.books.remove(b1);
	}
	
	public void addPerson(Person p1) {
		this.people.add(p1);
	}
	
	public void removePerson(Person p1) {
		this.people.remove(p1);
	}

	public boolean checkOut(Book b1, Person p1) {
		int booksOut = this.getBooksForPerson(p1).size();
		if ((b1.getPerson() == null) &&
				(booksOut < p1.getMaximumBooks())){
			b1.setPerson(p1);
			return true;
		} else {
			return false;			
		}
	}

	public boolean checkIn(Book b1) {
		if (b1.getPerson() != null ) {
			b1.setPerson(null);
			return true;
		} else {
			return false;			
		}
	}

	public ArrayList<Book> getBooksForPerson(Person p1) {
		ArrayList <Book> result = new ArrayList<Book>();
		for (Book aBook : this.getBooks()) {
			if((aBook.getPerson() != null) && 
		(aBook.getPerson().getName()
					.equals(p1.getName()))){
				result.add(aBook);
			}			
		}
		return result;
	}

	public ArrayList<Book> getAvailableBooks() {
		ArrayList <Book> result = new ArrayList<Book>();
		for (Book aBook : this.getBooks()) {
			if(aBook.getPerson() == null){
				result.add(aBook);
			}			
		}
		return result;
	}

	public ArrayList<Book> getUnAvailableBooks() {
		ArrayList <Book> result = new ArrayList<Book>();
		for (Book aBook : this.getBooks()) {
			if(aBook.getPerson() != null){
				result.add(aBook);
			}			
		}
		return result;
	
	}
	
	public String toString(){
		String list;
		list = this.name + ": " + 
		this.getBooks().size() + 
		" books; " + 
		this.getPeople().size() + 
		" people";
		return list;
	}
	
public static void main(String[] args) {
	MyLibrary algonquin = new MyLibrary("Algonquin");
	Book b1 = new Book("The Bible");
	Book b2 = new Book("War and Peace");
	b1.author = "Mathew, Mark Luke and John";
	b2.author = "Leo Tolstoy";
	Person joe = new Person("Joe");
	Person mary = new Person ("Mary");
	algonquin.addPerson(joe);
	algonquin.addPerson(mary);
	algonquin.addBook(b1);
	algonquin.addBook(b2);
	
	
	
	System.out.println("Just Created a new Library");
	algonquin.printStatus();
	
	System.out.println("Check out War and Peace to Mary");
	algonquin.checkOut(b1,mary);
	algonquin.printStatus();
	
	System.out.println("anything else?");
	algonquin.checkIn(b1);
	algonquin.checkOut(b2, joe);
	
	algonquin.printStatus();

	

}

private void printStatus() {
  System.out.println("Status Report of My Library \n" + 
		  this.toString());
  
  for (Book libBook : this.getBooks()) {
	System.out.println(libBook);
}
  for (Person patron : this.getPeople()) {
	  int count = this.getBooksForPerson(patron).size();
	  System.out.println(patron.getName() + " has " + count + " of my books");
  }

	  
	 System.out.println("Available books " + this.getAvailableBooks().size());
	  
	System.out.println("--- End of Status ---");
}

}
