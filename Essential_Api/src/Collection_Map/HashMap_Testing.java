package Collection_Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMap_Testing {
	public static void main(String[] args) {
		Map<String, String> foods = new HashMap<>();
		foods.put("Orange", "Fruit");
		foods.put("Grape", "Fruit");
		System.out.println(foods);
		
		Map<String, String> another1 = Map.of("Mango","Food","Potato","Vegetable");
		foods.putAll(another1);
		System.out.println("After add all: "+ foods);
		
		Map<String, String> another2 = Map.ofEntries(Map.entry("Coffee", "Juice"),
											Map.entry("LemonTea","Juice"));
		foods.putAll(another2);
		foods.forEach((k,v) -> System.out.println(k+"->"+v));
		foods.putIfAbsent("Kiwi", "Fruit");
		System.out.println(foods);
		
		System.out.println("Contain Coffee(key): "+ foods.containsKey("Coffee"));
		System.out.println("Contain Coffee123(key): "+ foods.containsKey("Coffee123"));
		System.out.println("Contain Snack(value): "+ foods.containsValue("Snack"));
		System.out.println("Contain Fruit(value): "+ foods.containsValue("Fruit"));
		
		Set<String> keys = foods.keySet();
		System.out.println(keys);
		
		Collection<String> values = foods.values();
		System.out.println(values);
		
		foods.remove("Grape");
		System.out.println("After remove: "+foods);
		
		foods.keySet().removeIf(k->k.contains("Tea"));
		System.out.println("After remove contain tea: "+foods);
		
		foods.values().removeIf(d->d.equalsIgnoreCase("Fruit"));
		System.out.println("After remove fruit: "+foods);
		
		foods.replace("Mango", "Pineapple");
		System.out.println("After replace: "+foods.get("Mango"));
		
		foods.compute("Coffee", (k,v)-> v.toUpperCase()); // update if already key exist
		System.out.println("After update: " + foods.get("Coffee"));
		
		foods.compute("Cake", (k,v) -> "Snack"); // put new if not exist key
		System.out.println("After update: " + foods);
		
		foods.computeIfAbsent("Coffee", k -> "Fruit"); // no effect if already key exist
		System.out.println("After update: " + foods.get("Coffee"));
		
		foods.computeIfAbsent("Banana", k -> "Fruit"); // put new if not exist key
		System.out.println("After update: " + foods);
		
		foods.computeIfPresent("Coffee", (k,v) -> "Snack"); // update if key already exist
		System.out.println("After update: " + foods.get("Coffee"));
		
		foods.computeIfPresent("Corn", (k,v) -> "Vegetable"); // no effect if not exist key
		System.out.println("After update: " + foods.get("Corn"));
		
		System.out.println(foods);
	}
}
