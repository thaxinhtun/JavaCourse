package day7;

import java.util.Scanner;

public class try_finally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		try {
			
			System.out.println("Enter Salary: ");
			int salary = Integer.parseInt(sc.nextLine());
			if(salary == 0 )
				return;
			System.out.println("Your salary: "+salary);
		}
		finally {
			sc.close();
			System.out.println("This is finally block");
		}
		System.out.println("Outside try finally block");
	}

}
