package day3;

import java.util.Scanner;

public class ConditionalStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter language: ");
		String input = sc.nextLine();
		
		if(input.equalsIgnoreCase("java"))
			System.out.println("Best Programming language");
	}

}
