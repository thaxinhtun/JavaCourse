package day7;

class InvaildAgeException extends Exception {
	public InvaildAgeException() {
		
	}
	public InvaildAgeException(String msg) {
		super(msg);
	}

}
public class UserdefinedExceptionDemo{
	
	static void checkAge(int age) throws InvaildAgeException{
		if(age<18)
			throw new InvaildAgeException(age +"is not vaild to smoke");
		else
		{
		System.out.println("You can.");
		}
	}
		
	public static void main(String[] args) {
		try {
			checkAge(12);
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
		
	}
}