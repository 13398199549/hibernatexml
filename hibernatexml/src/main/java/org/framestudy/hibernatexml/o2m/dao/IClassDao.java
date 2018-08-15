package org.framestudy.hibernatexml.o2m.dao;

import java.util.List;

import org.framestudy.hibernatexml.o2m.ClassBean;

public interface IClassDao {

	void saveClassBean(ClassBean cls);
	
	void updateClassBean(ClassBean cls);
	
	ClassBean getClassBeanById(Long id);
	
	List<?> listClassBeanByStudentName(String studentName);
}
