package com.j2ee.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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

	public boolean add(String firstName, String lastName, Date birthdate,
			String login, String email, String password) {
		boolean result = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn;
			conn = DriverManager.getConnection(url, user, passwd);

			Statement query = conn.createStatement();

			PreparedStatement querySt = conn
					.prepareStatement(Request.INSERT_USER.getQuery());
			// Définition de la valeur des paramètres
			querySt.setString(1, lastName);
			querySt.setString(2, firstName);
			querySt.setString(3, login);
			querySt.setString(4, password);
			querySt.setString(5, email);
			querySt.setDate(6, new java.sql.Date(birthdate.getTime()));

			// Exécution
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

	public boolean edit(int id, String firstName, String lastName,
			Date birthdate, String login, String email, String password,
			boolean administrator) {
		boolean result = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn;
			conn = DriverManager.getConnection(url, user, passwd);

			Statement query = conn.createStatement();

			PreparedStatement querySt = conn
					.prepareStatement(Request.UPDATE_USER.getQuery());
			// Définition de la valeur des paramètres
			querySt.setString(1, lastName);
			querySt.setString(2, firstName);
			querySt.setString(3, login);
			querySt.setString(4, password);
			querySt.setString(5, email);
			querySt.setDate(6, new java.sql.Date(birthdate.getTime()));
			querySt.setBoolean(7, administrator);
			// Where clause
			querySt.setInt(8, id);

			// Exécution
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
			// Executer puis parcourir les résultats
			ResultSet rs = query.executeQuery(Request.SELECT_ALL_USERS
					.getQuery());

			while (rs.next()) {
				UserBean user = new UserBean();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setBirthdate(rs.getDate("birthdate"));
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

			PreparedStatement querySt = conn
					.prepareStatement(Request.SELECT_USER.getQuery());
			// Définition de la valeur des paramètres
			querySt.setInt(1, userId);

			ResultSet rs = querySt.executeQuery();
			// Only one result
			if (rs.next()) {
				userB = new UserBean();
				userB.setId(rs.getInt("id"));
				userB.setFirstName(rs.getString("firstName"));
				userB.setLastName(rs.getString("lastName"));
				userB.setBirthdate(rs.getDate("birthdate"));
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

}
