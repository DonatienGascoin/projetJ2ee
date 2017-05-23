package com.j2ee.project.bean;

import java.util.Date;

public class UserBean {
	private int id;
	private String firstName;
	private String lastName;
	private Date birthdate;
	private String login;
	private String email;
	private String password;
	private boolean administrator;

	public UserBean() {
	}

	public UserBean(int id, String firstName, String lastName, Date birthdate,
			String email, String login, String password, boolean administrator) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.email = email;
		this.login = login;
		this.password = password;
		this.administrator = administrator;
	}

	public UserBean(String firstName, String lastName, Date birthdate,
			String email, String login, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.email = email;
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdministrator() {
		return administrator;
	}

	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", birthdate=" + birthdate
				+ ", login=" + login + ", email=" + email + ", password="
				+ password + ", administrator=" + administrator + "]";
	}

}
