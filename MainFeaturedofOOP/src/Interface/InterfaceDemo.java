package Interface;

public class InterfaceDemo {
	public static void main(String[] args) {
		Button btn1 = new Button("btn_login");
		Button btn2 = new Button("btn_logout");
		
		btn1.display();
		btn1.onClick();
		btn1.ondoubleClick();
		
		btn2.display();
		btn2.onClick();
	}
}
