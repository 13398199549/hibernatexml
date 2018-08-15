package org.framestudy.hibernatexml.extend;

public class DogBean extends PetBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4620130146316742223L;

	private Integer bone;

	public DogBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getBone() {
		return bone;
	}

	public void setBone(Integer bone) {
		this.bone = bone;
	}

	@Override
	public String toString() {
		return "DogBean [bone=" + bone + ", getId()=" + getId() + ", getPetName()=" + getPetName() + "]";
	}
}
