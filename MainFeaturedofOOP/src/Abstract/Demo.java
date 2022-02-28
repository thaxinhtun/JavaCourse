package Abstract;

public class Demo {
	public static void main(String[] args) {
		ProductService pService = new ProductService();
		pService.connectDatabase();
	}
}
