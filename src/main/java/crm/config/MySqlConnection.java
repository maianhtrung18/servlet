package crm.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	
	public static Connection getConnection() {
			Connection  connection = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				return DriverManager.getConnection("jdbc:mysql://localhost:3306/crm", "root", "admin");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connection;
	}

}
