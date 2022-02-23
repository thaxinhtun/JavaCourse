package day8_OOP;

public class AccessModifier {

}

class A{
	private int a;
	
	void test() {
		//private int b;
		a = 100;
	}
}
class B{
	void test() {
		A obj = new A();
	}
}