package day3;

import java.util.Scanner;

public class ConditionalStatement_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter your bmi: ");
	float bmi  = sc.nextFloat();
	
	if(bmi<18.5)
		System.out.println("Underweight");
	else if(bmi>=18.5 && bmi <=24.9)
		System.out.println("Normal");
	else if (bmi>=22 && bmi<=29.9)
		System.out.println("Overweight");
	else
		System.out.println("Obesty");
	sc.close();
	}

}
