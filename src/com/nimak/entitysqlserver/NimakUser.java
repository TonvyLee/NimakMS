package com.nimak.entitysqlserver;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * NIMAK_USER:
 */
@Entity
@Table(name = "NIMAK_USER")
public class NimakUser implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * username:
	 */
	@PropertyDef(label = "username", description = "username:")
	private String username;

	/**
	 * address:
	 */
	@PropertyDef(label = "address", description = "address:")
	private String address;

	/**
	 * administrator:
	 */
	@PropertyDef(label = "administrator", description = "administrator:")
	private boolean administrator;

	/**
	 * birthday:
	 */
	@PropertyDef(label = "birthday", description = "birthday:")
	private Date birthday;

	/**
	 * cname:
	 */
	@PropertyDef(label = "cname", description = "cname:")
	private String cname;

	/**
	 * createdate:
	 */
	@PropertyDef(label = "createdate", description = "createdate:")
	private Date createdate;

	/**
	 * email:
	 */
	@PropertyDef(label = "email", description = "email:")
	private String email;

	/**
	 * enabled:
	 */
	@PropertyDef(label = "enabled", description = "enabled:")
	private boolean enabled;

	/**
	 * ename:
	 */
	@PropertyDef(label = "ename", description = "ename:")
	private String ename;

	/**
	 * male:
	 */
	@PropertyDef(label = "male", description = "male:")
	private boolean male;

	/**
	 * mobile:
	 */
	@PropertyDef(label = "mobile", description = "mobile:")
	private String mobile;

	/**
	 * password:
	 */
	@PropertyDef(label = "password", description = "password:")
	private String password;

	public NimakUser() {
		super();
	}

	public NimakUser(String username, String address, boolean administrator,
			Date birthday, String cname, Date createdate, String email,
			boolean enabled, String ename, boolean male, String mobile,
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

	@Column(name = "username", length = 60, nullable = false)
	public String getUsername() {
		return username;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "address", length = 120)
	public String getAddress() {
		return address;
	}

	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}

	@Column(name = "administrator")
	public boolean isAdministrator() {
		return administrator;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birthday")
	public Date getBirthday() {
		return birthday;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Column(name = "cname", length = 60)
	public String getCname() {
		return cname;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdate", nullable = false)
	public Date getCreatedate() {
		return createdate;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "email", length = 60)
	public String getEmail() {
		return email;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name = "enabled")
	public boolean isEnabled() {
		return enabled;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Column(name = "ename", length = 60)
	public String getEname() {
		return ename;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	@Column(name = "male")
	public boolean isMale() {
		return male;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "mobile", length = 20)
	public String getMobile() {
		return mobile;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "password", length = 70)
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

}
