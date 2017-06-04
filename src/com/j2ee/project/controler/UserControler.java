package com.j2ee.project.controler;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.j2ee.project.bean.UserBean;
import com.j2ee.project.dao.UserDao;

@ManagedBean
@SessionScoped
public class UserControler {

	UserBean UserBean;

	public boolean addUser(UserBean user) {

		UserDao userDao = UserDao.getInstance();

		boolean rs = userDao.add(user.getFirstName(), user.getLastName(), user.getAge(), user.getLogin(),
				user.getEmail(), user.getPassword());

		return rs;
	}

	public void toEditUser(UserBean user) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("currentEditUser", user);
	}

	public void cancelEditUser() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		if (null != sessionMap.get("currentEditUser")) {
			sessionMap.remove("currentEditUser");
		}
	}

	public boolean editUser(UserBean user) {
		UserDao userDao = UserDao.getInstance();

		boolean rs = userDao.edit(user.getId(), user.getFirstName(), user.getLastName(), user.getAge(), user.getLogin(),
				user.getEmail(), user.getPassword(), user.isAdministrator());

		return rs;
	}

	public void adminEditUser(UserBean user) {
		UserDao userDao = UserDao.getInstance();

		userDao.adminEditUser(user.getId(), user.getFirstName(), user.getLastName(), user.getAge(), user.getLogin(),
				user.getEmail(), user.isAdministrator());

		// Use to hide User params on screen
		cancelEditUser();
	}

	public void deleteUser(int userId) {
		UserDao userDao = UserDao.getInstance();

		userDao.delete(userId);

		redirectTo("adminUsers");
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

	public void connectUser(String login, String password) {
		UserDao userDao = UserDao.getInstance();

		UserBean user = userDao.connectUser(login, password);

		FacesContext context = FacesContext.getCurrentInstance();
		if (user == null) {
			this.logout();
			context.addMessage(null, new FacesMessage("Error", "Impossible to connect"));
		} else {
			context.addMessage(null, new FacesMessage("Successful", "Successfuly connected !"));
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap.put("userBean", user);
		}
	}

	public void connectAdmin(String login, String password) throws IOException {
		UserDao userDao = UserDao.getInstance();

		UserBean user = userDao.connectAdmin(login, password);

		if (user != null) {
			this.redirectTo("adminIndex");
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMap.put("userBean", user);
		} else {
			this.logout();
		}
	}

	/**
	 * To test
	 * 
	 */
	public static void main(String[] args) {
		UserControler uc = new UserControler();
		UserBean user = new UserBean("Donatien", "Gascoin", 22, "donatien.gascoin@gmail.com", "Dodo", "dodo95");
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

	public void logout() {

		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> map = context.getSessionMap();
		map.clear();
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
