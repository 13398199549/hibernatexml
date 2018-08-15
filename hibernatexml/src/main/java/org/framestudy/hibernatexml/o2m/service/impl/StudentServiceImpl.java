package org.framestudy.hibernatexml.o2m.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.framestudy.hibernatexml.o2m.StudentBean;
import org.framestudy.hibernatexml.o2m.dao.IStudentDao;
import org.framestudy.hibernatexml.o2m.service.IStudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

	@Resource
	private IStudentDao studentDaoImpl;
	
	
	@Override
	public void saveStudent(StudentBean student) {
		// TODO Auto-generated method stub
		studentDaoImpl.saveStudent(student);
	}

	@Override
	public void updateStudent(StudentBean student) {
		// TODO Auto-generated method stub
		studentDaoImpl.updateStudent(student);
	}

	@Override
	public void deleteStudent(StudentBean student) {
		// TODO Auto-generated method stub
		studentDaoImpl.deleteStudent(student);
	}

	@Override
	public StudentBean getStudentBeanById(Long id) {
		// TODO Auto-generated method stub
		return studentDaoImpl.getStudentBeanById(id);
	}

	@Override
	public List<?> listStudentByClassName(String className) {
		// TODO Auto-generated method stub
		return studentDaoImpl.listStudentByClassName(className);
	}

}
