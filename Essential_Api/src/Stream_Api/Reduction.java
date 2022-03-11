package Stream_Api;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Reduction {
	public static void main(String[] args) {
		List<Employee> empList = Arrays.asList(
				new Employee("Kyaw Kyaw",9800,"Yangon"),
				new Employee("Aung Aung",6000,"Mandalay"),
				new Employee("Mg Mg",10000,"Mandalay"),
				new Employee("Yuri",6000,"Yangon"),
				new Employee("Jeon",7800,"Monywa")
				);
		
		int total = empList.stream().mapToInt(Employee::getSalary).sum();
		double avg = empList.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
		int maxSalary = empList.stream().mapToInt(Employee::getSalary).max().getAsInt();
		
		System.out.println("Total Salary:" + total);
		System.out.println("Avg Salary: "+avg);
		System.out.println("Max Salary: "+maxSalary);
		
		Employee empMax = empList.stream().max(Comparator.comparingInt(e -> e.getSalary())).get();
		System.out.println("Employee with highest Salary: "+ empMax);
		
		Employee empMin = empList.stream().min((e1,e2)->e1.getSalary()-e2.getSalary()).get();
		System.out.println("Employee with lowest Salary: "+ empMin);
		
		//custom reduce
		System.out.println("\n*********");
		int totalsalary = empList.stream()
							.map(Employee::getSalary)
							.reduce(0, (s1,s2) -> s1+s2);
		System.out.println("Total Salary: "+totalsalary);
		
		int MinSalary = empList.stream()
							.mapToInt(e->e.getSalary())
							.reduce(Integer::min)
							.getAsInt();
		System.out.println("Min salary: "+ MinSalary);
		
		Employee empMaxSal = empList.stream()
					.reduce((e1,e2) -> e1.getSalary()<e2.getSalary()? e2:e1)
					.get();
		System.out.println("Max Salary: "+ empMaxSal);
	}
}
