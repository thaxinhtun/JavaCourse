package Collections_Assignment;

public class Student implements Comparable<Student>{
	private int rollNo;
	private String name;
	
	public Student(int rollNo, String name) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "Student[ roll = " + this.rollNo + " , name = " + this.name +"]";
	}
	public String search(Student s){
		if(s.getRollNo() == this.rollNo) {
			return "Roll no " +this.rollNo +" is "+ this.name;
		}
		else return "Roll no is not exist.";
		
		
	}
	@Override
	public int compareTo(Student s) {
		// TODO Auto-generated method stub
		return Integer.compare(s.rollNo, this.rollNo);
	}
	
}
