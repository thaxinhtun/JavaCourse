package Interface;

public class Button implements OnclickListener {

	private String name;
	public Button(String name) {
		this.name =name;
	}
	
	public void display() {
		System.out.println("Fontsize: " + FONT_SIZE);
		System.out.println("Font Type: "+FONT_FAMILY);
	}
	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		System.out.println(name + " click event");
	}

	@Override
	public void ondoubleClick() {
		// TODO Auto-generated method stub
		System.out.println(name + " double click event");
	}

}
