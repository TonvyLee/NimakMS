package com.nimak.entitysqlserver;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * TURRETARM:
 */
@Entity
@Table(name = "TURRETARM")
public class Turretarm implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * arm_drawingno:
	 */
	@PropertyDef(label = "arm_drawingno", description = "arm_drawingno:")
	private String armDrawingno;

	/**
	 * arm_material:
	 */
	@PropertyDef(label = "arm_material", description = "arm_material:")
	private String armMaterial;

	/**
	 * arm_specialshapeandrib:
	 */
	@PropertyDef(label = "arm_specialshapeandrib", description = "arm_specialshapeandrib:")
	private String armSpecialshapeandrib;

	/**
	 * arm_serial:
	 */
	@PropertyDef(label = "arm_serial", description = "arm_serial:")
	private String armSerial;

	/**
	 * arm_length:
	 */
	@PropertyDef(label = "arm_length", description = "arm_length:")
	private BigDecimal armLength;

	/**
	 * arm_width1:
	 */
	@PropertyDef(label = "arm_width1", description = "arm_width1:")
	private BigDecimal armWidth1;

	/**
	 * arm_width2:
	 */
	@PropertyDef(label = "arm_width2", description = "arm_width2:")
	private BigDecimal armWidth2;

	/**
	 * assemble_size:
	 */
	@PropertyDef(label = "assemble_size", description = "assemble_size:")
	private BigDecimal assembleSize;

	/**
	 * assemble_length:
	 */
	@PropertyDef(label = "assemble_length", description = "assemble_length:")
	private BigDecimal assembleLength;

	/**
	 * arm_angel_1:
	 */
	@PropertyDef(label = "arm_angel_1", description = "arm_angel_1:")
	private BigDecimal armAngel1;

	/**
	 * arm_radius_1:
	 */
	@PropertyDef(label = "arm_radius_1", description = "arm_radius_1:")
	private BigDecimal armRadius1;

	/**
	 * arm_length_s1:
	 */
	@PropertyDef(label = "arm_length_s1", description = "arm_length_s1:")
	private BigDecimal armLengthS1;

	/**
	 * arm_angel_2:
	 */
	@PropertyDef(label = "arm_angel_2", description = "arm_angel_2:")
	private BigDecimal armAngel2;

	/**
	 * arm_radius_2:
	 */
	@PropertyDef(label = "arm_radius_2", description = "arm_radius_2:")
	private BigDecimal armRadius2;

	/**
	 * arm_length_s2:
	 */
	@PropertyDef(label = "arm_length_s2", description = "arm_length_s2:")
	private BigDecimal armLengthS2;

	/**
	 * arm_angel_3:
	 */
	@PropertyDef(label = "arm_angel_3", description = "arm_angel_3:")
	private BigDecimal armAngel3;

	/**
	 * arm_radius_3:
	 */
	@PropertyDef(label = "arm_radius_3", description = "arm_radius_3:")
	private BigDecimal armRadius3;

	/**
	 * arm_length_s3:
	 */
	@PropertyDef(label = "arm_length_s3", description = "arm_length_s3:")
	private BigDecimal armLengthS3;

	/**
	 * arm_angel_4:
	 */
	@PropertyDef(label = "arm_angel_4", description = "arm_angel_4:")
	private BigDecimal armAngel4;

	/**
	 * arm_length_s4:
	 */
	@PropertyDef(label = "arm_length_s4", description = "arm_length_s4:")
	private BigDecimal armLengthS4;

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
	 * shank_holedepth:
	 */
	@PropertyDef(label = "shank_holedepth", description = "shank_holedepth:")
	private BigDecimal shankHoledepth;

	/**
	 * linear_guide:
	 */
	@PropertyDef(label = "linear_guide", description = "linear_guide:")
	private BigDecimal linearGuide;

	/**
	 * arm_standard:
	 */
	@PropertyDef(label = "arm_standard", description = "arm_standard:")
	private BigDecimal armStandard;

	/**
	 * arm_usestate:
	 */
	@PropertyDef(label = "arm_usestate", description = "arm_usestate:")
	private String armUsestate;

	/**
	 * arm_designer:
	 */
	@PropertyDef(label = "arm_designer", description = "arm_designer:")
	private String armDesigner;

	/**
	 * arm_designdate:
	 */
	@PropertyDef(label = "arm_designdate", description = "arm_designdate:")
	private Date armDesigndate;

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
	 * arm_customer:
	 */
	@PropertyDef(label = "arm_customer", description = "arm_customer:")
	private String armCustomer;

	/**
	 * arm_remark:
	 */
	@PropertyDef(label = "arm_remark", description = "arm_remark:")
	private String armRemark;

	/**
	 * arm_code:
	 */
	@PropertyDef(label = "arm_code", description = "arm_code:")
	private String armCode;

	/**
	 * arm_type:
	 */
	@PropertyDef(label = "arm_type", description = "arm_type:")
	private String armType;

	public Turretarm() {
		super();
	}

	public Turretarm(String armDrawingno, String armMaterial,
			String armSpecialshapeandrib, String armSerial,
			BigDecimal armLength, BigDecimal armWidth1, BigDecimal armWidth2,
			BigDecimal assembleSize, BigDecimal assembleLength,
			BigDecimal armAngel1, BigDecimal armRadius1,
			BigDecimal armLengthS1, BigDecimal armAngel2,
			BigDecimal armRadius2, BigDecimal armLengthS2,
			BigDecimal armAngel3, BigDecimal armRadius3,
			BigDecimal armLengthS3, BigDecimal armAngel4,
			BigDecimal armLengthS4, String shankType, BigDecimal shankDiameter,
			BigDecimal shankHoledepth, BigDecimal linearGuide,
			BigDecimal armStandard, String armUsestate, String armDesigner,
			Date armDesigndate, String armTechchange, String attachedPage,
			String armCustomer, String armRemark, String armCode, String armType) {
		super();
		this.armDrawingno = armDrawingno;
		this.armMaterial = armMaterial;
		this.armSpecialshapeandrib = armSpecialshapeandrib;
		this.armSerial = armSerial;
		this.armLength = armLength;
		this.armWidth1 = armWidth1;
		this.armWidth2 = armWidth2;
		this.assembleSize = assembleSize;
		this.assembleLength = assembleLength;
		this.armAngel1 = armAngel1;
		this.armRadius1 = armRadius1;
		this.armLengthS1 = armLengthS1;
		this.armAngel2 = armAngel2;
		this.armRadius2 = armRadius2;
		this.armLengthS2 = armLengthS2;
		this.armAngel3 = armAngel3;
		this.armRadius3 = armRadius3;
		this.armLengthS3 = armLengthS3;
		this.armAngel4 = armAngel4;
		this.armLengthS4 = armLengthS4;
		this.shankType = shankType;
		this.shankDiameter = shankDiameter;
		this.shankHoledepth = shankHoledepth;
		this.linearGuide = linearGuide;
		this.armStandard = armStandard;
		this.armUsestate = armUsestate;
		this.armDesigner = armDesigner;
		this.armDesigndate = armDesigndate;
		this.armTechchange = armTechchange;
		this.attachedPage = attachedPage;
		this.armCustomer = armCustomer;
		this.armRemark = armRemark;
		this.armCode = armCode;
		this.armType = armType;
	}

	public void setArmDrawingno(String armDrawingno) {
		this.armDrawingno = armDrawingno;
	}

	@Id
	@Column(name = "arm_drawingno", length = 20, nullable = false)
	public String getArmDrawingno() {
		return armDrawingno;
	}

	public void setArmMaterial(String armMaterial) {
		this.armMaterial = armMaterial;
	}

	@Column(name = "arm_material", length = 20, nullable = false)
	public String getArmMaterial() {
		return armMaterial;
	}

	public void setArmSpecialshapeandrib(String armSpecialshapeandrib) {
		this.armSpecialshapeandrib = armSpecialshapeandrib;
	}

	@Column(name = "arm_specialshapeandrib", length = 20, nullable = false)
	public String getArmSpecialshapeandrib() {
		return armSpecialshapeandrib;
	}

	public void setArmSerial(String armSerial) {
		this.armSerial = armSerial;
	}

	@Column(name = "arm_serial", length = 10, nullable = false)
	public String getArmSerial() {
		return armSerial;
	}

	public void setArmLength(BigDecimal armLength) {
		this.armLength = armLength;
	}

	@Column(name = "arm_length", nullable = false)
	public BigDecimal getArmLength() {
		return armLength;
	}

	public void setArmWidth1(BigDecimal armWidth1) {
		this.armWidth1 = armWidth1;
	}

	@Column(name = "arm_width1")
	public BigDecimal getArmWidth1() {
		return armWidth1;
	}

	public void setArmWidth2(BigDecimal armWidth2) {
		this.armWidth2 = armWidth2;
	}

	@Column(name = "arm_width2")
	public BigDecimal getArmWidth2() {
		return armWidth2;
	}

	public void setAssembleSize(BigDecimal assembleSize) {
		this.assembleSize = assembleSize;
	}

	@Column(name = "assemble_size", nullable = false)
	public BigDecimal getAssembleSize() {
		return assembleSize;
	}

	public void setAssembleLength(BigDecimal assembleLength) {
		this.assembleLength = assembleLength;
	}

	@Column(name = "assemble_length", nullable = false)
	public BigDecimal getAssembleLength() {
		return assembleLength;
	}

	public void setArmAngel1(BigDecimal armAngel1) {
		this.armAngel1 = armAngel1;
	}

	@Column(name = "arm_angel_1")
	public BigDecimal getArmAngel1() {
		return armAngel1;
	}

	public void setArmRadius1(BigDecimal armRadius1) {
		this.armRadius1 = armRadius1;
	}

	@Column(name = "arm_radius_1")
	public BigDecimal getArmRadius1() {
		return armRadius1;
	}

	public void setArmLengthS1(BigDecimal armLengthS1) {
		this.armLengthS1 = armLengthS1;
	}

	@Column(name = "arm_length_s1")
	public BigDecimal getArmLengthS1() {
		return armLengthS1;
	}

	public void setArmAngel2(BigDecimal armAngel2) {
		this.armAngel2 = armAngel2;
	}

	@Column(name = "arm_angel_2")
	public BigDecimal getArmAngel2() {
		return armAngel2;
	}

	public void setArmRadius2(BigDecimal armRadius2) {
		this.armRadius2 = armRadius2;
	}

	@Column(name = "arm_radius_2")
	public BigDecimal getArmRadius2() {
		return armRadius2;
	}

	public void setArmLengthS2(BigDecimal armLengthS2) {
		this.armLengthS2 = armLengthS2;
	}

	@Column(name = "arm_length_s2")
	public BigDecimal getArmLengthS2() {
		return armLengthS2;
	}

	public void setArmAngel3(BigDecimal armAngel3) {
		this.armAngel3 = armAngel3;
	}

	@Column(name = "arm_angel_3")
	public BigDecimal getArmAngel3() {
		return armAngel3;
	}

	public void setArmRadius3(BigDecimal armRadius3) {
		this.armRadius3 = armRadius3;
	}

	@Column(name = "arm_radius_3")
	public BigDecimal getArmRadius3() {
		return armRadius3;
	}

	public void setArmLengthS3(BigDecimal armLengthS3) {
		this.armLengthS3 = armLengthS3;
	}

	@Column(name = "arm_length_s3")
	public BigDecimal getArmLengthS3() {
		return armLengthS3;
	}

	public void setArmAngel4(BigDecimal armAngel4) {
		this.armAngel4 = armAngel4;
	}

	@Column(name = "arm_angel_4")
	public BigDecimal getArmAngel4() {
		return armAngel4;
	}

	public void setArmLengthS4(BigDecimal armLengthS4) {
		this.armLengthS4 = armLengthS4;
	}

	@Column(name = "arm_length_s4")
	public BigDecimal getArmLengthS4() {
		return armLengthS4;
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

	public void setShankHoledepth(BigDecimal shankHoledepth) {
		this.shankHoledepth = shankHoledepth;
	}

	@Column(name = "shank_holedepth")
	public BigDecimal getShankHoledepth() {
		return shankHoledepth;
	}

	public void setLinearGuide(BigDecimal linearGuide) {
		this.linearGuide = linearGuide;
	}

	@Column(name = "linear_guide", nullable = false)
	public BigDecimal getLinearGuide() {
		return linearGuide;
	}

	public void setArmStandard(BigDecimal armStandard) {
		this.armStandard = armStandard;
	}

	@Column(name = "arm_standard", nullable = false)
	public BigDecimal getArmStandard() {
		return armStandard;
	}

	public void setArmUsestate(String armUsestate) {
		this.armUsestate = armUsestate;
	}

	@Column(name = "arm_usestate", length = 10, nullable = false)
	public String getArmUsestate() {
		return armUsestate;
	}

	public void setArmDesigner(String armDesigner) {
		this.armDesigner = armDesigner;
	}

	@Column(name = "arm_designer", length = 20, nullable = false)
	public String getArmDesigner() {
		return armDesigner;
	}

	public void setArmDesigndate(Date armDesigndate) {
		this.armDesigndate = armDesigndate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "arm_designdate", nullable = false)
	public Date getArmDesigndate() {
		return armDesigndate;
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

	public void setArmCustomer(String armCustomer) {
		this.armCustomer = armCustomer;
	}

	@Column(name = "arm_customer", length = 20, nullable = false)
	public String getArmCustomer() {
		return armCustomer;
	}

	public void setArmRemark(String armRemark) {
		this.armRemark = armRemark;
	}

	@Column(name = "arm_remark", length = 30)
	public String getArmRemark() {
		return armRemark;
	}

	public void setArmCode(String armCode) {
		this.armCode = armCode;
	}

	@Column(name = "arm_code", length = 30)
	public String getArmCode() {
		return armCode;
	}

	public void setArmType(String armType) {
		this.armType = armType;
	}

	@Column(name = "arm_type", length = 10, nullable = false)
	public String getArmType() {
		return armType;
	}

	public String toString() {
		return "Turretarm [armDrawingno=" + armDrawingno + ",armMaterial="
				+ armMaterial + ",armSpecialshapeandrib="
				+ armSpecialshapeandrib + ",armSerial=" + armSerial
				+ ",armLength=" + armLength + ",armWidth1=" + armWidth1
				+ ",armWidth2=" + armWidth2 + ",assembleSize=" + assembleSize
				+ ",assembleLength=" + assembleLength + ",armAngel1="
				+ armAngel1 + ",armRadius1=" + armRadius1 + ",armLengthS1="
				+ armLengthS1 + ",armAngel2=" + armAngel2 + ",armRadius2="
				+ armRadius2 + ",armLengthS2=" + armLengthS2 + ",armAngel3="
				+ armAngel3 + ",armRadius3=" + armRadius3 + ",armLengthS3="
				+ armLengthS3 + ",armAngel4=" + armAngel4 + ",armLengthS4="
				+ armLengthS4 + ",shankType=" + shankType + ",shankDiameter="
				+ shankDiameter + ",shankHoledepth=" + shankHoledepth
				+ ",linearGuide=" + linearGuide + ",armStandard=" + armStandard
				+ ",armUsestate=" + armUsestate + ",armDesigner=" + armDesigner
				+ ",armDesigndate=" + armDesigndate + ",armTechchange="
				+ armTechchange + ",attachedPage=" + attachedPage
				+ ",armCustomer=" + armCustomer + ",armRemark=" + armRemark
				+ ",armCode=" + armCode + ",armType=" + armType + "]";
	}

}
