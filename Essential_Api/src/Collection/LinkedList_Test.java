package Collection;

import java.util.LinkedList;

public class LinkedList_Test {
	public static void main(String[] args) {
		LinkedList<String> lList = new LinkedList<>();
		lList.add("NIla");
		lList.add(0,"Aung Aung");
		lList.add("Kyaw");
		System.out.println(lList);
		
		lList.addFirst("Jeon");
		lList.addLast("Cherry");
		System.out.println(lList);
		System.out.println(lList.get(2));
		System.out.println(lList.getLast());
	}
}
