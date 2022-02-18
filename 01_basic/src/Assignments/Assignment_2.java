package Assignments;

import java.util.Scanner;

public class Assignment_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int zero_count = 0;
		int p_count = 0;
		int n_count = 0;
		
		System.out.print("How many numbers do you want to type: ");
		int n = sc.nextInt();
		
		for(var i=0; i<n; i++) {
			System.out.print("Enter number: ");
			int num = sc.nextInt();
			if(num == 0) {
				zero_count ++;
			}
			if(num <0) {
				n_count++;
			}
			if(num>0) {
				p_count++;
			}
		}
		sc.close();
		System.out.println("Numbers of zero: "+zero_count);
		System.out.println("Positive numbers: "+p_count);
		System.out.println("Negative numbers: "+n_count);
		
	}

}
