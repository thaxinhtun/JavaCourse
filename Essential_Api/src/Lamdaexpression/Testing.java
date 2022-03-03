package Lamdaexpression;

public class Testing {
	public static void main(String[] args) {
		MyInterface1 obj =(str)-> System.out.println(str);
		obj.display("Aung Ayng");
		
		MyInterface3 obj3 = (email,pw)-> {
			if(email.equals("tzh@gmail.com") && pw.equals("123") )
				return true;
			else
				return false;
		};
		System.out.println(obj3.checkLogin("admin@gamil.com", "123")? "Login success":"Invaild Login");
		
		MyInterface2 sum = (n1,n2) -> n1+n2;
		MyInterface2 sub = (n1,n2)-> n1-n2;
		System.out.println(sum.operate(100, 200));
		System.out.println(sub.operate(20, 5));
	}
}
	
		// TODO Auto-generated method stub
		//MyClass obj = new MyClass();
		//obj.display("Aung Aung");
//		MyInterface1 obj = new MyInterface1() {
//			@Override
//			public void display(String input) {
//				// TODO Auto-generated method stub
//				System.out.println(input);
//			}
//		};
//		obj.display("Aung Aung");
		
		
//class MyClass implements MyInterface1{
//
//	@Override
//	public void display(String input) {
//		// TODO Auto-generated method stub
//		System.out.println(input);
//	}
//	
//}