package com.nimak.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * TURRET:
 */
@Entity
@Table(name = "TURRET")
public class Turret implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 焊钳类型:焊钳类型
	 */
	@PropertyDef(label = "焊钳类型", description = "焊钳类型:焊钳类型")
	private String gunType;

	/**
	 * 焊钳图号:焊钳图号
	 */
	@PropertyDef(label = "焊钳图号", description = "焊钳图号:焊钳图号")
	private String gunDrawingno;

	/**
	 * 钳体图号:钳体图号
	 */
	@PropertyDef(label = "钳体图号", description = "钳体图号:钳体图号")
	private String gunbodyDrawingno;

	/**
	 * 静臂部件图号:静臂部件图号
	 */
	@PropertyDef(label = "静臂部件图号", description = "静臂部件图号:静臂部件图号")
	private String armAssemblynoF;

	/**
	 * 动臂部件图号:动臂部件图号
	 */
	@PropertyDef(label = "动臂部件图号", description = "动臂部件图号:动臂部件图号")
	private String armAssemblynoM;

	/**
	 * 电极帽零件图号:电极帽零件图号
	 */
	@PropertyDef(label = "电极帽零件图号", description = "电极帽零件图号:电极帽零件图号")
	private String capDrawingnoF;

	/**
	 * 电极帽零件图号:电极帽零件图号
	 */
	@PropertyDef(label = "电极帽零件图号", description = "电极帽零件图号:电极帽零件图号")
	private String capDrawingnoM;

	/**
	 * 行程:行程
	 */
	@PropertyDef(label = "行程", description = "行程:行程")
	private BigDecimal stroke;

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
	 * 法兰盘位置:法兰盘位置
	 */
	@PropertyDef(label = "法兰盘位置", description = "法兰盘位置:法兰盘位置")
	private String flange;

	/**
	 * 技术更改:技术更改
	 */
	@PropertyDef(label = "技术更改", description = "技术更改:技术更改")
	private String gunTechchange;

	/**
	 * ID:ID
	 */
	@PropertyDef(label = "ID", description = "ID:ID")
	private String id;

	public Turret() {
		super();
	}

	public Turret(String gunType, String gunDrawingno, String gunbodyDrawingno,
			String armAssemblynoF, String armAssemblynoM, String capDrawingnoF,
			String capDrawingnoM, BigDecimal stroke,
			BigDecimal armassemblyLength, BigDecimal armassemblyWidth,
			BigDecimal armassemblyWidth2, BigDecimal force,
			BigDecimal capAngel, String flange, String gunTechchange, String id) {
		super();
		this.gunType = gunType;
		this.gunDrawingno = gunDrawingno;
		this.gunbodyDrawingno = gunbodyDrawingno;
		this.armAssemblynoF = armAssemblynoF;
		this.armAssemblynoM = armAssemblynoM;
		this.capDrawingnoF = capDrawingnoF;
		this.capDrawingnoM = capDrawingnoM;
		this.stroke = stroke;
		this.armassemblyLength = armassemblyLength;
		this.armassemblyWidth = armassemblyWidth;
		this.armassemblyWidth2 = armassemblyWidth2;
		this.force = force;
		this.capAngel = capAngel;
		this.flange = flange;
		this.gunTechchange = gunTechchange;
		this.id = id;
	}

	public void setGunType(String gunType) {
		this.gunType = gunType;
	}

	@Column(name = "GUN_TYPE", length = 10, nullable = false)
	public String getGunType() {
		return gunType;
	}

	public void setGunDrawingno(String gunDrawingno) {
		this.gunDrawingno = gunDrawingno;
	}

	@Column(name = "GUN_DRAWINGNO", length = 20, nullable = false)
	public String getGunDrawingno() {
		return gunDrawingno;
	}

	public void setGunbodyDrawingno(String gunbodyDrawingno) {
		this.gunbodyDrawingno = gunbodyDrawingno;
	}

	@Column(name = "GUNBODY_DRAWINGNO", length = 20, nullable = false)
	public String getGunbodyDrawingno() {
		return gunbodyDrawingno;
	}

	public void setArmAssemblynoF(String armAssemblynoF) {
		this.armAssemblynoF = armAssemblynoF;
	}

	@Column(name = "ARM_ASSEMBLYNO_F", length = 20, nullable = false)
	public String getArmAssemblynoF() {
		return armAssemblynoF;
	}

	public void setArmAssemblynoM(String armAssemblynoM) {
		this.armAssemblynoM = armAssemblynoM;
	}

	@Column(name = "ARM_ASSEMBLYNO_M", length = 20, nullable = false)
	public String getArmAssemblynoM() {
		return armAssemblynoM;
	}

	public void setCapDrawingnoF(String capDrawingnoF) {
		this.capDrawingnoF = capDrawingnoF;
	}

	@Column(name = "CAP_DRAWINGNO_F", length = 20, nullable = false)
	public String getCapDrawingnoF() {
		return capDrawingnoF;
	}

	public void setCapDrawingnoM(String capDrawingnoM) {
		this.capDrawingnoM = capDrawingnoM;
	}

	@Column(name = "CAP_DRAWINGNO_M", length = 20, nullable = false)
	public String getCapDrawingnoM() {
		return capDrawingnoM;
	}

	public void setStroke(BigDecimal stroke) {
		this.stroke = stroke;
	}

	@Column(name = "STROKE", nullable = false)
	public BigDecimal getStroke() {
		return stroke;
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

	public void setFlange(String flange) {
		this.flange = flange;
	}

	@Column(name = "FLANGE", length = 10, nullable = false)
	public String getFlange() {
		return flange;
	}

	public void setGunTechchange(String gunTechchange) {
		this.gunTechchange = gunTechchange;
	}

	@Column(name = "GUN_TECHCHANGE", length = 20)
	public String getGunTechchange() {
		return gunTechchange;
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
		return "Turret [gunType=" + gunType + ",gunDrawingno=" + gunDrawingno
				+ ",gunbodyDrawingno=" + gunbodyDrawingno + ",armAssemblynoF="
				+ armAssemblynoF + ",armAssemblynoM=" + armAssemblynoM
				+ ",capDrawingnoF=" + capDrawingnoF + ",capDrawingnoM="
				+ capDrawingnoM + ",stroke=" + stroke + ",armassemblyLength="
				+ armassemblyLength + ",armassemblyWidth=" + armassemblyWidth
				+ ",armassemblyWidth2=" + armassemblyWidth2 + ",force=" + force
				+ ",capAngel=" + capAngel + ",flange=" + flange
				+ ",gunTechchange=" + gunTechchange + ",id=" + id + "]";
	}

}
