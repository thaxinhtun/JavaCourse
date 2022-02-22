package day8_OOP;


public class Sample_Java_Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Phone ph1 = new Phone("iPhone", "pink", 1800000);
		Phone ph2 = new Phone("Samsung","Black",380000);
		System.out.println("------Phone Info-------");
		System.out.format("Brand(%s),Color(%s),Price(%d)\n",ph1.brand,ph1.color,ph1.price);
		ph1.call();
		ph1.sendSms();
	}	
}
class Phone{
	String brand;
	String color;
	int price;
	
	//constructor
	public Phone(String brand, String color, int price) {
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	//methods
	public void call() {
		System.out.println("Phone calling can be made at here");
	}
	public void sendSms() {
		System.out.println("Message can be sent at here");
	}
}
