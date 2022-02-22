package day8_OOP;

import java.time.LocalDate;

public class Copy_Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate pubDte = LocalDate.of(1961, 10, 16);
		Book book1 = new Book("Detective U San Shar",pubDte,6000);
		System.out.println(book1.toString());
		
		Book book2 = new Book(book1);
		System.out.println(book2);
	}

}
class Book{
	String title;
	LocalDate publishDate;
	int price;
	public Book(String title, LocalDate pDate,int price) {
		this.title = title;
		this.publishDate = pDate;
		this.price = price;
	}
	public Book(Book other) {//copy constructor
		this.title = other.title;
		this.publishDate = other.publishDate;
		this.price = other.price;
	}
	@Override
	public String toString() {
		String str = "[" + title +","+ publishDate +"," +price +"]";
		return str;
	}
}
