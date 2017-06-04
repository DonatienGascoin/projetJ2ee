package com.j2ee.project.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class RecipeList implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<RecipeBean> recipes;
	private RecipeBean selectedRecipe;

	public RecipeList() {
	}

	public RecipeList(List<RecipeBean> recipes) {
		this.recipes = recipes;
	}

	public List<RecipeBean> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<RecipeBean> recipes) {
		this.recipes = recipes;
	}

	public RecipeBean getSelectedRecipe() {
		return selectedRecipe;
	}

	public void setSelectedRecipe(RecipeBean selectedRecipe) {
		// Set research duration:
		selectedRecipe.setResearchDuration();

		this.selectedRecipe = selectedRecipe;
	}

	@Override
	public String toString() {
		return "RecipeList [recipes=" + recipes + ", selectedRecipe=" + selectedRecipe + "]";
	}

}
