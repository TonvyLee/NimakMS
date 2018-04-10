package com.nimak.entitysqlserver;

import java.io.Serializable;
import javax.persistence.*;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * BDF2_USER_DEPT:
 */
@Entity
@Table(name = "BDF2_USER_DEPT")
public class Bdf2UserDept implements Serializable {

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
	 * username_:
	 */
	@PropertyDef(label = "username_", description = "username_:")
	private String username;

	public Bdf2UserDept() {
		super();
	}

	public Bdf2UserDept(String id, String deptId, String username) {
		super();
		this.id = id;
		this.deptId = deptId;
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

	@Column(name = "dept_id_", length = 120, nullable = false)
	public String getDeptId() {
		return deptId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "username_", length = 120, nullable = false)
	public String getUsername() {
		return username;
	}

	public String toString() {
		return "Bdf2UserDept [id=" + id + ",deptId=" + deptId + ",username="
				+ username + "]";
	}

}
