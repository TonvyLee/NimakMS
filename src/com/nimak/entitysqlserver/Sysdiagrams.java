package com.nimak.entitysqlserver;

import java.io.Serializable;
import javax.persistence.*;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * sysdiagrams:
 */
@Entity
@Table(name = "sysdiagrams")
public class Sysdiagrams implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * name:
	 */
	@PropertyDef(label = "name", description = "name:")
	private String name;

	/**
	 * principal_id:
	 */
	@PropertyDef(label = "principal_id", description = "principal_id:")
	private int principalId;

	/**
	 * diagram_id:
	 */
	@PropertyDef(label = "diagram_id", description = "diagram_id:")
	private int diagramId;

	/**
	 * version:
	 */
	@PropertyDef(label = "version", description = "version:")
	private int version;

	/**
	 * definition:
	 */
	@PropertyDef(label = "definition", description = "definition:")
	private byte[] definition;

	public Sysdiagrams() {
		super();
	}

	public Sysdiagrams(String name, int principalId, int diagramId,
			int version, byte[] definition) {
		super();
		this.name = name;
		this.principalId = principalId;
		this.diagramId = diagramId;
		this.version = version;
		this.definition = definition;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "name", length = 128, unique = true, nullable = false)
	public String getName() {
		return name;
	}

	public void setPrincipalId(int principalId) {
		this.principalId = principalId;
	}

	@Column(name = "principal_id", unique = true, nullable = false)
	public int getPrincipalId() {
		return principalId;
	}

	public void setDiagramId(int diagramId) {
		this.diagramId = diagramId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "diagram_id", nullable = false)
	public int getDiagramId() {
		return diagramId;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Column(name = "version")
	public int getVersion() {
		return version;
	}

	public void setDefinition(byte[] definition) {
		this.definition = definition;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "definition", columnDefinition = "BLOB")
	public byte[] getDefinition() {
		return definition;
	}

	public String toString() {
		return "Sysdiagrams [name=" + name + ",principalId=" + principalId
				+ ",diagramId=" + diagramId + ",version=" + version
				+ ",definition=" + definition + "]";
	}

}
