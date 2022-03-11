package Stream_Api;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Groupby_test {
	public static void main(String[] args) {
		List<Employee> empList = Arrays.asList(
				new Employee("Kyaw Kyaw",9800,"Yangon"),
				new Employee("Aung Aung",6000,"Mandalay"),
				new Employee("Mg Mg",10000,"Mandalay"),
				new Employee("Yuri",6000,"Yangon"),
				new Employee("Jeon",7800,"Monywa")
				);
		//count
		Map<String, Long> count = empList.stream()
									.collect(Collectors.groupingBy(e->e.getCity(),Collectors.counting()));
		System.out.println("Count by city: "+ count);
		//sum
		Map<String, Integer> sum = empList.stream()
										.collect(Collectors.groupingBy(e->e.getCity(),
												Collectors.summingInt(Employee::getSalary)));
			System.out.println(sum);
	
		//avg
			Map<String, Double> avg = empList.stream()
										.collect(Collectors.groupingBy(e->e.getCity(),
												Collectors.averagingDouble(Employee::getSalary)));
			System.out.println(avg);
			
			System.out.println("**********************");
			
			Map<Integer, List<Employee>> groupbySalary = empList.stream()
															.collect(Collectors.groupingBy(e->e.getSalary()));
			
			groupbySalary.forEach((k,v)->{
				System.out.println(k + "ks.");
				v.forEach(emp->System.out.println("\t"+emp.getName()+"("+emp.getCity()+")"));
			});
			
			//find emp name in each city
			
			System.out.println("******************");
			
			Map<String, List<String>> groupbycity = empList.stream()
														.collect(Collectors.groupingBy(e->e.getCity(),
																Collectors.mapping(Employee::getName, Collectors.toList())));
			System.out.println("Group by city");
			System.out.println(groupbycity);
			
			//find emplyoee who stay in same city
			
			Map<String, List<Employee>> data = 
					empList.stream()
					.collect(
							Collectors.collectingAndThen(
									Collectors.groupingBy(Employee::getCity), 
									tmp -> tmp.entrySet() //get Map<String,List<Emp>>
									.stream()
									.filter(v->v.getValue().size() >1)
										.collect(Collectors.toMap(v->v.getKey(), v->v.getValue()))));
		System.out.println(data);				
	}
}
