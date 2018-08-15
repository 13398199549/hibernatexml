package org.framestudy.hibernatexml.o2m;

import java.io.Serializable;

public class StudentBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6086864508717623579L;

	private Long id;
	private String studentName;
	private ClassBean cls;
	
	public StudentBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public ClassBean getCls() {
		return cls;
	}
	public void setCls(ClassBean cls) {
		this.cls = cls;
	}
	@Override
	public String toString() {
		return "StudentBean [id=" + id + ", studentName=" + studentName + ", cls=" + cls + "]";
	}
}
