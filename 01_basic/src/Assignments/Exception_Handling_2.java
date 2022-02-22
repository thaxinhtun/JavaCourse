package Assignments;

import java.util.Scanner;

public class Exception_Handling_2 {

	public static void main(String[] args) {
		boolean status = true;
		do {
			status = true;
		try {
			String[] states = {"AA","BB","CC","DD","EE","FF","GG","HH","II","JJ","KK","MM","NN","LL"};
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter NRC no: ");
			String nrc = sc.nextLine();
			
			int index_number = nrc.indexOf(")");
			
			int index_township = nrc.indexOf("/");
//			System.out.println(index_township);
			int index_township1 = nrc.indexOf("(");
			
			int state = Integer.parseInt(nrc.substring(0,index_township)) ;
			String number = nrc.substring(index_number+1);
			
			if(state > states.length) {
				throw new ArrayIndexOutOfBoundsException("Your NRC is invaild!");
			}
			if(number.length()> 6) {
				System.out.println("\nPlease enter again! Your NRC number should be only 6 digits!\n");
				status = false;
			}
			else {
				System.out.println("State: "+ states[state-1]);
				System.out.println("Township: "+ nrc.substring(index_township +1, index_township1));
				System.out.println("Number: " + number);
			}
			
			
		    } catch (ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
			System.out.println("Try Again\n");
			status = false;
		}
		}while(status == false);
		
	}

}
