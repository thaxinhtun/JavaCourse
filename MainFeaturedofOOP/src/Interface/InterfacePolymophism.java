package Interface;

public class InterfacePolymophism {
 public static void main(String[] args) {
	Flying flyobj;
	
	flyobj = new Bird();
	flyobj.fly();
	
	flyobj = new Human();
	flyobj.fly();
	
	flyobj = new Airplane();
	flyobj.fly();
	
	Flying[] fly = new Flying[3] ;
	fly[0] = new Bird();
	fly[1] = new Airplane();
	fly[2] = new Human();
	
	for(Flying obj:fly) {
		obj.fly();
	}
		
	
}
}
