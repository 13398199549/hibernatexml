package org.framestudy.hibernatexml.o2m.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.framestudy.hibernatexml.o2m.ClassBean;
import org.framestudy.hibernatexml.o2m.StudentBean;
import org.framestudy.hibernatexml.o2m.service.IClassService;
import org.framestudy.hibernatexml.o2m.service.IStudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class StudentServiceImplTest {

	@Resource
	private IClassService classServiceImpl;
	@Resource
	private IStudentService studentServiceImpl;
	
	@Test
	public void listStudentByClassName() {
		String className = "T";
		List<?> datas = studentServiceImpl.listStudentByClassName(className);
		System.out.println(datas);
		
	}
	
	
	@Test
	public void deleteStudent() {
		StudentBean student = studentServiceImpl.getStudentBeanById(2L);
		Assert.assertNotNull(student);
		studentServiceImpl.deleteStudent(student);
	}
	
	
	
	@Test
	public void updateStudent() {
		StudentBean student = studentServiceImpl.getStudentBeanById(1L);
		Assert.assertNotNull(student);
		student.setStudentName("阿花");
		
		//建立学生和班级之间的关系，现在由学生去维护关联关系
		//注意：你娃儿不换班，请莫要写下面这2句代码
		ClassBean cls = classServiceImpl.getClassBeanById(2L);
		student.setCls(cls);
		
		
		studentServiceImpl.updateStudent(student);
	}
	
	
	
	@Test
	public void saveStudent() {
		StudentBean stu = new StudentBean();
		stu.setStudentName("小王");
		//建立学生和班级之间的关系，现在由学生去维护关联关系
		ClassBean cls = classServiceImpl.getClassBeanById(1L);
		stu.setCls(cls);
		studentServiceImpl.saveStudent(stu);
	}
	
	
	
	
}
