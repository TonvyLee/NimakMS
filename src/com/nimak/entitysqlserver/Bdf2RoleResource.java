package com.nimak.entitysqlserver;

import java.io.Serializable;
import javax.persistence.*;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * BDF2_ROLE_RESOURCE:
 */
@Entity
@Table(name = "BDF2_ROLE_RESOURCE")
public class Bdf2RoleResource implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id_:
	 */
	@PropertyDef(label = "id_", description = "id_:")
	private String id;

	/**
	 * package_id_:
	 */
	@PropertyDef(label = "package_id_", description = "package_id_:")
	private String packageId;

	/**
	 * role_id_:
	 */
	@PropertyDef(label = "role_id_", description = "role_id_:")
	private String roleId;

	/**
	 * url_id_:
	 */
	@PropertyDef(label = "url_id_", description = "url_id_:")
	private String urlId;

	public Bdf2RoleResource() {
		super();
	}

	public Bdf2RoleResource(String id, String packageId, String roleId,
			String urlId) {
		super();
		this.id = id;
		this.packageId = packageId;
		this.roleId = roleId;
		this.urlId = urlId;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "id_", length = 120, nullable = false)
	public String getId() {
		return id;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	@Column(name = "package_id_", length = 120)
	public String getPackageId() {
		return packageId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name = "role_id_", length = 120)
	public String getRoleId() {
		return roleId;
	}

	public void setUrlId(String urlId) {
		this.urlId = urlId;
	}

	@Column(name = "url_id_", length = 120)
	public String getUrlId() {
		return urlId;
	}

	public String toString() {
		return "Bdf2RoleResource [id=" + id + ",packageId=" + packageId
				+ ",roleId=" + roleId + ",urlId=" + urlId + "]";
	}

}
