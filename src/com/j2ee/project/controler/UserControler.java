package com.j2ee.project.controler;

import java.util.Date;
import java.util.List;

import com.j2ee.project.bean.UserBean;
import com.j2ee.project.dao.UserDao;

public class UserControler {

	public UserControler() {

	}

	public boolean addUser(UserBean user) {
		UserDao userDao = UserDao.getInstance();
		
		boolean rs = userDao.add(user.getFirstName(), user.getLastName(),
				user.getBirthdate(), user.getLogin(), user.getEmail(), user.getPassword());

		return rs;
	}

	public boolean editUser(UserBean user) {
		UserDao userDao = UserDao.getInstance();
		
		boolean rs = userDao.edit(user.getId(), user.getFirstName(), user.getLastName(),
				user.getBirthdate(), user.getLogin(), user.getEmail(), user.getPassword(), user.isAdministrator());

		return rs;
	}

	public List<UserBean> getAllUsers() {
		UserDao userDao = UserDao.getInstance();
		
		List<UserBean> list = userDao.getAll();

		return list;
	}

	public UserBean getUser(int userId) {
		UserDao userDao = UserDao.getInstance();
		
		UserBean user = userDao.getUser(userId);

		return user;
	}
	
	public static void main(String[] args) {
		UserControler uc = new UserControler();
		UserBean user = new UserBean("Donatien", "Gascoin", new Date(795924245), "donatien.gascoin@gmail.com", "Dodo", "dodo95");
		boolean addUser = uc.addUser(user);
		System.out.println("User add: "+addUser);
		
		List<UserBean> allUsers = uc.getAllUsers();
		System.out.println(allUsers);
		
		user.setFirstName("Dodo");
		user.setId(1);
		boolean editUser = uc.editUser(user);
		System.out.println("User edit: "+editUser);
		
		user = uc.getUser(1);
		System.out.println("User edited:" + user);
		
	}
}
