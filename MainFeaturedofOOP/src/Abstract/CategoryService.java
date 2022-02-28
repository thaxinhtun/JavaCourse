package Abstract;

public class CategoryService extends DatabaseUtil{

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("Insert into category");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("UPDATE category");
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		System.out.println("DELECT from category where id" +id);
		return false;
	}

	@Override
	public Object[] getAll() {
		// TODO Auto-generated method stub
		System.out.println("SELECT* from category");
		return null;
	}

	@Override
	public Object findbyId(int id) {
		// TODO Auto-generated method stub
		System.out.println("SELECT* from category WHERE id = "+ id);
		return null;
	}

}
