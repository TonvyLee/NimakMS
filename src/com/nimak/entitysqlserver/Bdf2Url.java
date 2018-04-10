package com.nimak.entitysqlserver;

import java.io.Serializable;
import javax.persistence.*;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * BDF2_URL:
 */
@Entity
@Table(name = "BDF2_URL")
public class Bdf2Url implements Serializable {

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
	 * desc_:
	 */
	@PropertyDef(label = "desc_", description = "desc_:")
	private String desc;

	/**
	 * for_navigation_:
	 */
	@PropertyDef(label = "for_navigation_", description = "for_navigation_:")
	private boolean forNavigation;

	/**
	 * icon_:
	 */
	@PropertyDef(label = "icon_", description = "icon_:")
	private String icon;

	/**
	 * name_:
	 */
	@PropertyDef(label = "name_", description = "name_:")
	private String name;

	/**
	 * order_:
	 */
	@PropertyDef(label = "order_", description = "order_:")
	private int order;

	/**
	 * parent_id_:
	 */
	@PropertyDef(label = "parent_id_", description = "parent_id_:")
	private String parentId;

	/**
	 * system_id_:
	 */
	@PropertyDef(label = "system_id_", description = "system_id_:")
	private String systemId;

	/**
	 * url_:
	 */
	@PropertyDef(label = "url_", description = "url_:")
	private String url;

	public Bdf2Url() {
		super();
	}

	public Bdf2Url(String id, String companyId, String desc,
			boolean forNavigation, String icon, String name, int order,
			String parentId, String systemId, String url) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.desc = desc;
		this.forNavigation = forNavigation;
		this.icon = icon;
		this.name = name;
		this.order = order;
		this.parentId = parentId;
		this.systemId = systemId;
		this.url = url;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "id_", length = 120, nullable = false)
	public String getId() {
		return id;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	@Column(name = "company_id_", length = 120, nullable = false)
	public String getCompanyId() {
		return companyId;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "desc_", length = 240)
	public String getDesc() {
		return desc;
	}

	public void setForNavigation(boolean forNavigation) {
		this.forNavigation = forNavigation;
	}

	@Column(name = "for_navigation_", nullable = false)
	public boolean isForNavigation() {
		return forNavigation;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Column(name = "icon_", length = 240)
	public String getIcon() {
		return icon;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "name_", length = 120, nullable = false)
	public String getName() {
		return name;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Column(name = "order_")
	public int getOrder() {
		return order;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Column(name = "parent_id_", length = 120)
	public String getParentId() {
		return parentId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	@Column(name = "system_id_", length = 120)
	public String getSystemId() {
		return systemId;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "url_", length = 240)
	public String getUrl() {
		return url;
	}

	public String toString() {
		return "Bdf2Url [id=" + id + ",companyId=" + companyId + ",desc="
				+ desc + ",forNavigation=" + forNavigation + ",icon=" + icon
				+ ",name=" + name + ",order=" + order + ",parentId=" + parentId
				+ ",systemId=" + systemId + ",url=" + url + "]";
	}

}
