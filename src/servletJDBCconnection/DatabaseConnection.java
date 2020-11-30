package servletJDBCconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {
	public static Connection initializeDatabase()  throws SQLException, ClassNotFoundException {
		
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentInfo", "root",
					"1230");

			System.out.println("Connected...");
			return con;

	}

}