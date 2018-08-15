package org.framestudy.hibernatexml.o2m.service;

import java.util.List;

import org.framestudy.hibernatexml.o2m.StudentBean;

public interface IStudentService {

	void saveStudent(StudentBean student);
	
	void updateStudent(StudentBean student);
	
	void deleteStudent(StudentBean student);
	
	StudentBean getStudentBeanById(Long id);
	
	List<?> listStudentByClassName(String className);
	
}
