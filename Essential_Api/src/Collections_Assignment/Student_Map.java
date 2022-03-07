package Collections_Assignment;

import java.util.Map;
import java.util.TreeMap;

import Collection_Map.Employee;

public class Student_Map {
	public static void main(String[] args) {
		//insert new Stuents
		Map<Integer, Student> stud = new TreeMap<>();
		
		stud.put(3, new Student(3, "Shoon"));
		stud.put(1, new Student(1, "Kyaw Kyaw"));
		stud.put(2, new Student(2, "Poe"));
		stud.put(4, new Student(4, "Nay lin"));
		
		//sort with key and display all stud
		stud.forEach((k,s)->System.out.println(s.getRollNo()+".\s"+s.getName()));
		
		//update student data
		stud.replace(2, new Student(2, "Aung Aung"));
		System.out.println("\n*** After update ***");
		stud.forEach((k,s)->System.out.println(s.getRollNo()+".\s"+s.getName()));
		
		//search roll3
		Student s = stud.get(3);
		if(s!=null) {
			System.out.println(s.getName());
			
			
		}
		else
			System.out.println("Emplyoee id is does not exist!");
		
		//delete roll2
		stud.remove(2);
		System.out.println("\nAfter remove rollno 2: ");
		stud.forEach((k,stu)->System.out.println(stu.getRollNo()+".\s"+stu.getName()));
	}
}
