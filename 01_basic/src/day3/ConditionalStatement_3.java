package day3;

import java.util.Scanner;

public class ConditionalStatement_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter food: ");
		String name = sc.nextLine();
		String category;
		switch(name) {
		/*case "Burger":
			category ="Fast Food";break;
		case "Pizza":
			category ="Fast Food";break;
		case "Milktea":
			category ="Dessert";break;
		case "MoatHinGar":
			category ="Burmese Food";break;
		case "Sushi":
			category ="Japanese Food";break;
		case "Yougurt":
			category ="Dessert";break;
		default:
			category="Unknown";
		}*/
		case "Burger","Pizza","Sandwich":
			category ="Fast Food";break;
		case "Milktea","Yougurt":
			category ="Dessert";break;
		case "MoatHinGar":
			category ="Burmese Food";break;
		case "Sushi":
			category ="Japanese Food";break;
		default:
			category="Unknown";
		}
			System.out.println(name + " is "+ category);
			sc.close();
		}
		
	
}
