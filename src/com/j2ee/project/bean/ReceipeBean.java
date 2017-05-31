package com.j2ee.project.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ReceipeBean implements Serializable {

	private int id;
	private String name;
	private String details;
	private String resume;
	private int nbPersons;
	private int complexity;
	private String type;
	private String image;
	private int duration;
	private String researchDuration;

	public ReceipeBean() {
	}

	public ReceipeBean(String name, String details, String resume, int nbPersons, int complexity, String type,
			String image, int duration) {
		super();
		this.name = name;
		this.details = details;
		this.resume = resume;
		this.nbPersons = nbPersons;
		this.complexity = complexity;
		this.type = type;
		this.image = image;
		this.duration = duration;
	}

	public ReceipeBean(String name, String details, String resume, int nbPersons, int complexity, String type,
			String image, String researchDuration) {
		super();
		this.name = name;
		this.details = details;
		this.resume = resume;
		this.nbPersons = nbPersons;
		this.complexity = complexity;
		this.type = type;
		this.image = image;
		this.researchDuration = researchDuration;
	}

	public ReceipeBean(int id, String name, String details, String resume, int nbPersons, int complexity, String type,
			String image, int duration) {
		super();
		this.id = id;
		this.name = name;
		this.details = details;
		this.resume = resume;
		this.nbPersons = nbPersons;
		this.complexity = complexity;
		this.type = type;
		this.image = image;
		this.duration = duration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public int getNbPersons() {
		return nbPersons;
	}

	public void setNbPersons(int nbPersons) {
		this.nbPersons = nbPersons;
	}

	public int getComplexity() {
		return complexity;
	}

	public void setComplexity(int complexity) {
		this.complexity = complexity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getResearchDuration() {
		return researchDuration;
	}

	public void setResearchDuration(String researchDuration) {
		this.researchDuration = researchDuration;

		String[] split = researchDuration.split(":");
		setDuration(Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]));
	}

	@Override
	public String toString() {
		return "ReceipeBean [id=" + id + ", name=" + name + ", details=" + details + ", resume=" + resume
				+ ", nbPersons=" + nbPersons + ", complexity=" + complexity + ", type=" + type + ", image=" + image
				+ ", duration=" + duration + ", researchDuration=" + researchDuration + "]";
	}

}
