package Collection_Map;

import java.util.LinkedHashMap;

public class LinkedHashMap_Test {
	public static void main(String[] args) {
		LinkedHashMap<Integer, String> students = new LinkedHashMap<>();
		
		students.put(11,"Aung Aung");
		students.put(5, "Kyaw Kyaw");
		students.put(8, "Honey");
		
		students.putIfAbsent(10, "Cherry");
		
		students.forEach((k,v)->{
		System.out.println("Rno: " +k);
		System.out.println("Name: " + v);
		});
		
		students.replace(8, "Honey Htun");
		System.out.println("After replace: " + students);
		students.remove(11);
		System.out.println("After remove: " + students);
	}
	
}
