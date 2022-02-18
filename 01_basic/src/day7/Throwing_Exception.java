package day7;

public class Throwing_Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int[] numbers = {100,200,300};
			int index = 5;
			if(index > numbers.length) 
				throw new ArrayIndexOutOfBoundsException("Out of range");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
	}

}
