package com.nimak.entitysqlserver;

import java.io.Serializable;
import javax.persistence.*;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * BDF2_COMPANY:
 */
@Entity
@Table(name = "BDF2_COMPANY")
public class Bdf2Company implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id_:
	 */
	@PropertyDef(label = "id_", description = "id_:")
	private String id;

	/**
	 * desc_:
	 */
	@PropertyDef(label = "desc_", description = "desc_:")
	private String desc;

	/**
	 * name_:
	 */
	@PropertyDef(label = "name_", description = "name_:")
	private String name;

	public Bdf2Company() {
		super();
	}

	public Bdf2Company(String id, String desc, String name) {
		super();
		this.id = id;
		this.desc = desc;
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "id_", length = 120, nullable = false)
	public String getId() {
		return id;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "desc_", length = 240)
	public String getDesc() {
		return desc;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "name_", length = 120)
	public String getName() {
		return name;
	}

	public String toString() {
		return "Bdf2Company [id=" + id + ",desc=" + desc + ",name=" + name
				+ "]";
	}

}
