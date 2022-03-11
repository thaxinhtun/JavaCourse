package Stream_Api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMap_1 {
	public static void main(String[] args) {
		List<String> drinks = Arrays.asList("Cola","Milktea","Pessi");
		List<String> foods = List.of("Burger","Kyay oo","Noodle","Cake");
		List<String> desserts = List.of("IceCream","Cake");
		
		List<List<String>> items = new ArrayList<>();
		
		items.add(desserts);
		items.add(foods);
		items.add(drinks);
		
		System.out.println("Before flat: "+ items);
		
		Set<String> set = items.stream()
				.flatMap(v -> v.stream())
				.collect(Collectors.toSet());
		System.out.println("After flat: "+ set);;
				
	}
}
