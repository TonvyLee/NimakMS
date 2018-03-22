package com.nimak.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * TURRETPART:
 */
@Entity
@Table(name = "TURRETPART")
public class Turretpart implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 焊钳类型:焊钳类型
	 */
	@PropertyDef(label = "焊钳类型", description = "焊钳类型:焊钳类型")
	private String gunType;

	/**
	 * 钳臂部件图号:钳臂部件图号
	 */
	@PropertyDef(label = "钳臂部件图号", description = "钳臂部件图号:钳臂部件图号")
	private String armAssemblyno;

	/**
	 * 钳臂组件图号:钳臂组件图号
	 */
	@PropertyDef(label = "钳臂组件图号", description = "钳臂组件图号:钳臂组件图号")
	private String armComponentno;

	/**
	 * 电极握杆组件图号:电极握杆组件图号
	 */
	@PropertyDef(label = "电极握杆组件图号", description = "电极握杆组件图号:电极握杆组件图号")
	private String shankComponentno;

	/**
	 * 钳臂零件图号:钳臂零件图号
	 */
	@PropertyDef(label = "钳臂零件图号", description = "钳臂零件图号:钳臂零件图号")
	private String armDrawingno;

	/**
	 * 电极握杆零件图号:电极握杆零件图号
	 */
	@PropertyDef(label = "电极握杆零件图号", description = "电极握杆零件图号:电极握杆零件图号")
	private String shankDrawingno;

	/**
	 * 喉深:喉深
	 */
	@PropertyDef(label = "喉深", description = "喉深:喉深")
	private BigDecimal armassemblyLength;

	/**
	 * 喉宽:喉宽
	 */
	@PropertyDef(label = "喉宽", description = "喉宽:喉宽")
	private BigDecimal armassemblyWidth;

	/**
	 * 臂间距:臂间距
	 */
	@PropertyDef(label = "臂间距", description = "臂间距:臂间距")
	private BigDecimal armassemblyWidth2;

	/**
	 * 压力等级:压力等级
	 */
	@PropertyDef(label = "压力等级", description = "压力等级:压力等级")
	private BigDecimal force;

	/**
	 * 电极帽偏转角度:电极帽偏转角度
	 */
	@PropertyDef(label = "电极帽偏转角度", description = "电极帽偏转角度:电极帽偏转角度")
	private BigDecimal capAngel;

	/**
	 * 技术更改:技术更改
	 */
	@PropertyDef(label = "技术更改", description = "技术更改:技术更改")
	private String armassemblyTechchange;

	/**
	 * 分类编码:分类编码
	 */
	@PropertyDef(label = "分类编码", description = "分类编码:分类编码")
	private String armassemblyCode;

	/**
	 * ID:ID
	 */
	@PropertyDef(label = "ID", description = "ID:ID")
	private String id;

	public Turretpart() {
		super();
	}

	public Turretpart(String gunType, String armAssemblyno,
			String armComponentno, String shankComponentno,
			String armDrawingno, String shankDrawingno,
			BigDecimal armassemblyLength, BigDecimal armassemblyWidth,
			BigDecimal armassemblyWidth2, BigDecimal force,
			BigDecimal capAngel, String armassemblyTechchange,
			String armassemblyCode, String id) {
		super();
		this.gunType = gunType;
		this.armAssemblyno = armAssemblyno;
		this.armComponentno = armComponentno;
		this.shankComponentno = shankComponentno;
		this.armDrawingno = armDrawingno;
		this.shankDrawingno = shankDrawingno;
		this.armassemblyLength = armassemblyLength;
		this.armassemblyWidth = armassemblyWidth;
		this.armassemblyWidth2 = armassemblyWidth2;
		this.force = force;
		this.capAngel = capAngel;
		this.armassemblyTechchange = armassemblyTechchange;
		this.armassemblyCode = armassemblyCode;
		this.id = id;
	}

	public void setGunType(String gunType) {
		this.gunType = gunType;
	}

	@Column(name = "GUN_TYPE", length = 10, nullable = false)
	public String getGunType() {
		return gunType;
	}

	public void setArmAssemblyno(String armAssemblyno) {
		this.armAssemblyno = armAssemblyno;
	}

	@Column(name = "ARM_ASSEMBLYNO", length = 20, nullable = false)
	public String getArmAssemblyno() {
		return armAssemblyno;
	}

	public void setArmComponentno(String armComponentno) {
		this.armComponentno = armComponentno;
	}

	@Column(name = "ARM_COMPONENTNO", length = 20, nullable = false)
	public String getArmComponentno() {
		return armComponentno;
	}

	public void setShankComponentno(String shankComponentno) {
		this.shankComponentno = shankComponentno;
	}

	@Column(name = "SHANK_COMPONENTNO", length = 20, nullable = false)
	public String getShankComponentno() {
		return shankComponentno;
	}

	public void setArmDrawingno(String armDrawingno) {
		this.armDrawingno = armDrawingno;
	}

	@Column(name = "ARM_DRAWINGNO", length = 20, nullable = false)
	public String getArmDrawingno() {
		return armDrawingno;
	}

	public void setShankDrawingno(String shankDrawingno) {
		this.shankDrawingno = shankDrawingno;
	}

	@Column(name = "SHANK_DRAWINGNO", length = 20, nullable = false)
	public String getShankDrawingno() {
		return shankDrawingno;
	}

	public void setArmassemblyLength(BigDecimal armassemblyLength) {
		this.armassemblyLength = armassemblyLength;
	}

	@Column(name = "ARMASSEMBLY_LENGTH", nullable = false)
	public BigDecimal getArmassemblyLength() {
		return armassemblyLength;
	}

	public void setArmassemblyWidth(BigDecimal armassemblyWidth) {
		this.armassemblyWidth = armassemblyWidth;
	}

	@Column(name = "ARMASSEMBLY_WIDTH", nullable = false)
	public BigDecimal getArmassemblyWidth() {
		return armassemblyWidth;
	}

	public void setArmassemblyWidth2(BigDecimal armassemblyWidth2) {
		this.armassemblyWidth2 = armassemblyWidth2;
	}

	@Column(name = "ARMASSEMBLY_WIDTH2", nullable = false)
	public BigDecimal getArmassemblyWidth2() {
		return armassemblyWidth2;
	}

	public void setForce(BigDecimal force) {
		this.force = force;
	}

	@Column(name = "FORCE", nullable = false)
	public BigDecimal getForce() {
		return force;
	}

	public void setCapAngel(BigDecimal capAngel) {
		this.capAngel = capAngel;
	}

	@Column(name = "CAP_ANGEL", nullable = false)
	public BigDecimal getCapAngel() {
		return capAngel;
	}

	public void setArmassemblyTechchange(String armassemblyTechchange) {
		this.armassemblyTechchange = armassemblyTechchange;
	}

	@Column(name = "ARMASSEMBLY_TECHCHANGE", length = 20)
	public String getArmassemblyTechchange() {
		return armassemblyTechchange;
	}

	public void setArmassemblyCode(String armassemblyCode) {
		this.armassemblyCode = armassemblyCode;
	}

	@Column(name = "ARMASSEMBLY_CODE", length = 20)
	public String getArmassemblyCode() {
		return armassemblyCode;
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
		return "Turretpart [gunType=" + gunType + ",armAssemblyno="
				+ armAssemblyno + ",armComponentno=" + armComponentno
				+ ",shankComponentno=" + shankComponentno + ",armDrawingno="
				+ armDrawingno + ",shankDrawingno=" + shankDrawingno
				+ ",armassemblyLength=" + armassemblyLength
				+ ",armassemblyWidth=" + armassemblyWidth
				+ ",armassemblyWidth2=" + armassemblyWidth2 + ",force=" + force
				+ ",capAngel=" + capAngel + ",armassemblyTechchange="
				+ armassemblyTechchange + ",armassemblyCode=" + armassemblyCode
				+ ",id=" + id + "]";
	}

}
