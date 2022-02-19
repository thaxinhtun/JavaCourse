package Assignments;

import java.util.Arrays;
import java.util.Scanner;

public class Array_Assignment_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// TODO Auto-generated method stub
		String[] cores = {"core i3","core i5","core i7","core i9"};
		String[] brands = {"acer", "asus", "dell", "hp", "lenovo", "samsung"};
		double[][] dollars = {{693.33, 691.99, 340.44, 400.21, 230.21, 294.2},
				{159.483, 1591.577, 783.012, 920.483, 529.483, 676.66},
				{1663.992, 1660.776, 817.056, 960.504, 552.504, 706.06},
				{2079.99, 2075.97, 1021.32, 1200.63, 690.63, 882.6}};
		boolean status;
		String core; String brand;
		int core_index;
		int brand_index;
		
		do {
			status = true;
			System.out.print("Enter computer specification: ");
		    core = sc.nextLine();
			core_index = Arrays.binarySearch(cores, core);
			if(core_index < 0) {
				System.out.println("\n*** Choose only these specification ***\n core i3,core i5,core i7,core i9\n");
				status = false;
			}
		}while(status == false);
	    
		do {
			status = true;
			System.out.print("Enter computer brand: ");
		    brand = sc.nextLine();
			brand_index = Arrays.binarySearch(brands, brand);
	
			if(brand_index < 0) {
				System.out.println("\n*** Choose only these brands ***\n lenovo, hp, samsung, acer, dell, asus\n");
				status = false;
			}
		}while(status == false);
		
		System.out.println("\n*** Your Information ***");
		System.out.println("Specification: "+ cores[core_index]);
		System.out.println("Brand: "+ brands[brand_index]);
		System.out.println("Price (Dollar): " + dollars[core_index][brand_index]+" $");
		System.out.print("\nEnter Exchange Rate for mmk: ");
		double ex_rate = sc.nextDouble();
		System.out.println("Price: "+ (dollars[core_index][brand_index])*(ex_rate)+" MMK" );
	}
}
