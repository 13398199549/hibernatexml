package org.framestudy.hibernatexml.m2m.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.framestudy.hibernatexml.m2m.GameBean;
import org.framestudy.hibernatexml.m2m.PlayerBean;
import org.framestudy.hibernatexml.m2m.service.IGameService;
import org.framestudy.hibernatexml.m2m.service.IPlayerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class PlayerServiceImplTest {
	
	@Resource
	private IPlayerService playerServiceImpl;
	@Resource
	private IGameService gameServiceImpl;
	
	
	
	@Test
	public void listPlayerBeanByGameName() {
		String gameName = "贪玩";
		List<?> datas = playerServiceImpl.listPlayerBeanByGameName(gameName);
		System.out.println(datas);
	}
	
	
	@Test
	public void deletePlayer() {
		PlayerBean player = playerServiceImpl.getPlayerBeanById(3L);
		Assert.assertNotNull(player);
		
		playerServiceImpl.deletePlayer(player);
	}
	
	
	
	@Test
	public void updatePlayer() {
		PlayerBean player = playerServiceImpl.getPlayerBeanById(4L);
		Assert.assertNotNull(player);
		
		GameBean game02 = gameServiceImpl.getGameBeanById(2L);
		player.getGames().add(game02);
		
		playerServiceImpl.updatePlayer(player);
	}
	
	
	
	
	
	
	
	
	@Test
	public void savePlayer() {
		
		PlayerBean player = new PlayerBean();
		player.setPlayerName("周杰伦");
		
		Set<GameBean> games = new HashSet<>();
		
		GameBean game01 = gameServiceImpl.getGameBeanById(1L);
		
		games.add(game01);
		
		player.setGames(games);
		playerServiceImpl.savePlayer(player);
	}
	
	
	
	
	
	
	
	
	

}
