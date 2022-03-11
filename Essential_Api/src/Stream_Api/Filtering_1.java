package Stream_Api;

import java.util.List;
import java.util.Map;

public class Filtering_1 {
	public static void main(String[] args) {
		List<Users> users = List.of(
				new Users("Kyaw Kyaw", "Admin"),
				new Users("Aung Aung", "Staff"),
				new Users("Maung Maung", "Staff"),
				new Users("Yuri", "Customer"),
				new Users("Jeon", "Customer")
				);
		users.stream()
			.filter(Users::isStaff)//user object
			.forEach(u-> System.out.println(u.getName() + "(" + u.getRole() +")"));
	}
}
class Users{
	private String name;
	private String role;
	public Users(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String roll) {
		this.role = role;
	}
	public boolean isStaff() {
		return this.role.equalsIgnoreCase("Staff");
	}
}
