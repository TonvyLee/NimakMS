package com.nimak.entitysqlserver;

import java.io.Serializable;
import javax.persistence.*;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * BDF2_URL_COMPONENT:
 */
@Entity
@Table(name = "BDF2_URL_COMPONENT")
public class Bdf2UrlComponent implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id_:
	 */
	@PropertyDef(label = "id_", description = "id_:")
	private String id;

	/**
	 * authority_type_:
	 */
	@PropertyDef(label = "authority_type_", description = "authority_type_:")
	private String authorityType;

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

	/**
	 * component_id_:
	 */
	@PropertyDef(label = "component_id_", description = "component_id_:")
	private String componentId;

	public Bdf2UrlComponent() {
		super();
	}

	public Bdf2UrlComponent(String id, String authorityType, String roleId,
			String urlId, String componentId) {
		super();
		this.id = id;
		this.authorityType = authorityType;
		this.roleId = roleId;
		this.urlId = urlId;
		this.componentId = componentId;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "id_", length = 120, nullable = false)
	public String getId() {
		return id;
	}

	public void setAuthorityType(String authorityType) {
		this.authorityType = authorityType;
	}

	@Column(name = "authority_type_", length = 20, nullable = false)
	public String getAuthorityType() {
		return authorityType;
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

	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}

	@Column(name = "component_id_", length = 120)
	public String getComponentId() {
		return componentId;
	}

	public String toString() {
		return "Bdf2UrlComponent [id=" + id + ",authorityType=" + authorityType
				+ ",roleId=" + roleId + ",urlId=" + urlId + ",componentId="
				+ componentId + "]";
	}

}
