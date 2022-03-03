package Collection;

import java.util.ArrayList;
import java.util.List;

class Phone{
	 String brand;
	 int price;
	public Phone(String brand, int price) {
		super();
		this.brand = brand;
		this.price = price;
	}
	 
	 
}
public class ArrayList_UserDefined {
	public static void main(String[] args) {
		List<Phone> list = new ArrayList<>();
		
		list.add(new Phone("Iphone",1300000));
		list.add(new Phone("Samsung", 1000000));
		list.add(new Phone("Vivo", 900000));
		
		Phone ph = new Phone("Oppo",500000);
		list.add(ph);
		
		list.forEach(phone -> System.out.println("name: "+ phone.brand + " Price: "+phone.price));
		System.out.println("**************");
		list.forEach(phone ->{
			if(phone.price>500000)
				System.out.println("Name: "+phone.brand + " Price: "+phone.price);
		});
		Phone obj = list.get(0);
		System.out.println("Brand: "+ obj.brand + " Price: "+ obj.price);
	}
}
