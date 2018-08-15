package org.framestudy.hibernatexml.m2m.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.framestudy.hibernatexml.m2m.GameBean;
import org.framestudy.hibernatexml.m2m.service.IGameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class GameServiceImplTest {

	@Resource
	private IGameService gameServiceImpl;
	
	
	@Test
	public void listGameBeanByPlayerName() {
		
		String playerName = "周";
		
		List<?> datas = gameServiceImpl.listGameBeanByPlayerName(playerName);
		System.out.println(datas);
	}
	
	@Test
	public void saveGame() {
		
		GameBean game = new GameBean();
		game.setGameName("逆水寒");
		
		gameServiceImpl.saveGame(game);
	}
	
	
	
	
	
	
	
	
	
}
