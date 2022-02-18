package Assignments;

import java.util.Scanner;

public class Assignment_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Data for your profile.....");
		
		System.out.print("Full name: ");
		String name = sc.nextLine();
		
		System.out.print("Phone No: ");
		String ph = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Education: ");
		String edu = sc.nextLine();
		
		System.out.print("Income: ");
		double income = sc.nextDouble();
		
		System.out.print("Age: ");
		int age = sc.nextInt();
		
		sc.close();
		
		System.out.println("**************");
		System.out.println("Name: "+name);
		System.out.println("Phone No: "+ph);
		System.out.println("Email: "+email);
		System.out.println("Education: "+edu);
		System.out.println("Income: "+income);
		System.out.println("Age: "+age);
	}

}
