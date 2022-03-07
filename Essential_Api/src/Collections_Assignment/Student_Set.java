package Collections_Assignment;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.naming.directory.SearchControls;

public class Student_Set {
	public static void main(String[] args) {
		
		HashSet<Student> stud = new HashSet<Student>();
		
		//insert new Students
		stud.add(new Student(1, "Nwe Ni"));
		stud.add(new Student(2, "May Thu"));
		stud.add(new Student(3, "Poe"));
		stud.add(new Student(4, "Naing Lin"));
		
		//sorted and display 
		TreeSet<Student> sorted = new TreeSet<>(stud);
		Set<Student> dsorted = sorted.descendingSet();
		dsorted.forEach(s -> System.out.println(s));
		
		//update
		stud.add(new Student(5, "Naung Naung"));
		dsorted.addAll(stud);
		System.out.println("\n*** After update ****");
		System.out.println(dsorted);
		
		//search roll 2
		int search_roll = 2;
		
		stud.forEach(s->{
			if(s.getRollNo() == search_roll) {
				System.out.println(s.getRollNo() + " is "+s.getName());
			}
		});
		
		//delete roll 4
		stud.remove(4);
		dsorted.addAll(stud);
		System.out.println("\n*** After remove **** ");
		System.out.println(dsorted);
	}
}
