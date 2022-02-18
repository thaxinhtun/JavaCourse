package Assignments;

import java.util.Scanner;

public class Assignment_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double sleephrs = 0;
	
		String con="exit";
		do
		{
			System.out.print("Do you sleep before 12am?(y/n)");
			String test = sc.next();
			if(test.equals("y")) {
				System.out.print("When do you go bed(pm): ");
				double gobed = sc.nextDouble();
				System.out.print("When do you get up(am): ");
				double getup = sc.nextDouble();
				sleephrs = (getup+12)-gobed;
			}
			else {
				System.out.print("When do you go bed(am): ");
				double gobed = sc.nextDouble();
				System.out.print("When do you get up(am): ");
				double getup = sc.nextDouble();
				sleephrs = (getup+12)-(gobed+12);
			}
			System.out.println("Your sleep hours: "+sleephrs);
			if(sleephrs>=5 && sleephrs<=8) {
				System.out.println("You take care your health well");
			}
			else if(sleephrs<5) {
				System.out.println("You're very hardworking");
			}
			else if(sleephrs>8) {
				System.out.println("You're abnormal");
			}
			System.out.print("do u want to continue(y/n): ");
			con = sc.next();
		}while(con.equals("y"));
}
}
