package day5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CustomeDateFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateTimeFormatter f1 = DateTimeFormatter.ofPattern("MM dd yyyy");
		DateTimeFormatter f2 = DateTimeFormatter.ofPattern("hh:m:s");
		DateTimeFormatter f3 = DateTimeFormatter.ofPattern("MM dd yyyy 'at' h:m:ss");
		
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.now();
		
		System.out.println("Date: "+date);
		System.out.println("Format: "+ date.format(f1));
		
		System.out.println("Time: "+time);
		System.out.println("Format: "+ time.format(f2));
		
		System.out.println("date time: "+ dateTime);
		System.out.println("Format: "+ dateTime.format(f3));
	}

}
