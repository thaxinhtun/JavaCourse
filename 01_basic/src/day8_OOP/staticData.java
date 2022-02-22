package day8_OOP;

public class staticData {

	public static void main(String[] args) {
		Emplyoee.noOfEmplyoee = 50;//accessing static variable
		Emplyoee emp1 = new Emplyoee();
		Emplyoee emp2 = new Emplyoee();
		
		System.out.println("emp1's no of emplyoee: "+emp1.noOfEmplyoee);
		System.out.println("emp2's no of emplyoee: "+emp2.noOfEmplyoee);
		
		emp1.noOfEmplyoee = 30;//changing via obj(but not recommend)
		
		System.out.println("----After changing class variables-----");
		System.out.println("empl's no of employee: "+emp1.noOfEmplyoee);
		System.out.println("emp2's no of emplyoee: "+emp2.noOfEmplyoee);
		
	}

	}
class Emplyoee{

	static int noOfEmplyoee;
}