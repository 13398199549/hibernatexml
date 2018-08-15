package org.framestudy.hibernatexml.usermag.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.framestudy.hibernatexml.bean.HouseBean;
import org.framestudy.hibernatexml.bean.PagerBean;
import org.framestudy.hibernatexml.bean.UserBean;
import org.framestudy.hibernatexml.bean.UserInfoBean;
import org.framestudy.hibernatexml.tool.SessionUtil;
import org.framestudy.hibernatexml.usermag.service.IUserService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class UserServiceImplTest {

	@Resource
	private IUserService userServiceImpl;
	
	@Test
	public void versionTest() {
		Session session01 = SessionUtil.newSession();
		Transaction tx01 = session01.beginTransaction();
		UserBean user01 = (UserBean) session01.get(UserBean.class, 1L);
		
		Session session02 = SessionUtil.newSession();
		Transaction tx02 = session02.beginTransaction();
		UserBean user02 =  (UserBean) session02.get(UserBean.class, 1L);
		
		try {
			user01.setUserName("小丽");
			session01.update(user01);
			tx01.commit();
			
			user02.setUserName("小王");
			session02.update(user02);
			tx02.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void listUserBeanByIdcard() {
		String idcard = "511";
		List<?> list = userServiceImpl.listUserBeanByIdcard(idcard);
		System.out.println(list);
		
		
		
		List<?> list2 = userServiceImpl.listUserBeanByIdcard(idcard);
		System.out.println(list2);
		
		
		
		
		
//		int size = list.size();
//		for(int i = 0; i < size; i ++) {
//			Object[] objts = (Object[]) list.get(i);
//			System.out.println(objts[0]);
//			System.out.println(objts[1]);
//		}
		
		
		
		
	}
	
	
	@Test
	public void listUserBeanByParmas2PagerBean4CriteriaDemo() {
		
		Map params = new HashMap<>();
		params.put("userName", "曹");
		params.put("loginName", "b");
		
		PagerBean pager = new PagerBean(1, 5);
		pager = userServiceImpl.listUserBeanByParmas2PagerBean4CriteriaDemo(params, pager);
		System.out.println(pager);
	}
	
	@Test
	public void listUserBeanByParams2PagerBean() {
		Map params = new HashMap<>();
		params.put("userName", "曹");
		params.put("loginName", "b");
		
		PagerBean pager = new PagerBean(1, 5);
		pager = userServiceImpl.listUserBeanByParams2PagerBean(params, pager);
		System.out.println(pager);
	}
	
	
	
	@Test
	public void listUserBeanByParams() {
		Map params = new HashMap<>();
		params.put("userName", "曹");
		params.put("loginName", "a");
		
		List<?> datas = userServiceImpl.listUserBeanByParams(params);
		System.out.println(datas);
		
		
		
		
//		int lenth = datas.size();
//		for(int i = 0; i < lenth; i ++) {
//			Object [] objts = (Object[]) datas.get(i);
//			
//			System.out.println(objts[0]);
//			System.out.println(objts[1]);
//			
//		}
//		
		
		
		
		
		
	}
	
	
	
	@Test
	public void listUserBeanByObject() {
		UserBean user = new UserBean();
		user.setUserName("曹");
		user.setLoginName("a");
		List<?> datas = userServiceImpl.listUserBeanByObject(user);
		System.out.println(datas);
	}
	
	@Test
	public void listUserBeanByUserNameAndLoginName() {
		String userName = "曹";
		String loginName = "a";
		List<?> datas = userServiceImpl.listUserBeanByUserNameAndLoginName(userName, loginName);
//		System.out.println(datas);
	}
	
	@Test
	public void deleteUserBean() {
		UserBean user = userServiceImpl.loadUserBeanById(1L);
		Assert.assertNotNull(user);
		
		userServiceImpl.deleteUserBean(user);
	}
	
	
	@Test
	public void updateUserBean() {
		UserBean user = userServiceImpl.getUserBeanById(1L);
		Assert.assertNotNull(user);
		System.out.println(user);
		
		
		UserBean user2 = userServiceImpl.getUserBeanById(1L);
		Assert.assertNotNull(user2);
		System.out.println(user2);
		
		
		
		user.setUserName("小乔");
		user.setUpdateTime(new Date());
		
		UserInfoBean userInfo = user.getUserInfo();
		userInfo.setEducationLevel(2);
		
		HouseBean house = new HouseBean();
		house.setHouseAddress("九眼桥");
		house.setHouseNo("3号桥洞");
		user.getHouses().add(house);
		
		userServiceImpl.updateUserBean(user);
	}
	
	
	
	@Test
	public void saveUserBean() {
		//初始化用户
		UserBean user = new UserBean();
		user.setUserName("曹操");
		user.setPassword("123456");
		user.setCreateTime(new Date());
		user.setLoginName("a");
		//初始化用户信息
		UserInfoBean userInfo = new UserInfoBean();
		userInfo.setIdCard("511381199112341234");
		userInfo.setEducationLevel(4);
		user.setUserInfo(userInfo);
		//初始化房产信息
		Set<HouseBean> houses = new HashSet<>();
		HouseBean house = new HouseBean();
		house.setHouseAddress("九眼桥");
		house.setHouseNo("1号桥洞");
		
		HouseBean house2 = new HouseBean();
		house2.setHouseAddress("九眼桥");
		house2.setHouseNo("2号桥洞");
		houses.add(house2);
		houses.add(house);
		user.setHouses(houses);
		
		userServiceImpl.saveUserBean(user);
		System.out.println(user);
	}
	
	
	
	
	
	
	
	
	
}
