package org.framestudy.hibernatexml.extend.dao.impl;

import java.util.List;

import org.framestudy.hibernatexml.extend.DogBean;
import org.framestudy.hibernatexml.extend.dao.IPetDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class PetDaoImpl implements IPetDao {

	private Session session;
	
	@Override
	public void saveDog(DogBean dog) {
		// TODO Auto-generated method stub
		session.save(dog);
	}

	@Override
	public void updateDog(DogBean dog) {
		// TODO Auto-generated method stub
		session.update(dog);
	}

	@Override
	public void deleteDog(DogBean dog) {
		// TODO Auto-generated method stub
		session.delete(dog);
	}

	@Override
	public DogBean getDogBeanById(Long id) {
		// TODO Auto-generated method stub
		return (DogBean) session.get(DogBean.class, id);
	}

	@Override
	public List<?> listAllPet() {
		// TODO Auto-generated method stub
		String hql = "From PetBean as p";
		Query query = session.createQuery(hql);
		return query.list();
	}

	@Override
	public List<?> listPetBeanByPetName(String petName) {
		// TODO Auto-generated method stub
		String hql = "From PetBean as p where p.petName like CONCAT(?,'%')";
		Query query = session.createQuery(hql);
		query.setString(0, petName);
		return query.list();
	}

}
