package Assignments;

import java.util.Scanner;

public class Exception_Handling_1 {
	
	public Exception_Handling_1() {
		
	}
	static int sum =0; static int avg =0, max =0,min =0;
	static void arrayTostring(String[] arrs){
		try {
			System.out.println("Values in arrays: ");
			for(int i = 0 ; i <= arrs.length;  i++) { //when i equal length of array, array index out of bound exception were occured.
				int arr = Integer.parseInt(arrs[i]); 
				sum = sum +arr;
				min = arr;
				System.out.println(arr);
				if(arr > max) {
					max = arr;
				}
				if(arr < min) {
					min = arr;
				}
			}
			avg = sum/arrs.length; //when sum is divided by 0, arithmetic exception.
			
			//avg = sum/0;
			System.out.println("Average: " + avg );
			System.out.println("Max: "+ max);
			System.out.println("Min: "+ min);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage() +" \n");
		}
		catch(IllegalArgumentException e) {
			System.err.println(e.getMessage() + " Please enter only integer\n");
		}
		catch(ArithmeticException e) {
			System.err.println(e.getMessage() + " Cannot divide by zero\n");
		}
	}
	public static void main(String[] args) {
		String[] array = {"45","50","30"};
		String[] array1 = {"45","h","30"};
		arrayTostring(array);
		arrayTostring(array1);
		
	}
	
	
	

}
