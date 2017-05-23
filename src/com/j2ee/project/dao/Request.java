package com.j2ee.project.dao;

public enum Request {

	SELECT_ALL_USERS(
			"SELECT id, lastName, firstName, login, password, email, birthdate,"
					+ " administrator FROM binome36.USERS;"), 
	SELECT_USER(
			"SELECT id, lastName, firstName, login, password, email, birthdate,"
					+ " administrator FROM binome36.USERS WHERE id=?;"), 
	INSERT_USER(
			"INSERT INTO binome36.USERS"
					+ "(id, lastName, firstName, login, password, email, birthdate, administrator)"
					+ "VALUES(null, ?, ?, ?, ?, ?, ?, 0);"),

	UPDATE_USER(
			"UPDATE binome36.USERS "
					+ "SET lastName=?, firstName=?, login=?, password=?, email=?, birthdate=?, administrator=? "
					+ "WHERE id=?;");

	private String query;

	private Request(String query) {
		this.query = query;
	}

	public String getQuery() {
		return query;
	}
}
