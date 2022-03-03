package Collection;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayList_Testing {
	public static void main(String[] args) {
		//create array list
		ArrayList<Integer> list =new ArrayList<>();
		
		//add
		list.add(10);
		list.add(30);
		list.add(50);
		System.out.println(list.size());
		
		//get
		list.add(1,100);
		list.forEach(i -> System.out.println(i));
		System.out.println(list);
		
		//update
		list.set(0, 500);
		System.out.println(list.get(0));
		
		//remove
		list.remove(1);
		System.out.println(list.size());
		System.out.println(list);
		
		//max
		System.out.println("Max: "+Collections.max(list));
		System.out.println("Min: "+Collections.min(list));
		
		list.clear();
		System.out.println(list.size());
		System.out.println(list);
	}
	
}
