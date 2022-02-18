package day4;

public class Jagged_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] data = {
				{1,2,3}, //row1
				{1,2,3,4}, //row2
				{1,2} //row3
		};
		
		System.out.println("With For Loop");
		for(var r = 0; r < data.length; r++) {
			for(var c = 0; c < data[r].length; c++) {
				System.out.print(data[r][c] + "\t");
		System.out.println();
			}
	
			}
		System.out.println("With For each loop");
		for(int[] row: data) {
			for(int col:row) {
				System.out.print(col+"\t");
			System.out.println();
		}
		}
	}

}
