package day8_OOP.package2;

import day8_OOP.package1.A;

public class D {
	void test() {
		A obj = new A();
		//System.out.println(obj.price);
		//System.out.println(obj.number);

	}
class F extends A{
	void test() {
		A obj = new A();
		//obj.number;
		//obj.price;
		F obj1 = new F();
		obj1.price = 700;
	}
}
}
