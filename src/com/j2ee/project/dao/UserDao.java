package com.j2ee.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.j2ee.project.bean.UserBean;

public class UserDao extends Dao {

	private static UserDao userDao;

	private UserDao() {

	}

	public static UserDao getInstance() {
		if (null == userDao) {
			userDao = new UserDao();
		}
		return userDao;
	}

	public boolean add(String firstName, String lastName, int age, String login, String email, String password) {
		boolean result = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn;
			conn = DriverManager.getConnection(url, user, passwd);

			Statement query = conn.createStatement();

			PreparedStatement querySt = conn.prepareStatement(Request.INSERT_USER.getQuery());
			// D�finition de la valeur des param�tres
			querySt.setString(1, lastName);
			querySt.setString(2, firstName);
			querySt.setString(3, login);
			querySt.setString(4, password);
			querySt.setString(5, email);
			querySt.setInt(6, age);

			// Ex�cution
			int rs = querySt.executeUpdate();
			if (rs == 1) {
				result = true;
			}
			query.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean edit(int id, String firstName, String lastName, int age, String login, String email, String password,
			boolean administrator) {
		boolean result = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn;
			conn = DriverManager.getConnection(url, user, passwd);

			Statement query = conn.createStatement();

			PreparedStatement querySt = conn.prepareStatement(Request.UPDATE_USER.getQuery());
			// D�finition de la valeur des param�tres
			querySt.setString(1, lastName);
			querySt.setString(2, firstName);
			querySt.setString(3, login);
			querySt.setString(4, password);
			querySt.setString(5, email);
			querySt.setInt(6, age);
			querySt.setBoolean(7, administrator);
			// Where clause
			querySt.setInt(8, id);

			// Ex�cution
			int rs = querySt.executeUpdate();
			if (rs == 0) {
				result = true;
			}
			query.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<UserBean> getAll() {
		List<UserBean> userList = new ArrayList<UserBean>();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn;
			conn = DriverManager.getConnection(url, user, passwd);

			Statement query = conn.createStatement();
			// Executer puis parcourir les r�sultats
			ResultSet rs = query.executeQuery(Request.SELECT_ALL_USERS.getQuery());

			while (rs.next()) {
				UserBean user = new UserBean();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setLogin(rs.getString("login"));
				user.setAge(rs.getInt("age"));
				user.setEmail(rs.getString("email"));
				user.setAdministrator(rs.getBoolean("administrator"));

				userList.add(user);
			}

			rs.close();
			query.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return userList;
	}

	public UserBean getUser(int userId) {
		UserBean userB = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn;
			conn = DriverManager.getConnection(url, user, passwd);

			PreparedStatement querySt = conn.prepareStatement(Request.SELECT_USER.getQuery());
			// D�finition de la valeur des param�tres
			querySt.setInt(1, userId);

			ResultSet rs = querySt.executeQuery();
			// Only one result
			if (rs.next()) {
				userB = new UserBean();
				userB.setId(rs.getInt("id"));
				userB.setFirstName(rs.getString("firstName"));
				userB.setLastName(rs.getString("lastName"));
				userB.setAge(rs.getInt("age"));
				userB.setEmail(rs.getString("email"));
				userB.setAdministrator(rs.getBoolean("administrator"));

			}

			rs.close();
			querySt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return userB;
	}

	public UserBean connectUser(String login, String password) {
		UserBean userB = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn;
			conn = DriverManager.getConnection(url, user, passwd);

			PreparedStatement querySt = conn.prepareStatement(Request.EXIST_USER.getQuery());
			// D�finition de la valeur des param�tres
			querySt.setString(1, login);
			querySt.setString(2, password);

			ResultSet rs = querySt.executeQuery();
			// Only one result
			if (rs.next()) {
				userB = new UserBean();
				userB.setId(rs.getInt("id"));
				userB.setLogin(rs.getString("login"));
				userB.setPassword(rs.getString("password"));
				userB.setFirstName(rs.getString("firstName"));
				userB.setLastName(rs.getString("lastName"));
				userB.setAge(rs.getInt("age"));
				userB.setEmail(rs.getString("email"));
				userB.setAdministrator(rs.getBoolean("administrator"));
			}

			rs.close();
			querySt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return userB;
	}

	public UserBean connectAdmin(String login, String password) {
		UserBean userB = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn;
			conn = DriverManager.getConnection(url, user, passwd);

			PreparedStatement querySt = conn.prepareStatement(Request.EXIST_ADMIN.getQuery());
			// D�finition de la valeur des param�tres
			querySt.setString(1, login);
			querySt.setString(2, password);

			ResultSet rs = querySt.executeQuery();
			// Only one result
			if (rs.next()) {
				userB = new UserBean();
				userB.setId(rs.getInt("id"));
				userB.setLogin(rs.getString("login"));
				userB.setPassword(rs.getString("password"));
				userB.setFirstName(rs.getString("firstName"));
				userB.setLastName(rs.getString("lastName"));
				userB.setAge(rs.getInt("age"));
				userB.setEmail(rs.getString("email"));
				userB.setAdministrator(rs.getBoolean("administrator"));
			}

			rs.close();
			querySt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return userB;
	}

	public boolean delete(int id) {
		boolean result = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn;
			conn = DriverManager.getConnection(url, user, passwd);

			Statement query = conn.createStatement();

			PreparedStatement querySt = conn.prepareStatement(Request.DELETE_USER.getQuery());
			// D�finition de la valeur des param�tres
			querySt.setInt(1, id);

			// Ex�cution
			int rs = querySt.executeUpdate();
			if (rs == 0) {
				result = true;
			}
			query.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean adminEditUser(int id, String firstName, String lastName, int age, String login, String email,
			boolean administrator) {
		boolean result = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn;
			conn = DriverManager.getConnection(url, user, passwd);

			Statement query = conn.createStatement();

			PreparedStatement querySt = conn.prepareStatement(Request.ADMIN_UPDATE_USER.getQuery());
			// D�finition de la valeur des param�tres
			querySt.setString(1, lastName);
			querySt.setString(2, firstName);
			querySt.setString(3, login);
			querySt.setString(4, email);
			querySt.setInt(5, age);
			querySt.setBoolean(6, administrator);
			// Where clause
			querySt.setInt(7, id);

			// Ex�cution
			int rs = querySt.executeUpdate();
			if (rs == 0) {
				result = true;
			}
			query.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

}
