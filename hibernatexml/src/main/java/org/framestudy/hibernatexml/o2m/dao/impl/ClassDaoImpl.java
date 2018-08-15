package org.framestudy.hibernatexml.o2m.dao.impl;

import java.util.List;

import org.framestudy.hibernatexml.o2m.ClassBean;
import org.framestudy.hibernatexml.o2m.dao.IClassDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class ClassDaoImpl implements IClassDao {

	private Session session;
	
	@Override
	public void saveClassBean(ClassBean cls) {
		// TODO Auto-generated method stub
		session.save(cls);
	}

	@Override
	public void updateClassBean(ClassBean cls) {
		// TODO Auto-generated method stub
		session.update(cls);
	}

	@Override
	public ClassBean getClassBeanById(Long id) {
		// TODO Auto-generated method stub
		return (ClassBean) session.get(ClassBean.class, id);
	}

	@Override
	public List<?> listClassBeanByStudentName(String studentName) {
		// TODO Auto-generated method stub
		
		String hql = "From ClassBean as c left join fetch c.students as s where s.studentName like CONCAT(?,'%')";
		Query query = session.createQuery(hql);
		query.setString(0, studentName);
		return query.list();
	}

}
