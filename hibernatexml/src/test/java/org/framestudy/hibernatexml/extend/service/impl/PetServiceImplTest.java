package org.framestudy.hibernatexml.extend.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.framestudy.hibernatexml.extend.DogBean;
import org.framestudy.hibernatexml.extend.service.IPetService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class PetServiceImplTest {

	@Resource
	private IPetService petServiceImpl;
	
	@Test
	public void listPetBeanByPetName() {
		String petName = "小";
		List<?> datas = petServiceImpl.listPetBeanByPetName(petName);
		System.out.println(datas);
	}
	
	
	@Test
	public void listAllPet() {
		
		List<?> datas = petServiceImpl.listAllPet();
		
		System.out.println(datas);
		
	}
	
	
	@Test
	public void deleteDog() {
		DogBean dog = petServiceImpl.getDogBeanById(1L);
		Assert.assertNotNull(dog);
		petServiceImpl.deleteDog(dog);
		
	}
	
	
	@Test
	public void updateDog() {
		DogBean dog = petServiceImpl.getDogBeanById(1L);
		Assert.assertNotNull(dog);
		dog.setPetName("小白");
		petServiceImpl.updateDog(dog);
		
	}
	
	@Test
	public void saveDog() {
		DogBean dog = new DogBean();
		dog.setPetName("大黄");
		dog.setBone(20);
		petServiceImpl.saveDog(dog);
	}
	
	
	
	
	
	
	
	
	
	
	
}
