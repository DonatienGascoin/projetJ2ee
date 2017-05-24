package com.j2ee.project.controler;

import java.util.List;

import com.j2ee.project.bean.ReceipeBean;
import com.j2ee.project.dao.ReceipeDao;

public class ReceipeControler {

	public boolean addReceipt(ReceipeBean receipe) {
		ReceipeDao receipeDao = ReceipeDao.getInstance();

		boolean rs = receipeDao.add(receipe.getName(), receipe.getDetails(),
				receipe.getResume(), receipe.getNbPersons(),
				receipe.getComplexity(), receipe.getType(), receipe.getImage());

		return rs;
	}

	public boolean editReceipe(ReceipeBean receipe) {
		ReceipeDao receipeDao = ReceipeDao.getInstance();

		boolean rs = receipeDao.edit(receipe.getId(), receipe.getName(),
				receipe.getDetails(), receipe.getResume(),
				receipe.getNbPersons(), receipe.getComplexity(),
				receipe.getType(), receipe.getImage());

		return rs;
	}

	public List<ReceipeBean> getAllReceipes() {
		ReceipeDao receipeDao = ReceipeDao.getInstance();

		List<ReceipeBean> list = receipeDao.getAll();

		return list;
	}

	public ReceipeBean getReceipe(int receipeId) {
		ReceipeDao receipeDao = ReceipeDao.getInstance();

		ReceipeBean receipe = receipeDao.getReceipe(receipeId);

		return receipe;
	}

	/**
	 * To test
	 * 
	 */
	public static void main(String[] args) {

		ReceipeControler rc = new ReceipeControler();
		System.out.println(rc.getAllReceipes());

		ReceipeBean bean = new ReceipeBean("Crepes",
				"Farine + oeuf + lait + biere", "Delicieuse crepes", 4, 1,
				"Dessert", "crepes.png");
		boolean addReceipt = rc.addReceipt(bean);
		System.out.println("Add receipe: " + addReceipt);

		bean.setNbPersons(1);
		bean.setId(1);
		boolean editUser = rc.editReceipe(bean);
		System.out.println("User edit: " + editUser);

		bean = rc.getReceipe(1);
		System.out.println("User edited:" + bean);
		System.out.println(rc.getAllReceipes());

	}
}
