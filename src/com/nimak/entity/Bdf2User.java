package com.nimak.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
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
	 * USERNAME_:
	 */
	@PropertyDef(label = "USERNAME_", description = "USERNAME_:")
	private String username;

	/**
	 * ADDRESS_:
	 */
	@PropertyDef(label = "ADDRESS_", description = "ADDRESS_:")
	private String address;

	/**
	 * ADMINISTRATOR_:
	 */
	@PropertyDef(label = "ADMINISTRATOR_", description = "ADMINISTRATOR_:")
	private BigDecimal administrator;

	/**
	 * BIRTHDAY_:
	 */
	@PropertyDef(label = "BIRTHDAY_", description = "BIRTHDAY_:")
	private Date birthday;

	/**
	 * CNAME_:
	 */
	@PropertyDef(label = "CNAME_", description = "CNAME_:")
	private String cname;

	/**
	 * COMPANY_ID_:
	 */
	@PropertyDef(label = "COMPANY_ID_", description = "COMPANY_ID_:")
	private String companyId;

	/**
	 * CREATE_DATE_:
	 */
	@PropertyDef(label = "CREATE_DATE_", description = "CREATE_DATE_:")
	private Date createDate;

	/**
	 * EMAIL_:
	 */
	@PropertyDef(label = "EMAIL_", description = "EMAIL_:")
	private String email;

	/**
	 * ENABLED_:
	 */
	@PropertyDef(label = "ENABLED_", description = "ENABLED_:")
	private BigDecimal enabled;

	/**
	 * ENAME_:
	 */
	@PropertyDef(label = "ENAME_", description = "ENAME_:")
	private String ename;

	/**
	 * MALE_:
	 */
	@PropertyDef(label = "MALE_", description = "MALE_:")
	private BigDecimal male;

	/**
	 * MOBILE_:
	 */
	@PropertyDef(label = "MOBILE_", description = "MOBILE_:")
	private String mobile;

	/**
	 * PASSWORD_:
	 */
	@PropertyDef(label = "PASSWORD_", description = "PASSWORD_:")
	private String password;

	/**
	 * SALT_:
	 */
	@PropertyDef(label = "SALT_", description = "SALT_:")
	private String salt;

	public Bdf2User() {
		super();
	}

	public Bdf2User(String username, String address, BigDecimal administrator,
			Date birthday, String cname, String companyId, Date createDate,
			String email, BigDecimal enabled, String ename, BigDecimal male,
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
	@Column(name = "USERNAME_", length = 120, nullable = false)
	public String getUsername() {
		return username;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "ADDRESS_", length = 240)
	public String getAddress() {
		return address;
	}

	public void setAdministrator(BigDecimal administrator) {
		this.administrator = administrator;
	}

	@Column(name = "ADMINISTRATOR_", nullable = false)
	public BigDecimal getAdministrator() {
		return administrator;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BIRTHDAY_")
	public Date getBirthday() {
		return birthday;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Column(name = "CNAME_", length = 120, nullable = false)
	public String getCname() {
		return cname;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	@Column(name = "COMPANY_ID_", length = 120, nullable = false)
	public String getCompanyId() {
		return companyId;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE_")
	public Date getCreateDate() {
		return createDate;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "EMAIL_", length = 120)
	public String getEmail() {
		return email;
	}

	public void setEnabled(BigDecimal enabled) {
		this.enabled = enabled;
	}

	@Column(name = "ENABLED_", nullable = false)
	public BigDecimal getEnabled() {
		return enabled;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Column(name = "ENAME_", length = 120)
	public String getEname() {
		return ename;
	}

	public void setMale(BigDecimal male) {
		this.male = male;
	}

	@Column(name = "MALE_", nullable = false)
	public BigDecimal getMale() {
		return male;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "MOBILE_", length = 40)
	public String getMobile() {
		return mobile;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "PASSWORD_", length = 140, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Column(name = "SALT_", length = 20, nullable = false)
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
