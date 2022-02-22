package Assignments;

import java.util.Scanner;

class InvaildMarkException extends Exception {
	public InvaildMarkException() {
		
	}
	public InvaildMarkException(String msg) {
		super(msg);
	}

}

public class Exception_Handling_3 {
	
	static void checkMark(int mark) throws InvaildMarkException{
		if(mark<0 || mark>100)
			throw new InvaildMarkException("Your mark " + mark +" is invaild!");
		else
		{
		System.out.println("Mark: " + mark);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("*** Students' marks entry system ***");
		System.out.print("Enter mark: ");
		int stu_mark = sc.nextInt();
		try {
			checkMark(stu_mark);
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}

}
