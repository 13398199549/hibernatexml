package org.framestudy.hibernatexml.m2m.dao.impl;

import java.util.List;

import org.framestudy.hibernatexml.m2m.PlayerBean;
import org.framestudy.hibernatexml.m2m.dao.IPlayerDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerDaoImpl implements IPlayerDao {

	private Session session;
	
	@Override
	public void savePlayer(PlayerBean player) {
		// TODO Auto-generated method stub
		session.save(player);
	}

	@Override
	public void updatePlayer(PlayerBean player) {
		// TODO Auto-generated method stub
		session.update(player);
	}

	@Override
	public void deletePlayer(PlayerBean player) {
		// TODO Auto-generated method stub
		session.delete(player);
	}

	@Override
	public PlayerBean getPlayerBeanById(Long id) {
		// TODO Auto-generated method stub
		return (PlayerBean) session.get(PlayerBean.class, id);
	}

	@Override
	public List<?> listPlayerBeanByGameName(String gameName) {
		// TODO Auto-generated method stub
		String hql = "From PlayerBean as p left join fetch p.games as g where g.gameName like CONCAT(?,'%')";
		Query query = session.createQuery(hql);
		query.setString(0, gameName);
		return query.list();
	}

}
