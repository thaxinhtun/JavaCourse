package Collection_sets;

import java.util.HashSet;
import java.util.Set;

public class Set_Testing {
	public static void main(String[] args) {
		HashSet<String> set1 = new HashSet<>();
		
		set1.add("Orange");
		set1.add("Apple");
		set1.add(null);
		set1.add("Mango");
		System.out.println(set1);
		set1.remove(null);
		set1.forEach(s-> System.out.println(s));
		
		Set<String> set2 = Set.of("Potato","Pineapple");
		set1.addAll(set2);
		System.out.println("After add all");
		System.out.println(set1);
	}
}
