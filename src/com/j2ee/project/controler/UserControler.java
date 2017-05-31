package com.j2ee.project.controler;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.j2ee.project.bean.UserBean;
import com.j2ee.project.dao.UserDao;
import com.mysql.jdbc.Util;

@ManagedBean
public class UserControler {

	public boolean addUser(UserBean user) {
		
		UserDao userDao = UserDao.getInstance();
		
		boolean rs = userDao.add(user.getFirstName(), user.getLastName(),
				user.getAge(), user.getLogin(), user.getEmail(),
				user.getPassword());
		
		return rs;
	}

	public boolean editUser(UserBean user) {
		UserDao userDao = UserDao.getInstance();

		boolean rs = userDao.edit(user.getId(), user.getFirstName(),
				user.getLastName(), user.getAge(), user.getLogin(),
				user.getEmail(), user.getPassword(), user.isAdministrator());

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

	public UserBean connectUser(String login, String password) {
		UserDao userDao = UserDao.getInstance();

		UserBean user = userDao.connectUser(login, password);

		return user;
	}
	
	public void connectAdmin(String login, String password) throws IOException {
		UserDao userDao = UserDao.getInstance();

		UserBean user = userDao.connectAdmin(login, password);

		if (user != null){
			this.redirectTo("adminIndex");
		}
	}


	/**
	 * To test
	 * 
	 */
	public static void main(String[] args) {
		UserControler uc = new UserControler();
		UserBean user = new UserBean("Donatien", "Gascoin", 22,
				"donatien.gascoin@gmail.com", "Dodo", "dodo95");
		boolean addUser = uc.addUser(user);
		System.out.println("User add: " + addUser);

		List<UserBean> allUsers = uc.getAllUsers();
		System.out.println(allUsers);

		user.setFirstName("Dodo");
		user.setId(1);
		boolean editUser = uc.editUser(user);
		System.out.println("User edit: " + editUser);

		user = uc.getUser(1);
		System.out.println("User edited:" + user);

	}
	
	// method to redirect to other page
    public void redirectTo(String page) {
    	ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
    	context.getFlash().setKeepMessages(true);
        try {
			context.redirect(context.getRequestContextPath() + "/composite/" + page + ".jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
