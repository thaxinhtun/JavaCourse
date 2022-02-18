package day3;

import java.util.Scanner;

public class SwitchExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter food: ");
		String name = sc.nextLine();
		//String category;
		/*
		 * var category = switch(name) { case "Burger","Pizza","Sandwich" ->
		 * "Fast Food"; case "Milktea","Yougurt" -> "Dessert"; case "MoatHinGar"->
		 * "Burmese Food"; case "Sushi" -> "Japanese food"; default -> "Unknown";
		 * 
		 * };
		 */
		var category = switch(name) {
		case "Burger","Pizza","Sandwich" ->{
			if(name.equals("Pizza"))
				System.out.println(name + " is "+ "Italian Food");
			yield  "Fast Food";
		}
		case "Milktea","Yougurt" -> {
			yield "Dessert";
		}
		case "MoatHinGar"-> "Burmese Food";
		case "Sushi" -> "Japanese food";
		default -> "Unknown";
			
	};
	System.out.println(name + " is "+ category);
	sc.close();
	}
}
