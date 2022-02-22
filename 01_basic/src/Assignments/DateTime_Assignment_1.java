package Assignments;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTime_Assignment_1 {

	public static void main(String[] args) {
		
		String[] weekends = {"Saturday","Sunday"};
		boolean status = false;
		LocalDate now = LocalDate.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMM dd yyyy");
		
		System.out.println(now.getDayOfWeek() +" , "+ now.format(dateFormat));
		System.out.println("**********");
		
		for(String weekend : weekends) {
		if(weekend.equalsIgnoreCase(now.getDayOfWeek().toString())) {
			System.out.println("Today is my holiday!");
			status = true;
			break;
		}
	}
		if(status == false) {
		System.out.println("I am busy.I'm studying programming language!");
		}
}
}

