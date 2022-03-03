package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sorting_Searching_ArrayLIst {
	public static void main(String[] args) {
		String[] data = {"Aung Aung","Jeon","Yuki","Maung Maung"};
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(data));
		list.add("Jeon");
		System.out.println(list);
		Collections.sort(list);
		System.out.println("After Sort: "+list);
		Collections.reverse(list);
		System.out.println("Ascending Sort/ Reverse: "+ list);
		
		//Search
		int result = Collections.binarySearch(list, "Jeon");
		System.out.println((result<0)? "Jeon is not found": "Jeon is found");
		
		result =Collections.binarySearch(list, "May");
		System.out.println((result<0)? "May is not found": "May is found");
		
		if(list.contains("Yuki"))
			System.out.println("Yuki is found");
		
		list.remove("Jeon");
		System.out.println("After remove: "+list);
		
		list.removeIf(s->(s.endsWith("ung") && s.length()>9));
		System.out.println("RemoveIf: "+list);
	}
}
