package Assignments;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTime_Assignment_1 {

	public static void main(String[] args) {
		
		String[] weekends = {"Saturday","Sunday"};
		
		LocalDate now = LocalDate.now();
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMM dd yyyy");
		
		System.out.println(now.getDayOfWeek() +" , "+ now.format(dateFormat));
		System.out.println("**********");
		
		for(String weekend : weekends) {
			if(weekend.equalsIgnoreCase(now.getDayOfWeek().toString())) {
				System.out.println("Today is my holiday!");
				break;
			}
			else {
				System.out.println("I have no time. I am studying Programming Language!");
				break;
			}
		
	}
	}
}

