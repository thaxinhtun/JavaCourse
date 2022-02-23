package day8_OOP;

 class Database_Config {

	String db_name = "emplyoee_db";
	private static Database_Config config = null;
	
	private Database_Config() {
		
	}

	public static Database_Config getInstance() {
		if(config == null) 
			config = new  Database_Config();
		
		return config;
	}
 }
public class Private_Constructor{
		public static void main(String[] args) {
			Database_Config obj1 = Database_Config.getInstance();
			System.out.println("Obj1's name:" + obj1.db_name);
			Database_Config obj2 = Database_Config.getInstance();
			System.out.println("Obj1's name:" + obj2.db_name);
			obj2.db_name = "banking sys";
			System.out.println("obj1's db name:" + obj1.db_name);
		}
	}



