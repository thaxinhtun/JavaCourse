package day8_OOP;

public class BlockTest {

	static final int MIN_LENGTH;
	String phone;
	
	{
		System.out.println("This is instance block statement");
		phone = "Invaild number";
	}
	
	static {
		System.out.println("This is static block");
		//phone ="test"; only static data can be used
		MIN_LENGTH =9;
	}
	
	public BlockTest(String phone) {
		System.out.println("This is constructor block");
		if(phone.length()>=MIN_LENGTH) {
			this.phone = phone;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockTest test = new BlockTest("091234569");
		
		System.out.println("Phone :" + test.phone);
		System.out.println("*******************");
		BlockTest test1 = new BlockTest("123");
	}

}
