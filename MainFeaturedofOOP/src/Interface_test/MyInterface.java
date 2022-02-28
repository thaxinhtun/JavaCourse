package Interface_test;

public interface MyInterface {
	void method1();
	default void method2() {
		System.out.println("This is default method");
	}
	static void method3() {
		System.out.println("Static mrthod");
	}
}
class MyClass implements MyInterface{

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("This is abstract mrthod");
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		MyInterface.super.method2();
	}
	
}