package day7;

public class Throws_Exception {
	static void checkMark(int mark) throws ArithmeticException{

		if(mark<0 || mark>100) {
			ArithmeticException ex = new ArithmeticException("Invails mark!");
			throw ex;
		}
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			checkMark(-1);
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
