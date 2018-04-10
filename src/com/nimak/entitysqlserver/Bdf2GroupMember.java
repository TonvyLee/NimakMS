package com.nimak.entitysqlserver;

import java.io.Serializable;
import javax.persistence.*;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * BDF2_GROUP_MEMBER:
 */
@Entity
@Table(name = "BDF2_GROUP_MEMBER")
public class Bdf2GroupMember implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id_:
	 */
	@PropertyDef(label = "id_", description = "id_:")
	private String id;

	/**
	 * dept_id_:
	 */
	@PropertyDef(label = "dept_id_", description = "dept_id_:")
	private String deptId;

	/**
	 * group_id_:
	 */
	@PropertyDef(label = "group_id_", description = "group_id_:")
	private String groupId;

	/**
	 * position_id_:
	 */
	@PropertyDef(label = "position_id_", description = "position_id_:")
	private String positionId;

	/**
	 * username_:
	 */
	@PropertyDef(label = "username_", description = "username_:")
	private String username;

	public Bdf2GroupMember() {
		super();
	}

	public Bdf2GroupMember(String id, String deptId, String groupId,
			String positionId, String username) {
		super();
		this.id = id;
		this.deptId = deptId;
		this.groupId = groupId;
		this.positionId = positionId;
		this.username = username;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "id_", length = 120, nullable = false)
	public String getId() {
		return id;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Column(name = "dept_id_", length = 120)
	public String getDeptId() {
		return deptId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	@Column(name = "group_id_", length = 120)
	public String getGroupId() {
		return groupId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	@Column(name = "position_id_", length = 120)
	public String getPositionId() {
		return positionId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "username_", length = 120)
	public String getUsername() {
		return username;
	}

	public String toString() {
		return "Bdf2GroupMember [id=" + id + ",deptId=" + deptId + ",groupId="
				+ groupId + ",positionId=" + positionId + ",username="
				+ username + "]";
	}

}
