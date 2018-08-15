package org.framestudy.hibernatexml.o2m.service;

import java.util.List;

import org.framestudy.hibernatexml.o2m.ClassBean;

public interface IClassService {

	void saveClassBean(ClassBean cls);
	
	void updateClassBean(ClassBean cls);
	
	ClassBean getClassBeanById(Long id);
	
	List<?> listClassBeanByStudentName(String studentName);
	
}
