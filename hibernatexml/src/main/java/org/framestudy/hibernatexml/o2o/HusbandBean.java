package org.framestudy.hibernatexml.o2o;

import java.io.Serializable;

public class HusbandBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1672374791734096332L;

	private String id;
	private String husbandName;
	private WifeBean wife;
	
	public HusbandBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHusbandName() {
		return husbandName;
	}

	public void setHusbandName(String husbandName) {
		this.husbandName = husbandName;
	}

	public WifeBean getWife() {
		return wife;
	}

	public void setWife(WifeBean wife) {
		this.wife = wife;
	}

	@Override
	public String toString() {
		return "HubandBean [id=" + id + ", husbandName=" + husbandName + ", wife=" + wife + "]";
	}
	
}
