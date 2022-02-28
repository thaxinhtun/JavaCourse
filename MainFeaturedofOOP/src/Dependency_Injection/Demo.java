package Dependency_Injection;

public class Demo {
	public static void main(String[] args) {
		Circle circle = new Circle();
		Controller control = new Controller(circle);
		control.Display(100);
		
		control = new Controller(new Square());
		control.Display(100);
	}
}
