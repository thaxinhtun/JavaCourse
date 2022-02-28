package Assignments.BankingSystem;


//Banking informations
import java.lang.StackWalker.Option;
import java.util.Scanner;

import javax.naming.InsufficientResourcesException;
class BankAccount{
	int accountNo;
	String holderName;
	String pinNo;
	String password;
	int balance;
	
	public BankAccount(int accNo,String name, String pin,String pw,int balance) {
		this.accountNo = accNo;
		this.holderName = name;
		this.pinNo = pin;
		this.password = pw;
		this.balance = balance;	
	}
	void deposit(int amount) {
		balance = balance + amount;
		System.out.println("Update Amount: "+balance);
	}
	void withdrawl(int amount) {
		try {
			System.out.println(balance);
			if(amount <= balance) {
				balance = balance - amount;
				System.out.println("Update Amount: "+balance);
			}
			else {
				throw new InsufficientResourcesException("Your amount is not insufficient!");
			}
		}catch (InsufficientResourcesException e) {
			System.err.println(e.getMessage());
		}
		
	}
	void changPassword(String pin_no) {
		Scanner sc = new Scanner(System.in);
		try {
			if(pin_no.equals(pinNo)) {
				System.out.print("Enter new Password: ");
				password = sc.next();
			}
			else {
				throw new Exception("Your Pin code is incorrect!");
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	void showInfo() {
		boolean status;
		do {
			status = true;
			System.out.println("For Detail Information, Enter your pin code: ");
			Scanner sc = new Scanner(System.in);
			String pin_code = sc.next();
			if(pin_code.equals(pinNo)) {
			System.out.println("Account Number: "+accountNo);
			System.out.println("User Name: "+ holderName);
			System.out.println("Current amount: "+ balance);
			System.out.println("Pin No: "+ pinNo);
			System.out.println("Password: "+password);
			}
			else {
				System.out.println("Your pin code is incorrect!");
				status = false;
			}
		}while( status != true);
		
	}
	void showOption() {
		System.out.println("Welcome "+ holderName);
		System.out.println("Your Account No :"+ accountNo +"\n");
		
		Scanner sc = new Scanner(System.in);
		int option = 0;
		System.out.println("Choose from menu");
		System.out.println("1. Deposit");
		System.out.println("2. Withdrawl");
		System.out.println("3. Change Password");
		System.out.println("4. Exit");
		
		do {
			System.out.println("********************");
			System.out.print("Enter an option: ");
			option = sc.nextInt();
			
			switch(option) {
			case 1:
				System.out.print("Enter an amount to deposit: ");
				int deposit_amount = sc.nextInt();
				deposit(deposit_amount);
				break;
			case 2:
				System.out.print("Enter an amount to withdrawl: ");
				int withdrawl_amount = sc.nextInt();
				withdrawl(withdrawl_amount);
				break;
			case 3:
				System.out.print("Enter Pin No: ");
				String pin = sc.next();
				changPassword(pin);
				break;
			default:
				System.out.println("Invaild option");
				break;
			}
		}while(option != 4);
		
		System.out.println("Thank for using");
	}
}
