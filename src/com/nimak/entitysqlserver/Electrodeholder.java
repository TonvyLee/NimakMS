package com.nimak.entitysqlserver;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * ELECTRODEHOLDER:
 */
@Entity
@Table(name = "ELECTRODEHOLDER")
public class Electrodeholder implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * shank_drawingno:
	 */
	@PropertyDef(label = "shank_drawingno", description = "shank_drawingno:")
	private String shankDrawingno;

	/**
	 * shank_material:
	 */
	@PropertyDef(label = "shank_material", description = "shank_material:")
	private String shankMaterial;

	/**
	 * shank_taper:
	 */
	@PropertyDef(label = "shank_taper", description = "shank_taper:")
	private String shankTaper;

	/**
	 * shank_type:
	 */
	@PropertyDef(label = "shank_type", description = "shank_type:")
	private String shankType;

	/**
	 * shank_diameter:
	 */
	@PropertyDef(label = "shank_diameter", description = "shank_diameter:")
	private BigDecimal shankDiameter;

	/**
	 * shank_angel_1:
	 */
	@PropertyDef(label = "shank_angel_1", description = "shank_angel_1:")
	private String shankAngel1;

	/**
	 * shank_radius_1:
	 */
	@PropertyDef(label = "shank_radius_1", description = "shank_radius_1:")
	private BigDecimal shankRadius1;

	/**
	 * shank_length_s1:
	 */
	@PropertyDef(label = "shank_length_s1", description = "shank_length_s1:")
	private BigDecimal shankLengthS1;

	/**
	 * shank_angel_2:
	 */
	@PropertyDef(label = "shank_angel_2", description = "shank_angel_2:")
	private String shankAngel2;

	/**
	 * shank_radius_2:
	 */
	@PropertyDef(label = "shank_radius_2", description = "shank_radius_2:")
	private BigDecimal shankRadius2;

	/**
	 * shank_length_s2:
	 */
	@PropertyDef(label = "shank_length_s2", description = "shank_length_s2:")
	private BigDecimal shankLengthS2;

	/**
	 * shank_angel_3:
	 */
	@PropertyDef(label = "shank_angel_3", description = "shank_angel_3:")
	private String shankAngel3;

	/**
	 * shank_radius_3:
	 */
	@PropertyDef(label = "shank_radius_3", description = "shank_radius_3:")
	private BigDecimal shankRadius3;

	/**
	 * shank_length_s3:
	 */
	@PropertyDef(label = "shank_length_s3", description = "shank_length_s3:")
	private BigDecimal shankLengthS3;

	/**
	 * shank_standard:
	 */
	@PropertyDef(label = "shank_standard", description = "shank_standard:")
	private BigDecimal shankStandard;

	/**
	 * shank_usestate:
	 */
	@PropertyDef(label = "shank_usestate", description = "shank_usestate:")
	private String shankUsestate;

	/**
	 * shank_designer:
	 */
	@PropertyDef(label = "shank_designer", description = "shank_designer:")
	private String shankDesigner;

	/**
	 * shank_designdate:
	 */
	@PropertyDef(label = "shank_designdate", description = "shank_designdate:")
	private Date shankDesigndate;

	/**
	 * arm_techchange:
	 */
	@PropertyDef(label = "arm_techchange", description = "arm_techchange:")
	private String armTechchange;

	/**
	 * attached_page:
	 */
	@PropertyDef(label = "attached_page", description = "attached_page:")
	private String attachedPage;

	/**
	 * shank_customer:
	 */
	@PropertyDef(label = "shank_customer", description = "shank_customer:")
	private String shankCustomer;

	/**
	 * shank_remark:
	 */
	@PropertyDef(label = "shank_remark", description = "shank_remark:")
	private String shankRemark;

	/**
	 * shank_code:
	 */
	@PropertyDef(label = "shank_code", description = "shank_code:")
	private String shankCode;

	/**
	 * id:
	 */
	@PropertyDef(label = "id", description = "id:")
	private String id;

	public Electrodeholder() {
		super();
	}

	public Electrodeholder(String shankDrawingno, String shankMaterial,
			String shankTaper, String shankType, BigDecimal shankDiameter,
			String shankAngel1, BigDecimal shankRadius1,
			BigDecimal shankLengthS1, String shankAngel2,
			BigDecimal shankRadius2, BigDecimal shankLengthS2,
			String shankAngel3, BigDecimal shankRadius3,
			BigDecimal shankLengthS3, BigDecimal shankStandard,
			String shankUsestate, String shankDesigner, Date shankDesigndate,
			String armTechchange, String attachedPage, String shankCustomer,
			String shankRemark, String shankCode, String id) {
		super();
		this.shankDrawingno = shankDrawingno;
		this.shankMaterial = shankMaterial;
		this.shankTaper = shankTaper;
		this.shankType = shankType;
		this.shankDiameter = shankDiameter;
		this.shankAngel1 = shankAngel1;
		this.shankRadius1 = shankRadius1;
		this.shankLengthS1 = shankLengthS1;
		this.shankAngel2 = shankAngel2;
		this.shankRadius2 = shankRadius2;
		this.shankLengthS2 = shankLengthS2;
		this.shankAngel3 = shankAngel3;
		this.shankRadius3 = shankRadius3;
		this.shankLengthS3 = shankLengthS3;
		this.shankStandard = shankStandard;
		this.shankUsestate = shankUsestate;
		this.shankDesigner = shankDesigner;
		this.shankDesigndate = shankDesigndate;
		this.armTechchange = armTechchange;
		this.attachedPage = attachedPage;
		this.shankCustomer = shankCustomer;
		this.shankRemark = shankRemark;
		this.shankCode = shankCode;
		this.id = id;
	}

	public void setShankDrawingno(String shankDrawingno) {
		this.shankDrawingno = shankDrawingno;
	}

	@Column(name = "shank_drawingno", length = 20, nullable = false)
	public String getShankDrawingno() {
		return shankDrawingno;
	}

	public void setShankMaterial(String shankMaterial) {
		this.shankMaterial = shankMaterial;
	}

	@Column(name = "shank_material", length = 20, nullable = false)
	public String getShankMaterial() {
		return shankMaterial;
	}

	public void setShankTaper(String shankTaper) {
		this.shankTaper = shankTaper;
	}

	@Column(name = "shank_taper", length = 20, nullable = false)
	public String getShankTaper() {
		return shankTaper;
	}

	public void setShankType(String shankType) {
		this.shankType = shankType;
	}

	@Column(name = "shank_type", length = 10, nullable = false)
	public String getShankType() {
		return shankType;
	}

	public void setShankDiameter(BigDecimal shankDiameter) {
		this.shankDiameter = shankDiameter;
	}

	@Column(name = "shank_diameter", nullable = false)
	public BigDecimal getShankDiameter() {
		return shankDiameter;
	}

	public void setShankAngel1(String shankAngel1) {
		this.shankAngel1 = shankAngel1;
	}

	@Column(name = "shank_angel_1", length = 20)
	public String getShankAngel1() {
		return shankAngel1;
	}

	public void setShankRadius1(BigDecimal shankRadius1) {
		this.shankRadius1 = shankRadius1;
	}

	@Column(name = "shank_radius_1")
	public BigDecimal getShankRadius1() {
		return shankRadius1;
	}

	public void setShankLengthS1(BigDecimal shankLengthS1) {
		this.shankLengthS1 = shankLengthS1;
	}

	@Column(name = "shank_length_s1")
	public BigDecimal getShankLengthS1() {
		return shankLengthS1;
	}

	public void setShankAngel2(String shankAngel2) {
		this.shankAngel2 = shankAngel2;
	}

	@Column(name = "shank_angel_2", length = 20)
	public String getShankAngel2() {
		return shankAngel2;
	}

	public void setShankRadius2(BigDecimal shankRadius2) {
		this.shankRadius2 = shankRadius2;
	}

	@Column(name = "shank_radius_2")
	public BigDecimal getShankRadius2() {
		return shankRadius2;
	}

	public void setShankLengthS2(BigDecimal shankLengthS2) {
		this.shankLengthS2 = shankLengthS2;
	}

	@Column(name = "shank_length_s2")
	public BigDecimal getShankLengthS2() {
		return shankLengthS2;
	}

	public void setShankAngel3(String shankAngel3) {
		this.shankAngel3 = shankAngel3;
	}

	@Column(name = "shank_angel_3", length = 20)
	public String getShankAngel3() {
		return shankAngel3;
	}

	public void setShankRadius3(BigDecimal shankRadius3) {
		this.shankRadius3 = shankRadius3;
	}

	@Column(name = "shank_radius_3")
	public BigDecimal getShankRadius3() {
		return shankRadius3;
	}

	public void setShankLengthS3(BigDecimal shankLengthS3) {
		this.shankLengthS3 = shankLengthS3;
	}

	@Column(name = "shank_length_s3")
	public BigDecimal getShankLengthS3() {
		return shankLengthS3;
	}

	public void setShankStandard(BigDecimal shankStandard) {
		this.shankStandard = shankStandard;
	}

	@Column(name = "shank_standard", nullable = false)
	public BigDecimal getShankStandard() {
		return shankStandard;
	}

	public void setShankUsestate(String shankUsestate) {
		this.shankUsestate = shankUsestate;
	}

	@Column(name = "shank_usestate", length = 10, nullable = false)
	public String getShankUsestate() {
		return shankUsestate;
	}

	public void setShankDesigner(String shankDesigner) {
		this.shankDesigner = shankDesigner;
	}

	@Column(name = "shank_designer", length = 20, nullable = false)
	public String getShankDesigner() {
		return shankDesigner;
	}

	public void setShankDesigndate(Date shankDesigndate) {
		this.shankDesigndate = shankDesigndate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "shank_designdate", nullable = false)
	public Date getShankDesigndate() {
		return shankDesigndate;
	}

	public void setArmTechchange(String armTechchange) {
		this.armTechchange = armTechchange;
	}

	@Column(name = "arm_techchange", length = 30)
	public String getArmTechchange() {
		return armTechchange;
	}

	public void setAttachedPage(String attachedPage) {
		this.attachedPage = attachedPage;
	}

	@Column(name = "attached_page", length = 500)
	public String getAttachedPage() {
		return attachedPage;
	}

	public void setShankCustomer(String shankCustomer) {
		this.shankCustomer = shankCustomer;
	}

	@Column(name = "shank_customer", length = 20, nullable = false)
	public String getShankCustomer() {
		return shankCustomer;
	}

	public void setShankRemark(String shankRemark) {
		this.shankRemark = shankRemark;
	}

	@Column(name = "shank_remark", length = 30)
	public String getShankRemark() {
		return shankRemark;
	}

	public void setShankCode(String shankCode) {
		this.shankCode = shankCode;
	}

	@Column(name = "shank_code", length = 30)
	public String getShankCode() {
		return shankCode;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "id", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public String toString() {
		return "Electrodeholder [shankDrawingno=" + shankDrawingno
				+ ",shankMaterial=" + shankMaterial + ",shankTaper="
				+ shankTaper + ",shankType=" + shankType + ",shankDiameter="
				+ shankDiameter + ",shankAngel1=" + shankAngel1
				+ ",shankRadius1=" + shankRadius1 + ",shankLengthS1="
				+ shankLengthS1 + ",shankAngel2=" + shankAngel2
				+ ",shankRadius2=" + shankRadius2 + ",shankLengthS2="
				+ shankLengthS2 + ",shankAngel3=" + shankAngel3
				+ ",shankRadius3=" + shankRadius3 + ",shankLengthS3="
				+ shankLengthS3 + ",shankStandard=" + shankStandard
				+ ",shankUsestate=" + shankUsestate + ",shankDesigner="
				+ shankDesigner + ",shankDesigndate=" + shankDesigndate
				+ ",armTechchange=" + armTechchange + ",attachedPage="
				+ attachedPage + ",shankCustomer=" + shankCustomer
				+ ",shankRemark=" + shankRemark + ",shankCode=" + shankCode
				+ ",id=" + id + "]";
	}

}
