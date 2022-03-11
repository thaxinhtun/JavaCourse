package Stream_Api;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Collecting_1 {
	public static void main(String[] args) {
		Student[] studs = {
				new Student(10,"cherry","yangon"),
				new Student(2,"cherry","mandalay"),
				new Student(5,"khaing","monywa"),
				new Student(1,"htet","mandalay"),
				new Student(11,"htet yadana","yangon")
		};
		Set<String> hashSet = Arrays.stream(studs)
								.map(Student::getName)
								.collect(Collectors.toSet());
		System.out.println("HashSet: "+ hashSet);
		
		TreeSet<String> treeSet = Arrays.stream(studs)
									.map(Student::getName)
									.collect(Collectors.toCollection(TreeSet::new));
		System.out.println("TreeSet: "+treeSet);
		
		Map<Integer, String> hashmap1 = Arrays.stream(studs)
											.collect(Collectors.toMap(Student::getRollNo, Student::getName));
		System.out.println("HashMap1: "+ hashmap1);
		
		Map<Integer, Student> hashmap2 = Arrays.stream(studs)
											.filter(s -> !s.getCity().equals("Yangon"))
											.collect(Collectors.toMap(s->s.getRollNo(), 
													s->s));
		System.out.println("HashMap2: "+hashmap2);
	}
}
class Student{
	private int rollNo;
	private String name;
	private String city;
	public Student(int rollNo, String name, String city) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.city = city;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", city=" + city + "]";
	}
	
}
