package day2;

import java.util.Scanner;

public class testing_2 {
	
	static final float RATE = 1.5f;
	static final int MIN_PRice = 1000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Price: ");
	int price = sc.nextInt();
	if(price< MIN_PRice)
		price = MIN_PRice;
	
	System.out.println("Expense: "+ (price * RATE));
	
	}

}
