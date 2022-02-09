package day2;

public class testing_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 =100;
		int num2 = 200;
		
		System.out.println(num1 + " + " + num2 +" = "+(num1+num2));
		
		System.out.println(num1 + " == " + num2 +" is "+(num1==num2));
		
		System.out.println((80%5 == 0) && (80%4 == 0));
		
		String result = (14%2 == 1)? "Odd":"Even";
		System.out.println(result);
		
		num1 +=400;
		System.out.println("num1 =" + num1);
		
		testing_5.static_method();
		testing_5 obj = new testing_5();
		obj.instance_method();
	}

}
