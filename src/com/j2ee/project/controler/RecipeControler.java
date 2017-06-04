package com.j2ee.project.controler;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.j2ee.project.bean.RecipeBean;
import com.j2ee.project.bean.RecipeList;
import com.j2ee.project.dao.RecipeDao;

@ManagedBean
@SessionScoped
public class RecipeControler {

	public boolean addReceipt(RecipeBean recipe) {
		RecipeDao recipeDao = RecipeDao.getInstance();

		boolean rs = recipeDao.add(recipe.getName(), recipe.getDetails(), recipe.getResume(), recipe.getNbPersons(),
				recipe.getComplexity(), recipe.getType(), recipe.getImage(), recipe.getDuration());

		return rs;
	}

	public String editRecipe(RecipeBean recipe) {
		RecipeDao recipeDao = RecipeDao.getInstance();

		recipeDao.edit(recipe.getId(), recipe.getName(), recipe.getDetails(), recipe.getResume(), recipe.getNbPersons(),
				recipe.getComplexity(), recipe.getType(), recipe.getImage(), recipe.getDuration());

		return "adminRecipes.jsf";
	}

	public void deleteRecipe(RecipeBean recipe) {
		RecipeDao recipeDao = RecipeDao.getInstance();

		recipeDao.delete(recipe.getId());

		manageRecipe();

		redirectTo("adminRecipes");

	}

	public List<RecipeBean> getAllRecipes() {
		RecipeDao recipeDao = RecipeDao.getInstance();

		List<RecipeBean> list = recipeDao.getAll();

		return list;
	}

	public void getRecipeById(int recipeId) {
		RecipeDao recipeDao = RecipeDao.getInstance();

		RecipeBean recipe = recipeDao.getRecipe(recipeId);

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("currentRecipeDetail", recipe);

		redirectTo("showDetailRecipe");
	}

	public void getRecipe(RecipeBean recipe) {
		RecipeDao recipeDao = RecipeDao.getInstance();

		RecipeList recipes = new RecipeList(recipeDao.getRecipe(recipe.getDuration(), recipe.getComplexity(),
				recipe.getNbPersons(), recipe.getType()));

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("currentRecipeResearch", recipes);

		redirectTo("showRecipeResult");
	}

	public List<RecipeBean> getrecipe(int duration, int complexity, int nbPersons, String type) {
		RecipeDao recipeDao = RecipeDao.getInstance();

		List<RecipeBean> recipes = recipeDao.getRecipe(duration, complexity, nbPersons, type);

		return recipes;
	}

	public void redirectTo(String page) {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.getFlash().setKeepMessages(true);
		try {
			context.redirect(context.getRequestContextPath() + "/composite/" + page + ".jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String manageRecipe() {

		RecipeList rL = new RecipeList(getAllRecipes());

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("allRecipes", rL);

		return "adminRecipes.jsf";
	}

	/**
	 * To test
	 * 
	 */
	/*
	 * public static void main(String[] args) {
	 * 
	 * recipeControler rc = new recipeControler();
	 * System.out.println(rc.getAllrecipes());
	 * 
	 * recipeBean bean = new recipeBean("Crepes",
	 * "Farine + oeuf + lait + biere", "Delicieuse crepes", 4, 1, "Dessert",
	 * "crepes.png", 4); boolean addReceipt = rc.addReceipt(bean);
	 * System.out.println("Add recipe: " + addReceipt);
	 * 
	 * bean.setNbPersons(1); bean.setId(1); boolean editUser =
	 * rc.editrecipe(bean); System.out.println("User edit: " + editUser);
	 * 
	 * bean = rc.getrecipeById(1); System.out.println("User edited:" + bean);
	 * System.out.println(rc.getAllrecipes());
	 * 
	 * }
	 */
}
