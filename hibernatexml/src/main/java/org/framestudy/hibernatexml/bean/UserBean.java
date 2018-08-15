package org.framestudy.hibernatexml.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7037091124811989776L;

	private Long id;
	private String loginName;
	private String userName;
	private String password;
	private Date createTime;
	private Date updateTime;
	private Integer version;
	/**
	 * 单向关联
	 */
	private UserInfoBean userInfo;
	/**
	 * 单向关联
	 */
	private Set<HouseBean> houses;
	
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserBean(Long id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public UserInfoBean getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfoBean userInfo) {
		this.userInfo = userInfo;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Set<HouseBean> getHouses() {
		return houses;
	}
	public void setHouses(Set<HouseBean> houses) {
		this.houses = houses;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", loginName=" + loginName + ", userName=" + userName + ", password=" + password
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", version=" + version + ", userInfo="
				+ userInfo + ", houses=" + houses + "]";
	}
}
