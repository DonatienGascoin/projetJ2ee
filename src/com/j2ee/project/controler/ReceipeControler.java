package com.j2ee.project.controler;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.j2ee.project.bean.ReceipeBean;
import com.j2ee.project.dao.ReceipeDao;

@ManagedBean
@SessionScoped
public class ReceipeControler {

	public boolean addReceipt(ReceipeBean receipe) {
		ReceipeDao receipeDao = ReceipeDao.getInstance();

		boolean rs = receipeDao.add(receipe.getName(), receipe.getDetails(), receipe.getResume(),
				receipe.getNbPersons(), receipe.getComplexity(), receipe.getType(), receipe.getImage(),
				receipe.getDuration());

		return rs;
	}

	public boolean editReceipe(ReceipeBean receipe) {
		ReceipeDao receipeDao = ReceipeDao.getInstance();

		boolean rs = receipeDao.edit(receipe.getId(), receipe.getName(), receipe.getDetails(), receipe.getResume(),
				receipe.getNbPersons(), receipe.getComplexity(), receipe.getType(), receipe.getImage(),
				receipe.getDuration());

		return rs;
	}

	public List<ReceipeBean> getAllReceipes() {
		ReceipeDao receipeDao = ReceipeDao.getInstance();

		List<ReceipeBean> list = receipeDao.getAll();

		return list;
	}

	public ReceipeBean getReceipeById(int receipeId) {
		ReceipeDao receipeDao = ReceipeDao.getInstance();

		ReceipeBean receipe = receipeDao.getReceipe(receipeId);

		return receipe;
	}

	public void redirection(String page){
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
    	context.getFlash().setKeepMessages(true);
        try {
			context.redirect(context.getRequestContextPath() + "/jsf/" + page + ".jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public List<ReceipeBean> getReceipe(ReceipeBean receipe) {
		ReceipeDao receipeDao = ReceipeDao.getInstance();
		receipe = new ReceipeBean("Crepes", "Farine + oeuf + lait + biere", "Delicieuse crepes", 4, 1, "Dessert",
				"crepes.png", 4);
		List<ReceipeBean> receipes = receipeDao.getReceipe(receipe.getDuration(), receipe.getComplexity(),
				receipe.getNbPersons(), receipe.getType());
		return receipes;
	}

	public List<ReceipeBean> getReceipe(int duration, int complexity, int nbPersons, String type) {
		ReceipeDao receipeDao = ReceipeDao.getInstance();

		List<ReceipeBean> receipes = receipeDao.getReceipe(duration, complexity, nbPersons, type);

		return receipes;
	}

	/**
	 * To test
	 * 
	 */
	public static void main(String[] args) {

		ReceipeControler rc = new ReceipeControler();
		System.out.println(rc.getAllReceipes());

		ReceipeBean bean = new ReceipeBean("Crepes", "Farine + oeuf + lait + biere", "Delicieuse crepes", 4, 1,
				"Dessert", "crepes.png", 4);
		boolean addReceipt = rc.addReceipt(bean);
		System.out.println("Add receipe: " + addReceipt);

		bean.setNbPersons(1);
		bean.setId(1);
		boolean editUser = rc.editReceipe(bean);
		System.out.println("User edit: " + editUser);

		bean = rc.getReceipeById(1);
		System.out.println("User edited:" + bean);
		System.out.println(rc.getAllReceipes());

	}
}
