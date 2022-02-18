package day4;

public class Array2Dimention {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = {"John","Yuri","Cherry"};
		int[][] marks = {
				{65,73,86,84,59},
				{71,80,90,69,95},
				{75,75,99,96,99}
		};
		int row = marks.length;
		int col = marks[0].length;
		
		for(var r =0; r< row;r++) {
			var total =0;
			for(var c =0; c<col ; c++) {
				total = total +marks[r][c];
				
			}
			System.out.println("Total obtained by stu"+names[r]+": "+total);
			System.out.println("Average marks: "+ (float)total/5);
		}
	}

}
