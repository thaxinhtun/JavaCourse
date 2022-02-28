package Polymorphism;

public class Demo_Dev {
	public static void main(String[] args) {
		//runtime Polymorphism
		Developer dev;
		dev = new Frontend_Developer();
		dev.work();
		dev = new Backend_devloper();
		dev.work();
	}
}
