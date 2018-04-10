package com.nimak.entitysqlserver;

import java.io.Serializable;
import javax.persistence.*;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * BDF2_COMPONENT:
 */
@Entity
@Table(name = "BDF2_COMPONENT")
public class Bdf2Component implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id_:
	 */
	@PropertyDef(label = "id_", description = "id_:")
	private String id;

	/**
	 * component_id_:
	 */
	@PropertyDef(label = "component_id_", description = "component_id_:")
	private String componentId;

	/**
	 * desc_:
	 */
	@PropertyDef(label = "desc_", description = "desc_:")
	private String desc;

	public Bdf2Component() {
		super();
	}

	public Bdf2Component(String id, String componentId, String desc) {
		super();
		this.id = id;
		this.componentId = componentId;
		this.desc = desc;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "id_", length = 120, nullable = false)
	public String getId() {
		return id;
	}

	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}

	@Column(name = "component_id_", length = 120, nullable = false)
	public String getComponentId() {
		return componentId;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "desc_", length = 240)
	public String getDesc() {
		return desc;
	}

	public String toString() {
		return "Bdf2Component [id=" + id + ",componentId=" + componentId
				+ ",desc=" + desc + "]";
	}

}
