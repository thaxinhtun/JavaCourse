package Assignments.BankingSystem;

//Demostration for Bank info
public class Demo_Bank {
	public static void main(String[] args) {
		BankAccount person1 = new BankAccount(12345678, "Cherry", "09876", "123456", 100000);
		person1.showOption();
		person1.showInfo();
	}
}
