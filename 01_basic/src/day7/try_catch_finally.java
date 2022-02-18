package day7;

public class try_catch_finally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String name= null;
			System.out.println("Length: "+name.length());
		}
		catch(NullPointerException e){
			System.err.println("It does not allocated");
		}
		finally {
			System.out.println("Finnaly block");
		}
		System.out.println("Out side try-catch-finally block");
	}

}
