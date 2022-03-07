package Collection_Map;

import java.util.HashMap;
import java.util.Map;

public class Map_Userdefined {
	public static void main(String[] args) {
		Map<Integer, Employee> employee = new HashMap<>();
		
		employee.put(1001, new Employee(1001,"Nyi Nyi","Yangon"));
		employee.put(1002, new Employee(1002,"Htet Htet","Pyin OO Lwin"));
		employee.put(1003, new Employee(1003,"Naung Naung","Yangon"));
		employee.put(1004, new Employee(1004,"Aung Aung","Mandalay"));
		
		employee.forEach((k,emp)->{
			System.out.println(emp.getId()+" "+emp.getName()+ " "+emp.getCity());
		});
		
		Employee e = employee.get(1004);
		if(e!=null) {
			System.out.println(e.getId());
			System.out.println(e.getName());
			System.out.println(e.getCity());
			
		}
		else
			System.out.println("Emplyoee id is does not exist!");
		
		employee.forEach((k,v)->{
			if(v.getCity().equalsIgnoreCase("yangon"))
			System.out.println(v.getName());
			});
	}
}
