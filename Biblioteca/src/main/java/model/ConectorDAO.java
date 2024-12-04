package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectorDAO {
	
	public Connection conexaoDAO() {
		Connection con = null;
		
		try {
			
			final String URL = "jdbc:mysql://127.0.0.1:3306/teste";
			final String USER = "root";
			final String SENHA = "123456";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,USER,SENHA);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
}
