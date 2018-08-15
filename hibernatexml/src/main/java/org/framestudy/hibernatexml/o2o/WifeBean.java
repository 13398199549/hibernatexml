package org.framestudy.hibernatexml.o2o;

import java.io.Serializable;

public class WifeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6932298865496811627L;

	private String id;
	private String wifeName;
	
	private HusbandBean husband;

	public WifeBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWifeName() {
		return wifeName;
	}

	public void setWifeName(String wifeName) {
		this.wifeName = wifeName;
	}

	public HusbandBean getHusband() {
		return husband;
	}

	public void setHusband(HusbandBean husband) {
		this.husband = husband;
	}

	@Override
	public String toString() {
		return "WifeBean [id=" + id + ", wifeName=" + wifeName + "]";
	}
}
