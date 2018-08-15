package org.framestudy.hibernatexml.m2m;

import java.io.Serializable;
import java.util.Set;

public class PlayerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1962460732736859985L;

	private Long id;
	private String playerName;
	
	private Set<GameBean> games;

	public PlayerBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Set<GameBean> getGames() {
		return games;
	}

	public void setGames(Set<GameBean> games) {
		this.games = games;
	}

	@Override
	public String toString() {
		return "PlayerBean [id=" + id + ", playerName=" + playerName + ", games=" + games + "]";
	}
}
