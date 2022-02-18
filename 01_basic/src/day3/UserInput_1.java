package day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter name: ");
		String name = reader.readLine();
		System.out.print("Enter Salary: ");
		double salary = Double.parseDouble(reader.readLine());//string to int
		System.out.println("Enter age: ");
		int age = Integer.parseInt(reader.readLine());//string -> int
		
		reader.close();//close
		
		System.out.println("Name: "+ name);
		System.out.println("Salary: "+salary);
		System.out.println("Age: "+age);
	}

}
