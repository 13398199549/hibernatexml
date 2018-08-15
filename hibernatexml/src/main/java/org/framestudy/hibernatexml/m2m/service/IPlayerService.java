package org.framestudy.hibernatexml.m2m.service;

import java.util.List;

import org.framestudy.hibernatexml.m2m.PlayerBean;

public interface IPlayerService {

	void savePlayer(PlayerBean player);
	
	void updatePlayer(PlayerBean player);
	
	void deletePlayer(PlayerBean player);
	
	PlayerBean getPlayerBeanById(Long id);
	
	List<?> listPlayerBeanByGameName(String gameName);
	
}
