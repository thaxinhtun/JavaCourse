package Assignments;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateTime_FoodOrder_Assignment_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] menus = {"Pizza", "Burger", "Milk Tea", "Spicy Noodle"};
		String[] townships = {"AA","BB","CC","DD"};
		int[] times = {15,30,10,45};
		
		int choose_menu_itemNo; int choose_township; int choose_order_type;
		LocalTime arrive_time; LocalDate arrive_date; int cus_order_date;int date = 0;

		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMM dd yyyy");
		DateTimeFormatter timeFormat = dateFormat.ofPattern("hh:m:s");
		
		int n = 0;
		boolean status;
		
		// menus section
		do {
			status = true;
			System.out.println("***** Available Menus *****\n");
			for(String menu:menus) {
				System.out.println( ++n +"\s"+ menu);
			}
			System.out.print("Please choose item: ");
			choose_menu_itemNo = sc.nextInt();
			if(choose_menu_itemNo < 1 || choose_menu_itemNo > 4) {
				status = false;
				n = 0;
				System.out.println("Choose only the items from menu");
			}
		}while(status == false) ;
		
		//township section
		do {
			status = true;
			System.out.println("\n****** Deliverable Township ******\n");
			n =0;
			int i =0;
			for(String township:townships) {
				System.out.println(++n +"\s"+ township +"("+ times[i]+" mins)");
				i++;
			}
			System.out.print("Please choose township: ");
			choose_township = sc.nextInt();
			if(choose_township < 1 || choose_township > 4) {
				status = false;
				n = 0;
				System.out.println("Choose only the deliverable township");
			}
			}while(status == false);
		
		
			//oreder types section
			do {
				status = true;
				System.out.println("\n***** Order Type******\n");
				System.out.println("1.Order Now \n2.Preorder");
				System.out.print("Choose 1 or 2: ");
			 choose_order_type = sc.nextInt();
				if(choose_order_type < 1 || choose_order_type > 2) {
					status = false;
					n = 0;
					System.out.println("Choose only from two order types");
				}
			}while(status == false);
			
			//info section if order type is 1.(order now)
			if(choose_order_type == 1) {
				System.out.println("\n***** Your order Information *****");
				
				System.out.println("Item Name: " + menus[choose_menu_itemNo-1]);
				System.out.println("Your address: " + townships[choose_township-1]);
				System.out.println("Duration : " + times[choose_township-1] +" mins");
				
				LocalTime now = LocalTime.now();
				arrive_time = now.plusMinutes(times[choose_township-1]);
				
				if(arrive_time.getHour() > 12){
					System.out.println("Arrival Time: "+arrive_time.format(timeFormat) + " PM");
				}
				else {
					System.out.println("Arrival Time: "+arrive_time.format(timeFormat) + " AM");
				}
					
		    //info section if order type is 2.(pre order)	
			}else {
				System.out.print("Enter deliver date(dd): ");
				cus_order_date = sc.nextInt();
				LocalDate now = LocalDate.now();
				
				if(cus_order_date  > now.getDayOfMonth()) {
					date = cus_order_date - now.getDayOfMonth();
					arrive_date = now.plusDays(date);
					System.out.println("Arrival Date: " + arrive_date.getDayOfWeek()+ "\s"+ arrive_date.format(dateFormat) );
					
				}
				
				else {
					date = cus_order_date - now.getDayOfMonth();
					LocalDate date1 = now.plusDays(date);
					arrive_date = date1.plusMonths(1);
					System.out.println("Arrival Date: "+ arrive_date.getDayOfWeek()+ "\s"+ arrive_date.format(dateFormat));

				}
			}
			
		
		}

	}


