package Stream_Api;

import java.util.Arrays;
import java.util.stream.IntStream;

public class testing1 {
	public static void main(String[] args) {
		int[] prices = {1700,3500,3800,2200,5000,13500,500,1500,1000};
		
		IntStream streams = Arrays.stream(prices);
		streams.filter(p -> p > 1500) // intermediate operation
		 .sorted()
		 .forEach(p -> System.out.println(p)); // terminal operation
			
	}
}
