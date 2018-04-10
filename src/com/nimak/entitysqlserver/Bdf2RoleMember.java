package com.nimak.entitysqlserver;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * BDF2_ROLE_MEMBER:
 */
@Entity
@Table(name = "BDF2_ROLE_MEMBER")
public class Bdf2RoleMember implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id_:
	 */
	@PropertyDef(label = "id_", description = "id_:")
	private String id;

	/**
	 * create_date_:
	 */
	@PropertyDef(label = "create_date_", description = "create_date_:")
	private Date createDate;

	/**
	 * dept_id_:
	 */
	@PropertyDef(label = "dept_id_", description = "dept_id_:")
	private String deptId;

	/**
	 * granted_:
	 */
	@PropertyDef(label = "granted_", description = "granted_:")
	private boolean granted;

	/**
	 * position_id_:
	 */
	@PropertyDef(label = "position_id_", description = "position_id_:")
	private String positionId;

	/**
	 * role_id_:
	 */
	@PropertyDef(label = "role_id_", description = "role_id_:")
	private String roleId;

	/**
	 * username_:
	 */
	@PropertyDef(label = "username_", description = "username_:")
	private String username;

	/**
	 * group_id_:
	 */
	@PropertyDef(label = "group_id_", description = "group_id_:")
	private String groupId;

	public Bdf2RoleMember() {
		super();
	}

	public Bdf2RoleMember(String id, Date createDate, String deptId,
			boolean granted, String positionId, String roleId, String username,
			String groupId) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.deptId = deptId;
		this.granted = granted;
		this.positionId = positionId;
		this.roleId = roleId;
		this.username = username;
		this.groupId = groupId;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "id_", length = 120, nullable = false)
	public String getId() {
		return id;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date_")
	public Date getCreateDate() {
		return createDate;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Column(name = "dept_id_", length = 120)
	public String getDeptId() {
		return deptId;
	}

	public void setGranted(boolean granted) {
		this.granted = granted;
	}

	@Column(name = "granted_")
	public boolean isGranted() {
		return granted;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	@Column(name = "position_id_", length = 120)
	public String getPositionId() {
		return positionId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name = "role_id_", length = 120)
	public String getRoleId() {
		return roleId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "username_", length = 120)
	public String getUsername() {
		return username;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	@Column(name = "group_id_", length = 120)
	public String getGroupId() {
		return groupId;
	}

	public String toString() {
		return "Bdf2RoleMember [id=" + id + ",createDate=" + createDate
				+ ",deptId=" + deptId + ",granted=" + granted + ",positionId="
				+ positionId + ",roleId=" + roleId + ",username=" + username
				+ ",groupId=" + groupId + "]";
	}

}
