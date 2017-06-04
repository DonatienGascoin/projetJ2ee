package com.j2ee.project.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class UserList implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<UserBean> userList;
	private UserBean selectedUser;

	public UserList() {
		this.userList = new ArrayList<>();
	}

	public UserList(List<UserBean> receipeBeans) {
		this.userList = receipeBeans;
	}

	public List<UserBean> getUserList() {
		return userList;
	}

	public void setUserList(List<UserBean> userList) {
		this.userList = userList;
	}

	public UserBean getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UserBean selectedUser) {
		this.selectedUser = selectedUser;
	}
}
