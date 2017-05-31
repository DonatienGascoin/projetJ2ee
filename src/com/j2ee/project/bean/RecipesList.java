package com.j2ee.project.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class RecipesList {

	private List<ReceipeBean> receipeBeans;
	private ReceipeBean selectedReceipe;

	public RecipesList(List<ReceipeBean> receipeBeans) {
		this.receipeBeans = receipeBeans;
	}

	public List<ReceipeBean> getReceipeBeans() {
		return receipeBeans;
	}

	public void setReceipeBeans(List<ReceipeBean> receipeBeans) {
		this.receipeBeans = receipeBeans;
	}

	public ReceipeBean getSelectedReceipe() {
		return selectedReceipe;
	}

	public void setSelectedReceipe(ReceipeBean selectedReceipe) {
		this.selectedReceipe = selectedReceipe;
	}
}
