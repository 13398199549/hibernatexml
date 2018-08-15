package org.framestudy.hibernatexml.o2o.service;

import java.util.List;
import java.util.Map;

import org.framestudy.hibernatexml.bean.PagerBean;
import org.framestudy.hibernatexml.o2o.HusbandBean;

public interface IHusbandService {

	void saveHusband(HusbandBean husband); 
	
	void udpateHusband(HusbandBean husband); 
	
	void deleteHusband(HusbandBean husband); 
	
	HusbandBean getHusbandById(String id);
	
	List<?> listHusbandByWifeName(String wifeName);
	
	PagerBean listHusbandByParams2PagerBean(Map params,PagerBean pager);
	
	
	
}
