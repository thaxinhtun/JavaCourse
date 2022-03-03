package Collection;

import java.util.Stack;

public class Stack_Test {
	public static void main(String[] args) {
		Stack<String> cities =new Stack<>();
		//push
		cities.push("yangon");
		cities.push("Mandalay");
		cities.push("Pyin_OO_Lwin");
		System.out.println(cities);
		cities.pop();
		System.out.println("After Pop: "+cities);
	}
}
