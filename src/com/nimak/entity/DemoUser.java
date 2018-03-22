package com.nimak.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

import com.bstek.bdf2.core.business.AbstractUser;
import com.bstek.bdf2.core.business.IDept;
import com.bstek.bdf2.core.business.IPosition;
import com.bstek.bdf2.core.model.Group;
import com.bstek.bdf2.core.model.Role;

/**
 * DEMO_USER:
 */
//@Entity
//@Table(name = "DEMO_USER")
public class DemoUser extends AbstractUser implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * USERNAME:
	 */
//	@PropertyDef(label = "USERNAME", description = "USERNAME:")
	private String username;

	/**
	 * PASSWORD:
	 */
//	@PropertyDef(label = "PASSWORD", description = "PASSWORD:")
	private String password;

	/**
	 * CNAME:
	 */
//	@PropertyDef(label = "CNAME", description = "CNAME:")
	private String cname;

	private List<IDept> depts;
	private List<IPosition> positions;
	private List<Role> roles;
	private List<Group> groups;

	public DemoUser() {
		super();
	}

	public DemoUser(String username, String password, String cname) {
		super();
		this.username = username;
		this.password = password;
		this.cname = cname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	//@Id
	//@Column(name = "USERNAME", length = 30, nullable = false)
	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//@Column(name = "PASSWORD", length = 30)
	public String getPassword() {
		return password;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	//@Column(name = "CNAME", length = 30)
	public String getCname() {
		return cname;
	}

	public String toString() {
		return "DemoUser [username=" + username + ",password=" + password
				+ ",cname=" + cname + "]";
	}

	public String getEname() {
		return cname;
	}

	/**
	 * 当前用户是否为系统管理员，如果这个属性返回true，那么就表示当前用户为系统管理员， 所有权限对其都不起作用，反之则不然。
	 * */
	public boolean isAdministrator() {
		return false;
	}

	/**
	 * 当前用户的手机号
	 * */
	public String getMobile() {
		return "13122112211";
	}

	/**
	 * 当前用户的email地址
	 * */
	public String getEmail() {
		return "test@sina.com";
	}

	/**
	 * 当前用户所在部门
	 * */
	public List<IDept> getDepts() {
		return depts;
	}

	/**
	 * 当前用户所拥有的岗位
	 * */
	public List<IPosition> getPositions() {
		return positions;
	}

	public void setPositions(List<IPosition> positions) {
		this.positions = positions;
	}

	public void setDepts(List<IDept> depts) {
		this.depts = depts;
	}

	/**
	 * 当前用户所拥有的角色，权限需要使用
	 * */
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	/**
	 * 当前用户所在群组
	 * */
	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	/**
	 * 用户的其它元数据信息，如果我们的应用用不到，可直接返回null
	 * */
	public Map<String, Object> getMetadata() {
		return null;
	}

	/**
	 * 判断当前用户是否可用，可以在用户来源信息中判断这里取值，如果返回false，那么该用户将不能登录
	 */
	public boolean isEnabled() {
		return true;
	}

	/**
	 * 当前用户所在公司ID，如果当前系统只给一家公司使用，这里返回一个固定值即可， 如果是基于SAAS系统，那么这里需要根据公司信息返回一个值
	 * */
	public String getCompanyId() {
		return "nimak1";
	}

}
