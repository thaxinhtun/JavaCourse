package day7;

public class Exception_Propagation {

	static void test1() {
		System.out.println(100/0);
	}
	static void test2() {
		test1();
	}
	static void test3() {
		test2();
	}
	static void test4() {
		test3();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test3();
	}

}
