package org.framestudy.hibernatexml.m2m.dao.impl;

import java.util.List;

import org.framestudy.hibernatexml.m2m.GameBean;
import org.framestudy.hibernatexml.m2m.dao.IGameDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class GameDaoImpl implements IGameDao {

	private Session session;
	
	@Override
	public void saveGame(GameBean game) {
		// TODO Auto-generated method stub
		session.save(game);
	}

	@Override
	public GameBean getGameBeanById(Long id) {
		// TODO Auto-generated method stub
		return (GameBean) session.get(GameBean.class, id);
	}

	@Override
	public List<?> listGameBeanByPlayerName(String playerName) {
		// TODO Auto-generated method stub
		String hql = "From GameBean as g left join fetch g.players as p where p.playerName like CONCAT(?,'%')";
		Query query = session.createQuery(hql);
		query.setString(0, playerName);
		return query.list();
	}

}
