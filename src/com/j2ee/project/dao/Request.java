package com.j2ee.project.dao;

public enum Request {

	SELECT_ALL_USERS("SELECT id, lastName, firstName, login, password, email, age,"
				+ " administrator FROM binome36.USERS;"),

	SELECT_USER("SELECT id, lastName, firstName, login, password, email, age,"
			+ " administrator FROM binome36.USERS WHERE id=?;"),

	EXIST_USER("SELECT id, lastName, firstName, login, password, email, age,"
			+ " administrator FROM binome36.USERS WHERE firstName=? and lastname=?;"),

	INSERT_USER("INSERT INTO binome36.USERS"
			+ "(id, lastName, firstName, login, password, email, age, administrator)"
			+ "VALUES(null, ?, ?, ?, ?, ?, ?, 0);"),

	UPDATE_USER("UPDATE binome36.USERS "
			+ "SET lastName=?, firstName=?, login=?, password=?, email=?, age=?, administrator=? "
			+ "WHERE id=?;"),
	
	SELECT_ALL_RECEIPT("SELECT `id`, `name`, `resume`, `details`, `nbPersons`, `complexity`, `type`, `image` FROM binome36.RECEIPE"),
	
	SELECT_RECEIPT("SELECT `id`, `name`, `resume`, `details`, `nbPersons`, `complexity`, `type`, image FROM binome36.RECEIPE where id=?"),

	INSERT_RECEIPE("INSERT INTO binome36.RECEIPE(`id`, `name`, `resume`, `details`, `nbPersons`, `complexity`, `type`, image)"
			+ " VALUES"
			+ " (null,?,?,?,?,?,?,?)"),
	
	UPDATE_RECEIPE("UPDATE binome36.RECEIPE"
			+ " SET `name`=?,`resume`=?,`details`=?,`nbPersons`=?,`complexity`=?,`type`=?, `image`=?"
			+ " WHERE id=?"),
			
	INSERT_NOTE("INSERT INTO binome36.NOTE (id, idReceipe, title, note, idUser)"
			+ " VALUES"
			+ "(null, ?, ?, ?, ?);"),
			
	UPDATE_NOTE("UPDATE binome36.NOTE"
			+ " SET idReceipe=?, title=?, note=?, idUser=?"
			+ " WHERE id=?;"),
			
	SELECT_ALL_NOTES_FOR_RECEIPE("SELECT id, idReceipe, title, note, idUser FROM binome36.NOTE "
			+ "where idReceipe = ?;"),
	
	SELECT_ALL_NOTES_FOR_USER("SELECT id, idReceipe, title, note, idUser FROM binome36.NOTE "
			+ "where idUser = ?;");

	private String query;

	private Request(String query) {
		this.query = query;
	}

	public String getQuery() {
		return query;
	}
}
