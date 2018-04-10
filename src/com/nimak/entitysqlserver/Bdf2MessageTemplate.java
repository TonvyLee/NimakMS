package com.nimak.entitysqlserver;

import java.io.Serializable;
import javax.persistence.*;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * BDF2_MESSAGE_TEMPLATE:
 */
@Entity
@Table(name = "BDF2_MESSAGE_TEMPLATE")
public class Bdf2MessageTemplate implements Serializable {

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
	 * content_:
	 */
	@PropertyDef(label = "content_", description = "content_:")
	private String content;

	/**
	 * name_:
	 */
	@PropertyDef(label = "name_", description = "name_:")
	private String name;

	/**
	 * type_:
	 */
	@PropertyDef(label = "type_", description = "type_:")
	private String type;

	public Bdf2MessageTemplate() {
		super();
	}

	public Bdf2MessageTemplate(String id, String companyId, String content,
			String name, String type) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.content = content;
		this.name = name;
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

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "content_", length = 1000)
	public String getContent() {
		return content;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "name_", length = 120)
	public String getName() {
		return name;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "type_", length = 120)
	public String getType() {
		return type;
	}

	public String toString() {
		return "Bdf2MessageTemplate [id=" + id + ",companyId=" + companyId
				+ ",content=" + content + ",name=" + name + ",type=" + type
				+ "]";
	}

}
