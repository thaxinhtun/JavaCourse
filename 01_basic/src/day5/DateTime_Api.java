package day5;

import java.time.LocalDate;

public class DateTime_Api {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate date = LocalDate.now();
		LocalDate date1 = LocalDate.of(2016, 10, 31);
		LocalDate date2 = LocalDate.parse("2016-10-31");
		
		System.out.println("Current: "+ date);
		LocalDate yest = date.minusDays(1);
		System.out.println("yesterday: "+ yest);
		System.out.println("Tomorrow: "+ date.plusDays(1));
		
		System.out.println("Year: "+ date.getYear());
		System.out.println("Month: "+date.getMonth());
		System.out.println("Day: "+ date.getDayOfWeek());
		
		System.out.println("Leap Year(2016): "+ date2.isLeapYear());
		System.out.println(date1.equals(date2));
		System.out.println("2022 is after 2016: "+ date.isAfter(date1));
		System.out.println("2022 is before 2016: "+ date.isBefore(date1));
	}

}
