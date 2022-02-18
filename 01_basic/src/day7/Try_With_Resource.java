package day7;

import java.util.Scanner;

public class Try_With_Resource {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter salary: ");
			int salary =sc.nextInt();
			System.out.println("Salary: "+salary);
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		
	}

}
