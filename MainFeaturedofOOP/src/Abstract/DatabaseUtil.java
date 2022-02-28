package Abstract;

public abstract class DatabaseUtil {
	private String db_name = "shop_db";

	//concrete method
	public void connectDatabase() {
		System.out.println("Connect to "+ db_name);
	}
	//abstarct method
	public abstract void insert();
	public abstract void update();
	public abstract boolean delete(int id);
	public abstract Object[] getAll();
	public abstract Object findbyId(int id);
}
