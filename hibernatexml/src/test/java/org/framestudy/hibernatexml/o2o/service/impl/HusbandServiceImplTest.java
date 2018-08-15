package org.framestudy.hibernatexml.o2o.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.framestudy.hibernatexml.bean.PagerBean;
import org.framestudy.hibernatexml.o2o.HusbandBean;
import org.framestudy.hibernatexml.o2o.WifeBean;
import org.framestudy.hibernatexml.o2o.service.IHusbandService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class HusbandServiceImplTest {

	@Resource
	private IHusbandService husbandServiceImpl;
	
	
	@Test
	public void listHusbandByParams2PagerBean() {
		
		Map params = new HashMap<>();
		params.put("wifeName", "小");
		PagerBean pager = new PagerBean(1, 5);
		pager = husbandServiceImpl.listHusbandByParams2PagerBean(params, pager);
		
		System.out.println(pager);
		
	}
	
	@Test
	public void listHusbandByWifeName() {
		String wifeName = "小";
		List<?> list = husbandServiceImpl.listHusbandByWifeName(wifeName);
		System.out.println(list);
		
	}
	
	
	@Test
	public void deleteHusband() {
		HusbandBean husband = husbandServiceImpl.getHusbandById("4028816164ac1cdc0164ac1ce2890000");
		Assert.assertNotNull(husband);
		husbandServiceImpl.deleteHusband(husband);
	}
	
	
	@Test
	public void updateHusband() {
		HusbandBean husband = husbandServiceImpl.getHusbandById("4028816164ac1cdc0164ac1ce2890000");
		Assert.assertNotNull(husband);
		WifeBean wife = husband.getWife();
		wife.setWifeName("小杨");
		husbandServiceImpl.udpateHusband(husband);
	}
	
	
	@Test
	public void saveHusband (){
		HusbandBean husband = new HusbandBean();
		husband.setHusbandName("小王3");
		
		WifeBean wife = new WifeBean();
		wife.setWifeName("小马3");
		
		//建立妻子和丈夫之间的关系
		husband.setWife(wife);
		wife.setHusband(husband);
		
		husbandServiceImpl.saveHusband(husband);
		
		
		
		
	}
	
	
	
}
