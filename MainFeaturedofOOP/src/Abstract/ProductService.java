package Abstract;

public class ProductService extends DatabaseUtil{

	@Override
	public void connectDatabase() {
		// TODO Auto-generated method stub
		super.connectDatabase();
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("Insert into Product");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Product updated");
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		System.out.println("Delete from product where id = " + id);
		return false;
	}

	@Override
	public Object[] getAll() {
		// TODO Auto-generated method stub
		System.out.println("SELECT* From product");
		return null;
	}

	@Override
	public Object findbyId(int id) {
		// TODO Auto-generated method stub
		System.out.println("SELECT* from product WHERE id =" + id);
		return null;
	}
	
}
