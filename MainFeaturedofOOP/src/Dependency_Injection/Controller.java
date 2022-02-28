package Dependency_Injection;

public class Controller {
	
	private Area area;
	
	public Controller(Area area) {
		this.area = area;
	}
	
	void Display(int input) {
		
		System.out.println(area.CalArea(input));
	}
}
