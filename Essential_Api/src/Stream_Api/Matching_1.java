package Stream_Api;

import java.util.List;

public class Matching_1 {
	public static void main(String[] args) {
		List<Integer> numbers =List.of(2,4,6,8,11);
		
		boolean allEven = numbers.stream().allMatch(i -> i%2 == 0);
		System.out.println("All Even: "+ allEven);
		
		System.out.println("Even: "+ numbers.stream().anyMatch(i ->i%2==0));
		
		System.out.println("NoneEven: "+ numbers.stream().noneMatch(i ->i%2 ==0));
	}
}
