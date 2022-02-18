package day3;

import java.util.Scanner;

public class UserInput_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name: ");
		String name = sc.nextLine();
		
		System.out.println("Enter Salary: ");
		double salary = sc.nextDouble();
		
		System.out.println("Enter age: ");
		int age = sc.nextInt();
		
		sc.close();
		
	}

}
