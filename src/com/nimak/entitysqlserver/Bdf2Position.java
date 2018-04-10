package com.nimak.entitysqlserver;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * BDF2_POSITION:
 */
@Entity
@Table(name = "BDF2_POSITION")
public class Bdf2Position implements Serializable {

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
	 * create_date_:
	 */
	@PropertyDef(label = "create_date_", description = "create_date_:")
	private Date createDate;

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

	public Bdf2Position() {
		super();
	}

	public Bdf2Position(String id, String companyId, Date createDate,
			String desc, String name) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.createDate = createDate;
		this.desc = desc;
		this.name = name;
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

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date_")
	public Date getCreateDate() {
		return createDate;
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
		return "Bdf2Position [id=" + id + ",companyId=" + companyId
				+ ",createDate=" + createDate + ",desc=" + desc + ",name="
				+ name + "]";
	}

}
