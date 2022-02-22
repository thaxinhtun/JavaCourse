package day8_OOP;


class AppException extends Exception{
	public AppException(String msg) {
		super(msg);
	}
}

class Emplyoee_1{
	static int noOfemployee = 3;
	static int nextId = 1;
	final int empId;
	String name;
	int salary;
	
	public Emplyoee_1() throws AppException{
		if(nextId > noOfemployee)
			throw new AppException("Sorry!Limited number had been reached");
		empId = nextId;
		nextId++;
	}
	public void initializeData(String name,int salary) {
		this.name = name;
		this.salary = salary;
	}
	public void changeData(String editName,int editSalary) {
		if(!name.equalsIgnoreCase(editName)) {
			name = editName;
		}
		if(salary != editSalary) {
			salary = editSalary;
		}
	}
	public void showData() {
		System.out.println(this.empId+"\t"+this.name+"\t"+this.salary);
	}
}

public class Instance_Variable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Emplyoee_1 emp1 = new Emplyoee_1();
			emp1.initializeData("Jhon", 90000000);
			Emplyoee_1 emp2 = new Emplyoee_1();
			emp2.initializeData("Honey", 10000000);
			Emplyoee_1 emp3 = new Emplyoee_1();
			emp3.initializeData("Yuki", 8000000);
			
			System.out.println("****************");
			emp1.showData();
			emp2.showData();
			emp3.showData();
			
			emp1.changeData("Jhon", 12000000);
			System.out.println("***After changing employee 1 ***");
			emp1.showData();
			
			Emplyoee_1 emp4 = new Emplyoee_1();
			emp4.initializeData("Kyaw Kyaw", 4000000);
		} catch (AppException e) {
			System.err.println(e.getMessage());
		}
		
	}

}