package StreamApi_assignment;

public class Salespeople {
	private String name;
	private String city;
	private double comm;
	public Salespeople(String name, String city, double comm) {
		super();
		this.name = name;
		this.city = city;
		this.comm = comm;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	@Override
	public String toString() {
		return "Salespeople [name=" + name + ", city=" + city + ", comm=" + comm + "]";
	}
	
	
}
