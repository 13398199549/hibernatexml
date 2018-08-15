package org.framestudy.hibernatexml.m2m.service;

import java.util.List;

import org.framestudy.hibernatexml.m2m.GameBean;

public interface IGameService {

	void saveGame(GameBean game);
	
	GameBean getGameBeanById(Long id);
	
	List<?> listGameBeanByPlayerName(String playerName);
	
}
