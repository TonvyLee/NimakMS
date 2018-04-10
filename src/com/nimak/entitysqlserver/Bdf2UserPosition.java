package com.nimak.entitysqlserver;

import java.io.Serializable;
import javax.persistence.*;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * BDF2_USER_POSITION:
 */
@Entity
@Table(name = "BDF2_USER_POSITION")
public class Bdf2UserPosition implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id_:
	 */
	@PropertyDef(label = "id_", description = "id_:")
	private String id;

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

	public Bdf2UserPosition() {
		super();
	}

	public Bdf2UserPosition(String id, String positionId, String username) {
		super();
		this.id = id;
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

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	@Column(name = "position_id_", length = 120, nullable = false)
	public String getPositionId() {
		return positionId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "username_", length = 120, nullable = false)
	public String getUsername() {
		return username;
	}

	public String toString() {
		return "Bdf2UserPosition [id=" + id + ",positionId=" + positionId
				+ ",username=" + username + "]";
	}

}
