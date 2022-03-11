package Stream_Api;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Filtering_2 {
	public static void main(String[] args) {
		List<Users> users = List.of(
				new Users("Kyaw Kyaw", "Admin"),
				new Users("Aung Aung", "Staff"),
				new Users("Maung Maung", "Staff"),
				new Users("Yuri", "Customer"),
				new Users("Jeon", "Customer")
				);
		List<String> names = users.stream()
			.filter(u -> u.getName().contains("Aung") && u.getRole().equals("Staff"))
			.map(u -> u.getName())//convert user obj to String
			.collect(Collectors.toList());
		System.out.println(names);
	}
}
