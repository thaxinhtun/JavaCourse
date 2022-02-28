package Interface;

public interface Flying {
	void fly();
}
class Bird implements Flying{

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("Birds Fly with wings");
	}
	
}
class Airplane implements Flying{

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("Airplane fly with engine");
	}
	
}
class Human implements Flying{

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("Humans fly with parachute");
	}
	
}
