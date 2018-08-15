package org.framestudy.hibernatexml.o2m.dao.impl;

import java.util.List;

import org.framestudy.hibernatexml.o2m.StudentBean;
import org.framestudy.hibernatexml.o2m.dao.IStudentDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;


@Repository
public class StudentDaoImpl implements IStudentDao {

	private Session session;
	
	@Override
	public void saveStudent(StudentBean student) {
		// TODO Auto-generated method stub
		session.save(student);
	}

	@Override
	public void updateStudent(StudentBean student) {
		// TODO Auto-generated method stub
		session.update(student);
	}

	@Override
	public void deleteStudent(StudentBean student) {
		// TODO Auto-generated method stub
		session.delete(student);
	}

	@Override
	public StudentBean getStudentBeanById(Long id) {
		// TODO Auto-generated method stub
		return (StudentBean) session.get(StudentBean.class, id);
	}

	@Override
	public List<?> listStudentByClassName(String className) {
		// TODO Auto-generated method stub
		String hql = "From StudentBean as s left join fetch s.cls as c where c.className like CONCAT(?,'%')";
		Query query = session.createQuery(hql);
		query.setString(0, className);
		return query.list();
	}

}
