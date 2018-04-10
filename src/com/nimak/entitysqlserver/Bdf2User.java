package com.nimak.entitysqlserver;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * BDF2_USER:
 */
@Entity
@Table(name = "BDF2_USER")
public class Bdf2User implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * username_:
	 */
	@PropertyDef(label = "username_", description = "username_:")
	private String username;

	/**
	 * address_:
	 */
	@PropertyDef(label = "address_", description = "address_:")
	private String address;

	/**
	 * administrator_:
	 */
	@PropertyDef(label = "administrator_", description = "administrator_:")
	private boolean administrator;

	/**
	 * birthday_:
	 */
	@PropertyDef(label = "birthday_", description = "birthday_:")
	private Date birthday;

	/**
	 * cname_:
	 */
	@PropertyDef(label = "cname_", description = "cname_:")
	private String cname;

	/**
	 * company_id_:
	 */
	@PropertyDef(label = "company_id_", description = "company_id_:")
	private String companyId;

	/**
	 * create_date_:
	 */
	@PropertyDef(label = "create_date_", description = "create_date_:")
	private Date createDate;

	/**
	 * email_:
	 */
	@PropertyDef(label = "email_", description = "email_:")
	private String email;

	/**
	 * enabled_:
	 */
	@PropertyDef(label = "enabled_", description = "enabled_:")
	private boolean enabled;

	/**
	 * ename_:
	 */
	@PropertyDef(label = "ename_", description = "ename_:")
	private String ename;

	/**
	 * male_:
	 */
	@PropertyDef(label = "male_", description = "male_:")
	private boolean male;

	/**
	 * mobile_:
	 */
	@PropertyDef(label = "mobile_", description = "mobile_:")
	private String mobile;

	/**
	 * password_:
	 */
	@PropertyDef(label = "password_", description = "password_:")
	private String password;

	/**
	 * salt_:
	 */
	@PropertyDef(label = "salt_", description = "salt_:")
	private String salt;

	public Bdf2User() {
		super();
	}

	public Bdf2User(String username, String address, boolean administrator,
			Date birthday, String cname, String companyId, Date createDate,
			String email, boolean enabled, String ename, boolean male,
			String mobile, String password, String salt) {
		super();
		this.username = username;
		this.address = address;
		this.administrator = administrator;
		this.birthday = birthday;
		this.cname = cname;
		this.companyId = companyId;
		this.createDate = createDate;
		this.email = email;
		this.enabled = enabled;
		this.ename = ename;
		this.male = male;
		this.mobile = mobile;
		this.password = password;
		this.salt = salt;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Id
	@Column(name = "username_", length = 120, nullable = false)
	public String getUsername() {
		return username;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "address_", length = 240)
	public String getAddress() {
		return address;
	}

	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}

	@Column(name = "administrator_", nullable = false)
	public boolean isAdministrator() {
		return administrator;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birthday_")
	public Date getBirthday() {
		return birthday;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Column(name = "cname_", length = 120, nullable = false)
	public String getCname() {
		return cname;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	@Column(name = "company_id_", length = 120, nullable = false)
	public String getCompanyId() {
		return companyId;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date_")
	public Date getCreateDate() {
		return createDate;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "email_", length = 120)
	public String getEmail() {
		return email;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name = "enabled_", nullable = false)
	public boolean isEnabled() {
		return enabled;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Column(name = "ename_", length = 120)
	public String getEname() {
		return ename;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	@Column(name = "male_", nullable = false)
	public boolean isMale() {
		return male;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "mobile_", length = 40)
	public String getMobile() {
		return mobile;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "password_", length = 140, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Column(name = "salt_", length = 20, nullable = false)
	public String getSalt() {
		return salt;
	}

	public String toString() {
		return "Bdf2User [username=" + username + ",address=" + address
				+ ",administrator=" + administrator + ",birthday=" + birthday
				+ ",cname=" + cname + ",companyId=" + companyId
				+ ",createDate=" + createDate + ",email=" + email + ",enabled="
				+ enabled + ",ename=" + ename + ",male=" + male + ",mobile="
				+ mobile + ",password=" + password + ",salt=" + salt + "]";
	}

}
