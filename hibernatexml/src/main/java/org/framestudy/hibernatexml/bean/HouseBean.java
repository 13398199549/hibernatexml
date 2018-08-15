package org.framestudy.hibernatexml.bean;

import java.io.Serializable;
/**
 * 用户房产实体类
 * @author puxubo
 *
 */
public class HouseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4953625881451870303L;

	private Long id;
	/**
	 * 具体地址
	 */
	private String houseAddress;
	/**
	 * 门牌号
	 */
	private String houseNo;
	public HouseBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHouseAddress() {
		return houseAddress;
	}
	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	@Override
	public String toString() {
		return "HouseBean [id=" + id + ", houseAddress=" + houseAddress + ", houseNo=" + houseNo + "]";
	}
	
}
