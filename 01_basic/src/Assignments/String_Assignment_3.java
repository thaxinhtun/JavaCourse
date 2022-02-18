package Assignments;

import java.util.Scanner;

public class String_Assignment_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter NRC no: ");
		String nrc = sc.nextLine();
		
		int index_number = nrc.indexOf(")");
		
		int index_township = nrc.indexOf("/");
//		System.out.println(index_township);
		int index_township1 = nrc.indexOf("(");
		
		System.out.println("Township: "+ nrc.substring(index_township +1, index_township1));
		System.out.println("Number: " + nrc.substring(index_number+1));
		
	}

}
