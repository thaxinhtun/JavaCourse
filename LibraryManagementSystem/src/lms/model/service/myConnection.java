package lms.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class myConnection {
	public static Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/librarydb","root","");
		return con;
}
	}
