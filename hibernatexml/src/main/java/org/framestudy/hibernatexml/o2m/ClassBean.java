package org.framestudy.hibernatexml.o2m;

import java.io.Serializable;
import java.util.Set;

public class ClassBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 103616760723112398L;

	private Long id;
	private String className;
	
	private Set<StudentBean> students;

	public ClassBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Set<StudentBean> getStudents() {
		return students;
	}

	public void setStudents(Set<StudentBean> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "ClassBean [id=" + id + ", className=" + className + "]";
	}
}
