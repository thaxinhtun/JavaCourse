package Stream_Api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mapping_1 {
	public static void main(String[] args) {
		List<Employee> empList = Arrays.asList(
				new Employee("Kyaw Kyaw",9800,"Yangon"),
				new Employee("Aung Aung",6000,"Mandalay"),
				new Employee("Mg Mg",10000,"Mandalay"),
				new Employee("Yuri",6000,"Yangon"),
				new Employee("Jeon",7800,"Monywa")
				);
		List<String> distinctCities = empList
				.stream()
				.map(e -> e.getCity()) // get only city name
				.distinct() // unique
				.collect(Collectors.toList());
				System.out.println(distinctCities);
				
				int[] salaries = empList
						.stream()
						.filter(e -> e.getSalary() > 6000)
						.mapToInt(e -> e.getSalary())
						.toArray();
						for(var s: salaries)
						 System.out.println(s);
						
				List<Integer> salaryList = empList
								.stream()
								.map(e -> e.getSalary())
								.filter(s -> s < 10000)
								.limit(3)
								.collect(Collectors.toList());
								System.out.println(salaryList);
								
								int maxSalary = empList
										.stream()
										.mapToInt(e -> e.getSalary())
										.max() // find max salary
										.getAsInt();
								int minSalary = empList
										.stream()
										.mapToInt(e -> e.getSalary())
										.min() // find min salary
										.getAsInt();
										System.out.println("Maximum salary is " + maxSalary);
										System.out.println("Minimum salary is " + minSalary);
	}
}
class Employee{
	private String name;
	private int salary;
	private String city;
	public Employee(String name, int salary, String city) {
		super();
		this.name = name;
		this.salary = salary;
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", city=" + city + "]";
	}
	
}