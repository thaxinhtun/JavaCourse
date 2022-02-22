package day8_OOP;

public class Using_Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person obj1 = new Person();
		obj1.display();
		
		Person obj2 = new Person("Jhon",24,false);
		Person obj3 = new Person("Yuki",30,true);
		
		obj2.display();
		obj3.display();
	}

}
class Person{
	String name;
	int age;
	boolean is_single;
	
	//default constructor
	public Person() {
		//default values for(String,int,boolean) are(null,0,false)
	}
	//parameterized constructor
	public Person(String name,int age,boolean status) {
		this.name =name;
		this.age = age;
		this.is_single = status;
	}
	public void display() {
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println("Is single?: "+ ((is_single)? "yes":"no"));
		System.out.println("**************");
	}
}
