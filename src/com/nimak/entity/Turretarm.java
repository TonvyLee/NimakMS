package com.nimak.entity;

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
	 * 钳臂零件图号:钳臂零件图号
	 */
	@Id
	@PropertyDef(label = "钳臂零件图号", description = "钳臂零件图号:钳臂零件图号")
	private String armDrawingno;

	/**
	 * 钳臂截面_材料:钳臂截面_材料
	 */
	@PropertyDef(label = "钳臂截面_材料", description = "钳臂截面_材料:钳臂截面_材料")
	private String armMaterial;

	/**
	 * 异性和加强筋:异性和加强筋
	 */
	@PropertyDef(label = "异性和加强筋", description = "异性和加强筋:异性和加强筋")
	private String armSpecialshapeandrib;

	/**
	 * 钳臂所属系列:钳臂所属系列
	 */
	@PropertyDef(label = "钳臂所属系列", description = "钳臂所属系列:钳臂所属系列")
	private String armSerial;

	/**
	 * 钳臂水平长度:钳臂水平长度
	 */
	@PropertyDef(label = "钳臂水平长度", description = "钳臂水平长度:钳臂水平长度")
	private BigDecimal armLength;

	/**
	 * 钳臂最高点距安装轴线高度:钳臂最高点距安装轴线高度
	 */
	@PropertyDef(label = "钳臂最高点距安装轴线高度", description = "钳臂最高点距安装轴线高度:钳臂最高点距安装轴线高度")
	private BigDecimal armWidth1;

	/**
	 * 钳臂竖直高度:钳臂竖直高度
	 */
	@PropertyDef(label = "钳臂竖直高度", description = "钳臂竖直高度:钳臂竖直高度")
	private BigDecimal armWidth2;

	/**
	 * 装配截面尺寸:装配截面尺寸
	 */
	@PropertyDef(label = "装配截面尺寸", description = "装配截面尺寸:装配截面尺寸")
	private BigDecimal assembleSize;

	/**
	 * 装配长度:装配长度
	 */
	@PropertyDef(label = "装配长度", description = "装配长度:装配长度")
	private BigDecimal assembleLength;

	/**
	 * 第一偏转角度:第一偏转角度
	 */
	@PropertyDef(label = "第一偏转角度", description = "第一偏转角度:第一偏转角度")
	private BigDecimal armAngel1;

	/**
	 * 第一折弯半径:第一折弯半径
	 */
	@PropertyDef(label = "第一折弯半径", description = "第一折弯半径:第一折弯半径")
	private BigDecimal armRadius1;

	/**
	 * 第一直段长度:第一直段长度
	 */
	@PropertyDef(label = "第一直段长度", description = "第一直段长度:第一直段长度")
	private BigDecimal armLengthS1;

	/**
	 * 第二偏转角度:第二偏转角度
	 */
	@PropertyDef(label = "第二偏转角度", description = "第二偏转角度:第二偏转角度")
	private BigDecimal armAngel2;

	/**
	 * 第二折弯半径:第二折弯半径
	 */
	@PropertyDef(label = "第二折弯半径", description = "第二折弯半径:第二折弯半径")
	private BigDecimal armRadius2;

	/**
	 * 第二直段长度:第二直段长度
	 */
	@PropertyDef(label = "第二直段长度", description = "第二直段长度:第二直段长度")
	private BigDecimal armLengthS2;

	/**
	 * 第三偏转角度:第三偏转角度
	 */
	@PropertyDef(label = "第三偏转角度", description = "第三偏转角度:第三偏转角度")
	private BigDecimal armAngel3;

	/**
	 * 第三折弯半径:第三折弯半径
	 */
	@PropertyDef(label = "第三折弯半径", description = "第三折弯半径:第三折弯半径")
	private BigDecimal armRadius3;

	/**
	 * 第三直段长度:第三直段长度
	 */
	@PropertyDef(label = "第三直段长度", description = "第三直段长度:第三直段长度")
	private BigDecimal armLengthS3;

	/**
	 * 第四偏转角度:第四偏转角度
	 */
	@PropertyDef(label = "第四偏转角度", description = "第四偏转角度:第四偏转角度")
	private BigDecimal armAngel4;

	/**
	 * 第四直段长度:第四直段长度
	 */
	@PropertyDef(label = "第四直段长度", description = "第四直段长度:第四直段长度")
	private BigDecimal armLengthS4;

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
	 * 握杆装配孔深:握杆装配孔深
	 */
	@PropertyDef(label = "握杆装配孔深", description = "握杆装配孔深:握杆装配孔深")
	private BigDecimal shankHoledepth;

	/**
	 * 是否有直线导轨:是否有直线导轨
	 */
	@PropertyDef(label = "是否有直线导轨", description = "是否有直线导轨:是否有直线导轨")
	private BigDecimal linearGuide;

	/**
	 * 是否为标准零件:是否为标准零件
	 */
	@PropertyDef(label = "是否为标准零件", description = "是否为标准零件:是否为标准零件")
	private BigDecimal armStandard;

	/**
	 * 使用状态:使用状态
	 */
	@PropertyDef(label = "使用状态", description = "使用状态:使用状态")
	private String armUsestate;

	/**
	 * 设计者:设计者
	 */
	@PropertyDef(label = "设计者", description = "设计者:设计者")
	private String armDesigner;

	/**
	 * 设计日期:设计日期
	 */
	@PropertyDef(label = "设计日期", description = "设计日期:设计日期")
	private Date armDesigndate;

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
	private String armCustomer;

	/**
	 * 备注:备注
	 */
	@PropertyDef(label = "备注", description = "备注:备注")
	private String armRemark;

	/**
	 * 分类编码:分类编码
	 */
	@PropertyDef(label = "分类编码", description = "分类编码:分类编码")
	private String armCode;

	/**
	 * ID:ID
	 *//*
	@PropertyDef(label = "ID", description = "ID:ID")
	private String id;
	*/
	/**
	 * 钳臂系列:钳臂系列
	 */
	@PropertyDef(label = "钳臂系列", description = "钳臂系列:钳臂系列")
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

	@Column(name = "ARM_DRAWINGNO", length = 20, nullable = false)
	public String getArmDrawingno() {
		return armDrawingno;
	}

	public void setArmMaterial(String armMaterial) {
		this.armMaterial = armMaterial;
	}

	@Column(name = "ARM_MATERIAL", length = 20, nullable = false)
	public String getArmMaterial() {
		return armMaterial;
	}

	public void setArmSpecialshapeandrib(String armSpecialshapeandrib) {
		this.armSpecialshapeandrib = armSpecialshapeandrib;
	}

	@Column(name = "ARM_SPECIALSHAPEANDRIB", length = 20, nullable = false)
	public String getArmSpecialshapeandrib() {
		return armSpecialshapeandrib;
	}

	public void setArmSerial(String armSerial) {
		this.armSerial = armSerial;
	}

	@Column(name = "ARM_SERIAL", length = 10, nullable = false)
	public String getArmSerial() {
		return armSerial;
	}

	public void setArmLength(BigDecimal armLength) {
		this.armLength = armLength;
	}

	@Column(name = "ARM_LENGTH", nullable = false)
	public BigDecimal getArmLength() {
		return armLength;
	}

	public void setArmWidth1(BigDecimal armWidth1) {
		this.armWidth1 = armWidth1;
	}

	@Column(name = "ARM_WIDTH1")
	public BigDecimal getArmWidth1() {
		return armWidth1;
	}

	public void setArmWidth2(BigDecimal armWidth2) {
		this.armWidth2 = armWidth2;
	}

	@Column(name = "ARM_WIDTH2")
	public BigDecimal getArmWidth2() {
		return armWidth2;
	}

	public void setAssembleSize(BigDecimal assembleSize) {
		this.assembleSize = assembleSize;
	}

	@Column(name = "ASSEMBLE_SIZE", nullable = false)
	public BigDecimal getAssembleSize() {
		return assembleSize;
	}

	public void setAssembleLength(BigDecimal assembleLength) {
		this.assembleLength = assembleLength;
	}

	@Column(name = "ASSEMBLE_LENGTH", nullable = false)
	public BigDecimal getAssembleLength() {
		return assembleLength;
	}

	public void setArmAngel1(BigDecimal armAngel1) {
		this.armAngel1 = armAngel1;
	}

	@Column(name = "ARM_ANGEL_1")
	public BigDecimal getArmAngel1() {
		return armAngel1;
	}

	public void setArmRadius1(BigDecimal armRadius1) {
		this.armRadius1 = armRadius1;
	}

	@Column(name = "ARM_RADIUS_1")
	public BigDecimal getArmRadius1() {
		return armRadius1;
	}

	public void setArmLengthS1(BigDecimal armLengthS1) {
		this.armLengthS1 = armLengthS1;
	}

	@Column(name = "ARM_LENGTH_S1")
	public BigDecimal getArmLengthS1() {
		return armLengthS1;
	}

	public void setArmAngel2(BigDecimal armAngel2) {
		this.armAngel2 = armAngel2;
	}

	@Column(name = "ARM_ANGEL_2")
	public BigDecimal getArmAngel2() {
		return armAngel2;
	}

	public void setArmRadius2(BigDecimal armRadius2) {
		this.armRadius2 = armRadius2;
	}

	@Column(name = "ARM_RADIUS_2")
	public BigDecimal getArmRadius2() {
		return armRadius2;
	}

	public void setArmLengthS2(BigDecimal armLengthS2) {
		this.armLengthS2 = armLengthS2;
	}

	@Column(name = "ARM_LENGTH_S2")
	public BigDecimal getArmLengthS2() {
		return armLengthS2;
	}

	public void setArmAngel3(BigDecimal armAngel3) {
		this.armAngel3 = armAngel3;
	}

	@Column(name = "ARM_ANGEL_3")
	public BigDecimal getArmAngel3() {
		return armAngel3;
	}

	public void setArmRadius3(BigDecimal armRadius3) {
		this.armRadius3 = armRadius3;
	}

	@Column(name = "ARM_RADIUS_3")
	public BigDecimal getArmRadius3() {
		return armRadius3;
	}

	public void setArmLengthS3(BigDecimal armLengthS3) {
		this.armLengthS3 = armLengthS3;
	}

	@Column(name = "ARM_LENGTH_S3")
	public BigDecimal getArmLengthS3() {
		return armLengthS3;
	}

	public void setArmAngel4(BigDecimal armAngel4) {
		this.armAngel4 = armAngel4;
	}

	@Column(name = "ARM_ANGEL_4")
	public BigDecimal getArmAngel4() {
		return armAngel4;
	}

	public void setArmLengthS4(BigDecimal armLengthS4) {
		this.armLengthS4 = armLengthS4;
	}

	@Column(name = "ARM_LENGTH_S4")
	public BigDecimal getArmLengthS4() {
		return armLengthS4;
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

	public void setShankHoledepth(BigDecimal shankHoledepth) {
		this.shankHoledepth = shankHoledepth;
	}

	@Column(name = "SHANK_HOLEDEPTH")
	public BigDecimal getShankHoledepth() {
		return shankHoledepth;
	}

	public void setLinearGuide(BigDecimal linearGuide) {
		this.linearGuide = linearGuide;
	}

	@Column(name = "LINEAR_GUIDE", nullable = false)
	public BigDecimal getLinearGuide() {
		return linearGuide;
	}

	public void setArmStandard(BigDecimal armStandard) {
		this.armStandard = armStandard;
	}

	@Column(name = "ARM_STANDARD", nullable = false)
	public BigDecimal getArmStandard() {
		return armStandard;
	}

	public void setArmUsestate(String armUsestate) {
		this.armUsestate = armUsestate;
	}

	@Column(name = "ARM_USESTATE", length = 10, nullable = false)
	public String getArmUsestate() {
		return armUsestate;
	}

	public void setArmDesigner(String armDesigner) {
		this.armDesigner = armDesigner;
	}

	@Column(name = "ARM_DESIGNER", length = 20, nullable = false)
	public String getArmDesigner() {
		return armDesigner;
	}

	public void setArmDesigndate(Date armDesigndate) {
		this.armDesigndate = armDesigndate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ARM_DESIGNDATE", nullable = false)
	public Date getArmDesigndate() {
		return armDesigndate;
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

	public void setArmCustomer(String armCustomer) {
		this.armCustomer = armCustomer;
	}

	@Column(name = "ARM_CUSTOMER", length = 20, nullable = false)
	public String getArmCustomer() {
		return armCustomer;
	}

	public void setArmRemark(String armRemark) {
		this.armRemark = armRemark;
	}

	@Column(name = "ARM_REMARK", length = 30)
	public String getArmRemark() {
		return armRemark;
	}

	public void setArmCode(String armCode) {
		this.armCode = armCode;
	}

	@Column(name = "ARM_CODE", length = 30)
	public String getArmCode() {
		return armCode;
	}

	public void setArmType(String armType) {
		this.armType = armType;
	}

	@Id
	@Column(name = "ARM_TYPE", length = 50, nullable = false)
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
