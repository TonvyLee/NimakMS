package com.nimak.entitysqlserver;

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
	 * gun_type:
	 */
	@PropertyDef(label = "gun_type", description = "gun_type:")
	private String gunType;

	/**
	 * arm_assemblyno:
	 */
	@PropertyDef(label = "arm_assemblyno", description = "arm_assemblyno:")
	private String armAssemblyno;

	/**
	 * arm_componentno:
	 */
	@PropertyDef(label = "arm_componentno", description = "arm_componentno:")
	private String armComponentno;

	/**
	 * shank_componentno:
	 */
	@PropertyDef(label = "shank_componentno", description = "shank_componentno:")
	private String shankComponentno;

	/**
	 * arm_drawingno:
	 */
	@PropertyDef(label = "arm_drawingno", description = "arm_drawingno:")
	private String armDrawingno;

	/**
	 * shank_drawingno:
	 */
	@PropertyDef(label = "shank_drawingno", description = "shank_drawingno:")
	private String shankDrawingno;

	/**
	 * armassembly_length:
	 */
	@PropertyDef(label = "armassembly_length", description = "armassembly_length:")
	private BigDecimal armassemblyLength;

	/**
	 * armassembly_width:
	 */
	@PropertyDef(label = "armassembly_width", description = "armassembly_width:")
	private BigDecimal armassemblyWidth;

	/**
	 * armassembly_width2:
	 */
	@PropertyDef(label = "armassembly_width2", description = "armassembly_width2:")
	private BigDecimal armassemblyWidth2;

	/**
	 * force:
	 */
	@PropertyDef(label = "force", description = "force:")
	private BigDecimal force;

	/**
	 * cap_angel:
	 */
	@PropertyDef(label = "cap_angel", description = "cap_angel:")
	private BigDecimal capAngel;

	/**
	 * armassembly_techchange:
	 */
	@PropertyDef(label = "armassembly_techchange", description = "armassembly_techchange:")
	private String armassemblyTechchange;

	/**
	 * armassembly_code:
	 */
	@PropertyDef(label = "armassembly_code", description = "armassembly_code:")
	private String armassemblyCode;

	/**
	 * id:
	 */
	@PropertyDef(label = "id", description = "id:")
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

	@Column(name = "gun_type", length = 10, nullable = false)
	public String getGunType() {
		return gunType;
	}

	public void setArmAssemblyno(String armAssemblyno) {
		this.armAssemblyno = armAssemblyno;
	}

	@Column(name = "arm_assemblyno", length = 20, nullable = false)
	public String getArmAssemblyno() {
		return armAssemblyno;
	}

	public void setArmComponentno(String armComponentno) {
		this.armComponentno = armComponentno;
	}

	@Column(name = "arm_componentno", length = 20, nullable = false)
	public String getArmComponentno() {
		return armComponentno;
	}

	public void setShankComponentno(String shankComponentno) {
		this.shankComponentno = shankComponentno;
	}

	@Column(name = "shank_componentno", length = 20, nullable = false)
	public String getShankComponentno() {
		return shankComponentno;
	}

	public void setArmDrawingno(String armDrawingno) {
		this.armDrawingno = armDrawingno;
	}

	@Column(name = "arm_drawingno", length = 20, nullable = false)
	public String getArmDrawingno() {
		return armDrawingno;
	}

	public void setShankDrawingno(String shankDrawingno) {
		this.shankDrawingno = shankDrawingno;
	}

	@Column(name = "shank_drawingno", length = 20, nullable = false)
	public String getShankDrawingno() {
		return shankDrawingno;
	}

	public void setArmassemblyLength(BigDecimal armassemblyLength) {
		this.armassemblyLength = armassemblyLength;
	}

	@Column(name = "armassembly_length", nullable = false)
	public BigDecimal getArmassemblyLength() {
		return armassemblyLength;
	}

	public void setArmassemblyWidth(BigDecimal armassemblyWidth) {
		this.armassemblyWidth = armassemblyWidth;
	}

	@Column(name = "armassembly_width", nullable = false)
	public BigDecimal getArmassemblyWidth() {
		return armassemblyWidth;
	}

	public void setArmassemblyWidth2(BigDecimal armassemblyWidth2) {
		this.armassemblyWidth2 = armassemblyWidth2;
	}

	@Column(name = "armassembly_width2", nullable = false)
	public BigDecimal getArmassemblyWidth2() {
		return armassemblyWidth2;
	}

	public void setForce(BigDecimal force) {
		this.force = force;
	}

	@Column(name = "force", nullable = false)
	public BigDecimal getForce() {
		return force;
	}

	public void setCapAngel(BigDecimal capAngel) {
		this.capAngel = capAngel;
	}

	@Column(name = "cap_angel", nullable = false)
	public BigDecimal getCapAngel() {
		return capAngel;
	}

	public void setArmassemblyTechchange(String armassemblyTechchange) {
		this.armassemblyTechchange = armassemblyTechchange;
	}

	@Column(name = "armassembly_techchange", length = 20)
	public String getArmassemblyTechchange() {
		return armassemblyTechchange;
	}

	public void setArmassemblyCode(String armassemblyCode) {
		this.armassemblyCode = armassemblyCode;
	}

	@Column(name = "armassembly_code", length = 20)
	public String getArmassemblyCode() {
		return armassemblyCode;
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
