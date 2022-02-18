package Assignments;

import java.util.Scanner;

public class String_Assignment_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter one sentence: ");
		String sentence = sc.nextLine();
		
		boolean status = sentence.contains("?");
		
		if(status == true) {
			System.out.println("It's question sentence.");
			
			if(sentence.contains("Did") || sentence.contains("Had") ||sentence.contains("Have") || sentence.contains("Has") ) {
				System.out.println("It's not simple present tense.");
			}
			else {
				System.out.println("It's simple present tense.");
				}
			
		}else {
			System.out.println("It's not question sentence.");
		}
	}

}
