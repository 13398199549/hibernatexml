package org.framestudy.hibernatexml.m2m;

import java.io.Serializable;
import java.util.Set;

public class GameBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8684707528583745196L;

	private Long id;
	private String gameName;
	
	private Set<PlayerBean> players;

	public GameBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public Set<PlayerBean> getPlayers() {
		return players;
	}

	public void setPlayers(Set<PlayerBean> players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return "GameBean [id=" + id + ", gameName=" + gameName + "]";
	}
	
}
