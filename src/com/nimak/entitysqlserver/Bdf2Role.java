package com.nimak.entitysqlserver;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * BDF2_ROLE:
 */
@Entity
@Table(name = "BDF2_ROLE")
public class Bdf2Role implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id_:
	 */
	@PropertyDef(label = "id_", description = "id_:")
	private String id;

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
	 * create_user_:
	 */
	@PropertyDef(label = "create_user_", description = "create_user_:")
	private String createUser;

	/**
	 * desc_:
	 */
	@PropertyDef(label = "desc_", description = "desc_:")
	private String desc;

	/**
	 * enabled_:
	 */
	@PropertyDef(label = "enabled_", description = "enabled_:")
	private boolean enabled;

	/**
	 * name_:
	 */
	@PropertyDef(label = "name_", description = "name_:")
	private String name;

	/**
	 * parent_id_:
	 */
	@PropertyDef(label = "parent_id_", description = "parent_id_:")
	private String parentId;

	/**
	 * type_:
	 */
	@PropertyDef(label = "type_", description = "type_:")
	private String type;

	public Bdf2Role() {
		super();
	}

	public Bdf2Role(String id, String companyId, Date createDate,
			String createUser, String desc, boolean enabled, String name,
			String parentId, String type) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.createDate = createDate;
		this.createUser = createUser;
		this.desc = desc;
		this.enabled = enabled;
		this.name = name;
		this.parentId = parentId;
		this.type = type;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "id_", length = 120, nullable = false)
	public String getId() {
		return id;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	@Column(name = "company_id_", length = 120)
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

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "create_user_", length = 120)
	public String getCreateUser() {
		return createUser;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "desc_", length = 240)
	public String getDesc() {
		return desc;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name = "enabled_")
	public boolean isEnabled() {
		return enabled;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "name_", length = 120)
	public String getName() {
		return name;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Column(name = "parent_id_", length = 120)
	public String getParentId() {
		return parentId;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "type_", length = 20)
	public String getType() {
		return type;
	}

	public String toString() {
		return "Bdf2Role [id=" + id + ",companyId=" + companyId
				+ ",createDate=" + createDate + ",createUser=" + createUser
				+ ",desc=" + desc + ",enabled=" + enabled + ",name=" + name
				+ ",parentId=" + parentId + ",type=" + type + "]";
	}

}
