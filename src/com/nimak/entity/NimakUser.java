package com.nimak.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bstek.bdf2.core.business.AbstractUser;
import com.bstek.bdf2.core.business.IDept;
import com.bstek.bdf2.core.business.IPosition;
import com.bstek.bdf2.core.model.Group;
import com.bstek.bdf2.core.model.Role;

/**
 * NIMAK_USER:
 */
//@Entity
//@Table(name = "NIMAK_USER")
public class NimakUser extends AbstractUser implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * USERNAME:
	 */
//	@PropertyDef(label = "USERNAME", description = "USERNAME:")
	private String username;

	/**
	 * ADDRESS:
	 */
//	@PropertyDef(label = "ADDRESS", description = "ADDRESS:")
	private String address;

	/**
	 * ADMINISTRATOR:
	 */
//	@PropertyDef(label = "ADMINISTRATOR", description = "ADMINISTRATOR:")
	private BigDecimal administrator;

	/**
	 * BIRTHDAY:
	 */
//	@PropertyDef(label = "BIRTHDAY", description = "BIRTHDAY:")
	private Date birthday;

	/**
	 * CNAME:
	 */
//	@PropertyDef(label = "CNAME", description = "CNAME:")
	private String cname;

	/**
	 * CREATEDATE:
	 */
//	@PropertyDef(label = "CREATEDATE", description = "CREATEDATE:")
	private Date createdate;

	/**
	 * EMAIL:
	 */
//	@PropertyDef(label = "EMAIL", description = "EMAIL:")
	private String email;

	/**
	 * ENABLED:
	 */
//	@PropertyDef(label = "ENABLED", description = "ENABLED:")
	private BigDecimal enabled;

	/**
	 * ENAME:
	 */
//	@PropertyDef(label = "ENAME", description = "ENAME:")
	private String ename;

	/**
	 * MALE:
	 */
//	@PropertyDef(label = "MALE", description = "MALE:")
	private BigDecimal male;

	/**
	 * MOBILE:
	 */
//	@PropertyDef(label = "MOBILE", description = "MOBILE:")
	private String mobile;

	/**
	 * PASSWORD:
	 */
//	@PropertyDef(label = "PASSWORD", description = "PASSWORD:")
	private String password;
	private List<IDept> depts;
	private List<IPosition> positions;
	private List<Role> roles;
	private List<Group> groups;

	public NimakUser() {
		super();
	}

	public NimakUser(String username, String address, BigDecimal administrator,
			Date birthday, String cname, Date createdate, String email,
			BigDecimal enabled, String ename, BigDecimal male, String mobile,
			String password) {
		super();
		this.username = username;
		this.address = address;
		this.administrator = administrator;
		this.birthday = birthday;
		this.cname = cname;
		this.createdate = createdate;
		this.email = email;
		this.enabled = enabled;
		this.ename = ename;
		this.male = male;
		this.mobile = mobile;
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Id
	@Column(name = "USERNAME", length = 120, nullable = false)
	public String getUsername() {
		return username;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "ADDRESS", length = 240)
	public String getAddress() {
		return address;
	}

	public void setAdministrator(BigDecimal administrator) {
		this.administrator = administrator;
	}

	@Column(name = "ADMINISTRATOR")
	public BigDecimal getAdministrator() {
		return administrator;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BIRTHDAY")
	public Date getBirthday() {
		return birthday;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Column(name = "CNAME", length = 120)
	public String getCname() {
		return cname;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATEDATE")
	public Date getCreatedate() {
		return createdate;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "EMAIL", length = 120)
	public String getEmail() {
		return email;
	}

	public void setEnabled(BigDecimal enabled) {
		this.enabled = enabled;
	}

	@Column(name = "ENABLED")
	public BigDecimal getEnabled() {
		return enabled;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Column(name = "ENAME", length = 120)
	public String getEname() {
		return ename;
	}

	public void setMale(BigDecimal male) {
		this.male = male;
	}

	@Column(name = "MALE")
	public BigDecimal getMale() {
		return male;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "MOBILE", length = 40)
	public String getMobile() {
		return mobile;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "PASSWORD", length = 140)
	public String getPassword() {
		return password;
	}

	public String toString() {
		return "NimakUser [username=" + username + ",address=" + address
				+ ",administrator=" + administrator + ",birthday=" + birthday
				+ ",cname=" + cname + ",createdate=" + createdate + ",email="
				+ email + ",enabled=" + enabled + ",ename=" + ename + ",male="
				+ male + ",mobile=" + mobile + ",password=" + password + "]";
	}
	
	@Override
	public List<IDept> getDepts() {
		// TODO Auto-generated method stub
		return depts;
	}

	@Override
	public List<Group> getGroups() {
		// TODO Auto-generated method stub
		return groups;
	}

	@Override
	public Map<String, Object> getMetadata() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IPosition> getPositions() {
		// TODO Auto-generated method stub
		return positions;
	}

	@Override
	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		return roles;
	}

	@Override
	public boolean isAdministrator() {
		// TODO Auto-generated method stub
		if (new BigDecimal(1).equals(this.administrator)) {
			return true;
		}else {
			return false;
		}	
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		if (new BigDecimal(1).equals(this.enabled)) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String getCompanyId() {
		// TODO Auto-generated method stub
		return "nimak1";
	}

	public void setPositions(List<IPosition> positions) {
		this.positions = positions;
	}
	public void setDepts(List<IDept> depts) {
		this.depts = depts;
	}
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
