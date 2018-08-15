package org.framestudy.hibernatexml.o2m.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.framestudy.hibernatexml.o2m.ClassBean;
import org.framestudy.hibernatexml.o2m.service.IClassService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class ClassServiceImplTest {

	@Resource
	private IClassService classServiceImpl;
	
	@Test
	public void listClassBeanByStudentName() {
		
		String studentName = "小";
		List<?> datas = classServiceImpl.listClassBeanByStudentName(studentName);
		System.out.println(datas);
	}
	
	
	@Test
	public void updateClassBean() {
		ClassBean cls = classServiceImpl.getClassBeanById(1L);
		Assert.assertNotNull(cls);
		cls.setClassName("T156");
		classServiceImpl.updateClassBean(cls);
	}
	
	@Test
	public void saveClassBean() {
		ClassBean cls = new ClassBean();
		cls.setClassName("J156");
		//由于我们在ClassBean.hbm.xml中，配置了inverse=true，表示关系维护的控制权，不在班级手上，所以班级做改变的时候，不需要维护学生的关联关系
		//所以，我们直接操作班级即可
		classServiceImpl.saveClassBean(cls);
	}
	
	
	
	
}
