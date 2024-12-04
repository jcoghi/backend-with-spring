package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class userDao {
	
	private String jdbcURL = "jdbc://mysql://localhost:3306/userdb?useSSL=false";
	private String jdbcUser = "root";
	private String jdbcSenha = "123456";
	private String jdbcDriver = "com.mysql.jdbc.Driver";	
	
	private static final String INSERT_USERS_SQL = "INSERT INTO users" + "(nome, email, pais) VALUE "
	+ "(?,?,?);";
	
	private static final String SELECTED_USER_BY_ID = "select id,nome,pais from users where id = ?;";
	private static final String SELECT_ALL_USERS = "select * from users";
	private static final String DELETE_USERS = "delete from users where id = ?;";	
	private static final String UPDATE_USERS = "update users set nome = ?, email=?, pais=? where id=?;";	
	
	public userDao() {}
	
	protected Connection getConnection() {
		Connection conect = null;
		try {
			Class.forName("jdbcDriver");
			conect = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcSenha);
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conect;
	}
	
	public void inserirUser(User user) throws SQLException {
		System.out.println("INSERT_USERS_SQL");
		try (Connection conect = getConnection();
				PreparedStatement ps = conect.prepareStatement(INSERT_USERS_SQL)) {
			ps.setString(1,user.getNome());
			ps.setString(2,user.getEmail());
			ps.setString(3,user.getPais());
			System.out.println(ps);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User selectUser(int id) {
		User user = null;
		try (Connection conect = getConnection();
				PreparedStatement ps = conect.prepareStatement(SELECTED_USER_BY_ID)) {
			ps.setInt(1, id);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String pais = rs.getString("pais");
				user = new User(id, nome, email, pais);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
