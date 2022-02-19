package Assignments;

import java.util.Scanner;

public class Exception_Handling {
	
	public Exception_Handling() {
		
	}
	public Exception_Handling(String ar) {
		Scanner sc = new Scanner(System.in);
		String[] arr;
		for(int i=0 ; i<3 ;i++) {
			System.out.println("Enter value");
			ar = sc.nextLine();
		}
		System.out.println(ar);
	}
	public static void main(String[] args) {
	
	}
	
	

}
