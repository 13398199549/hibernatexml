package org.framestudy.hibernatexml.extend;

import java.io.Serializable;

public class PetBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7196700659675176477L;

	private Long id;
	private String petName;
	public PetBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	@Override
	public String toString() {
		return "PetBean [id=" + id + ", petName=" + petName + "]";
	}
}
