package com.nimak.entity;

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
	 * 焊钳图号:焊钳图号
	 */
	@PropertyDef(label = "焊钳图号", description = "焊钳图号:焊钳图号")
	private String shankDrawingno;

	/**
	 * 电极握杆材料:电极握杆材料
	 */
	@PropertyDef(label = "电极握杆材料", description = "电极握杆材料:电极握杆材料")
	private String shankMaterial;

	/**
	 * 电极帽座锥度:电极帽座锥度
	 */
	@PropertyDef(label = "电极帽座锥度", description = "电极帽座锥度:电极帽座锥度")
	private String shankTaper;

	/**
	 * 握杆装配形式:握杆装配形式
	 */
	@PropertyDef(label = "握杆装配形式", description = "握杆装配形式:握杆装配形式")
	private String shankType;

	/**
	 * 电极握杆直径:电极握杆直径
	 */
	@PropertyDef(label = "电极握杆直径", description = "电极握杆直径:电极握杆直径")
	private BigDecimal shankDiameter;

	/**
	 * 第一偏转角度:第一偏转角度
	 */
	@PropertyDef(label = "第一偏转角度", description = "第一偏转角度:第一偏转角度")
	private String shankAngel1;

	/**
	 * 第一折弯半径:第一折弯半径
	 */
	@PropertyDef(label = "第一折弯半径", description = "第一折弯半径:第一折弯半径")
	private BigDecimal shankRadius1;

	/**
	 * 第一直段长度:第一直段长度
	 */
	@PropertyDef(label = "第一直段长度", description = "第一直段长度:第一直段长度")
	private BigDecimal shankLengthS1;

	/**
	 * 第二偏转角度:第二偏转角度
	 */
	@PropertyDef(label = "第二偏转角度", description = "第二偏转角度:第二偏转角度")
	private String shankAngel2;

	/**
	 * 第二折弯半径:第二折弯半径
	 */
	@PropertyDef(label = "第二折弯半径", description = "第二折弯半径:第二折弯半径")
	private BigDecimal shankRadius2;

	/**
	 * 第二直段长度:第二直段长度
	 */
	@PropertyDef(label = "第二直段长度", description = "第二直段长度:第二直段长度")
	private BigDecimal shankLengthS2;

	/**
	 * 第三偏转角度:第三偏转角度
	 */
	@PropertyDef(label = "第三偏转角度", description = "第三偏转角度:第三偏转角度")
	private String shankAngel3;

	/**
	 * 第三折弯半径:第三折弯半径
	 */
	@PropertyDef(label = "第三折弯半径", description = "第三折弯半径:第三折弯半径")
	private BigDecimal shankRadius3;

	/**
	 * 第三直段长度:第三直段长度
	 */
	@PropertyDef(label = "第三直段长度", description = "第三直段长度:第三直段长度")
	private BigDecimal shankLengthS3;

	/**
	 * 是否为标准零件:是否为标准零件
	 */
	@PropertyDef(label = "是否为标准零件", description = "是否为标准零件:是否为标准零件")
	private BigDecimal shankStandard;

	/**
	 * 使用状态:使用状态
	 */
	@PropertyDef(label = "使用状态", description = "使用状态:使用状态")
	private String shankUsestate;

	/**
	 * 设计者:设计者
	 */
	@PropertyDef(label = "设计者", description = "设计者:设计者")
	private String shankDesigner;

	/**
	 * 设计日期:设计日期
	 */
	@PropertyDef(label = "设计日期", description = "设计日期:设计日期")
	private Date shankDesigndate;

	/**
	 * 技术更改:技术更改
	 */
	@PropertyDef(label = "技术更改", description = "技术更改:技术更改")
	private String armTechchange;

	/**
	 * 工艺附属页:工艺附属页
	 */
	@PropertyDef(label = "工艺附属页", description = "工艺附属页:工艺附属页")
	private String attachedPage;

	/**
	 * 客户/标准:客户/标准
	 */
	@PropertyDef(label = "客户/标准", description = "客户/标准:客户/标准")
	private String shankCustomer;

	/**
	 * 备注:备注
	 */
	@PropertyDef(label = "备注", description = "备注:备注")
	private String shankRemark;

	/**
	 * 分类编码:分类编码
	 */
	@PropertyDef(label = "分类编码", description = "分类编码:分类编码")
	private String shankCode;

	/**
	 * ID:ID
	 */
	@PropertyDef(label = "ID", description = "ID:ID")
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

	@Column(name = "SHANK_DRAWINGNO", length = 20, nullable = false)
	public String getShankDrawingno() {
		return shankDrawingno;
	}

	public void setShankMaterial(String shankMaterial) {
		this.shankMaterial = shankMaterial;
	}

	@Column(name = "SHANK_MATERIAL", length = 20, nullable = false)
	public String getShankMaterial() {
		return shankMaterial;
	}

	public void setShankTaper(String shankTaper) {
		this.shankTaper = shankTaper;
	}

	@Column(name = "SHANK_TAPER", length = 20, nullable = false)
	public String getShankTaper() {
		return shankTaper;
	}

	public void setShankType(String shankType) {
		this.shankType = shankType;
	}

	@Column(name = "SHANK_TYPE", length = 10, nullable = false)
	public String getShankType() {
		return shankType;
	}

	public void setShankDiameter(BigDecimal shankDiameter) {
		this.shankDiameter = shankDiameter;
	}

	@Column(name = "SHANK_DIAMETER", nullable = false)
	public BigDecimal getShankDiameter() {
		return shankDiameter;
	}

	public void setShankAngel1(String shankAngel1) {
		this.shankAngel1 = shankAngel1;
	}

	@Column(name = "SHANK_ANGEL_1", length = 20)
	public String getShankAngel1() {
		return shankAngel1;
	}

	public void setShankRadius1(BigDecimal shankRadius1) {
		this.shankRadius1 = shankRadius1;
	}

	@Column(name = "SHANK_RADIUS_1")
	public BigDecimal getShankRadius1() {
		return shankRadius1;
	}

	public void setShankLengthS1(BigDecimal shankLengthS1) {
		this.shankLengthS1 = shankLengthS1;
	}

	@Column(name = "SHANK_LENGTH_S1")
	public BigDecimal getShankLengthS1() {
		return shankLengthS1;
	}

	public void setShankAngel2(String shankAngel2) {
		this.shankAngel2 = shankAngel2;
	}

	@Column(name = "SHANK_ANGEL_2", length = 20)
	public String getShankAngel2() {
		return shankAngel2;
	}

	public void setShankRadius2(BigDecimal shankRadius2) {
		this.shankRadius2 = shankRadius2;
	}

	@Column(name = "SHANK_RADIUS_2")
	public BigDecimal getShankRadius2() {
		return shankRadius2;
	}

	public void setShankLengthS2(BigDecimal shankLengthS2) {
		this.shankLengthS2 = shankLengthS2;
	}

	@Column(name = "SHANK_LENGTH_S2")
	public BigDecimal getShankLengthS2() {
		return shankLengthS2;
	}

	public void setShankAngel3(String shankAngel3) {
		this.shankAngel3 = shankAngel3;
	}

	@Column(name = "SHANK_ANGEL_3", length = 20)
	public String getShankAngel3() {
		return shankAngel3;
	}

	public void setShankRadius3(BigDecimal shankRadius3) {
		this.shankRadius3 = shankRadius3;
	}

	@Column(name = "SHANK_RADIUS_3")
	public BigDecimal getShankRadius3() {
		return shankRadius3;
	}

	public void setShankLengthS3(BigDecimal shankLengthS3) {
		this.shankLengthS3 = shankLengthS3;
	}

	@Column(name = "SHANK_LENGTH_S3")
	public BigDecimal getShankLengthS3() {
		return shankLengthS3;
	}

	public void setShankStandard(BigDecimal shankStandard) {
		this.shankStandard = shankStandard;
	}

	@Column(name = "SHANK_STANDARD", nullable = false)
	public BigDecimal getShankStandard() {
		return shankStandard;
	}

	public void setShankUsestate(String shankUsestate) {
		this.shankUsestate = shankUsestate;
	}

	@Column(name = "SHANK_USESTATE", length = 10, nullable = false)
	public String getShankUsestate() {
		return shankUsestate;
	}

	public void setShankDesigner(String shankDesigner) {
		this.shankDesigner = shankDesigner;
	}

	@Column(name = "SHANK_DESIGNER", length = 20, nullable = false)
	public String getShankDesigner() {
		return shankDesigner;
	}

	public void setShankDesigndate(Date shankDesigndate) {
		this.shankDesigndate = shankDesigndate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SHANK_DESIGNDATE", nullable = false)
	public Date getShankDesigndate() {
		return shankDesigndate;
	}

	public void setArmTechchange(String armTechchange) {
		this.armTechchange = armTechchange;
	}

	@Column(name = "ARM_TECHCHANGE", length = 30)
	public String getArmTechchange() {
		return armTechchange;
	}

	public void setAttachedPage(String attachedPage) {
		this.attachedPage = attachedPage;
	}

	@Column(name = "ATTACHED_PAGE", length = 500)
	public String getAttachedPage() {
		return attachedPage;
	}

	public void setShankCustomer(String shankCustomer) {
		this.shankCustomer = shankCustomer;
	}

	@Column(name = "SHANK_CUSTOMER", length = 20, nullable = false)
	public String getShankCustomer() {
		return shankCustomer;
	}

	public void setShankRemark(String shankRemark) {
		this.shankRemark = shankRemark;
	}

	@Column(name = "SHANK_REMARK", length = 30)
	public String getShankRemark() {
		return shankRemark;
	}

	public void setShankCode(String shankCode) {
		this.shankCode = shankCode;
	}

	@Column(name = "SHANK_CODE", length = 30)
	public String getShankCode() {
		return shankCode;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID", length = 50, nullable = false)
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
