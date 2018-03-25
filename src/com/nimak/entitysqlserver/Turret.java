package com.nimak.entitysqlserver;

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
	 * gun_type:
	 */
	@PropertyDef(label = "gun_type", description = "gun_type:")
	private String gunType;

	/**
	 * gun_drawingno:
	 */
	@PropertyDef(label = "gun_drawingno", description = "gun_drawingno:")
	private String gunDrawingno;

	/**
	 * gunbody_drawingno:
	 */
	@PropertyDef(label = "gunbody_drawingno", description = "gunbody_drawingno:")
	private String gunbodyDrawingno;

	/**
	 * arm_assemblyno_f:
	 */
	@PropertyDef(label = "arm_assemblyno_f", description = "arm_assemblyno_f:")
	private String armAssemblynoF;

	/**
	 * arm_assemblyno_m:
	 */
	@PropertyDef(label = "arm_assemblyno_m", description = "arm_assemblyno_m:")
	private String armAssemblynoM;

	/**
	 * cap_drawingno_f:
	 */
	@PropertyDef(label = "cap_drawingno_f", description = "cap_drawingno_f:")
	private String capDrawingnoF;

	/**
	 * cap_drawingno_m:
	 */
	@PropertyDef(label = "cap_drawingno_m", description = "cap_drawingno_m:")
	private String capDrawingnoM;

	/**
	 * stroke:
	 */
	@PropertyDef(label = "stroke", description = "stroke:")
	private BigDecimal stroke;

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
	 * flange:
	 */
	@PropertyDef(label = "flange", description = "flange:")
	private String flange;

	/**
	 * gun_techchange:
	 */
	@PropertyDef(label = "gun_techchange", description = "gun_techchange:")
	private String gunTechchange;

	/**
	 * id:
	 */
	@PropertyDef(label = "id", description = "id:")
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

	@Column(name = "gun_type", length = 10, nullable = false)
	public String getGunType() {
		return gunType;
	}

	public void setGunDrawingno(String gunDrawingno) {
		this.gunDrawingno = gunDrawingno;
	}

	@Column(name = "gun_drawingno", length = 20, nullable = false)
	public String getGunDrawingno() {
		return gunDrawingno;
	}

	public void setGunbodyDrawingno(String gunbodyDrawingno) {
		this.gunbodyDrawingno = gunbodyDrawingno;
	}

	@Column(name = "gunbody_drawingno", length = 20, nullable = false)
	public String getGunbodyDrawingno() {
		return gunbodyDrawingno;
	}

	public void setArmAssemblynoF(String armAssemblynoF) {
		this.armAssemblynoF = armAssemblynoF;
	}

	@Column(name = "arm_assemblyno_f", length = 20, nullable = false)
	public String getArmAssemblynoF() {
		return armAssemblynoF;
	}

	public void setArmAssemblynoM(String armAssemblynoM) {
		this.armAssemblynoM = armAssemblynoM;
	}

	@Column(name = "arm_assemblyno_m", length = 20, nullable = false)
	public String getArmAssemblynoM() {
		return armAssemblynoM;
	}

	public void setCapDrawingnoF(String capDrawingnoF) {
		this.capDrawingnoF = capDrawingnoF;
	}

	@Column(name = "cap_drawingno_f", length = 20, nullable = false)
	public String getCapDrawingnoF() {
		return capDrawingnoF;
	}

	public void setCapDrawingnoM(String capDrawingnoM) {
		this.capDrawingnoM = capDrawingnoM;
	}

	@Column(name = "cap_drawingno_m", length = 20, nullable = false)
	public String getCapDrawingnoM() {
		return capDrawingnoM;
	}

	public void setStroke(BigDecimal stroke) {
		this.stroke = stroke;
	}

	@Column(name = "stroke", nullable = false)
	public BigDecimal getStroke() {
		return stroke;
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

	public void setFlange(String flange) {
		this.flange = flange;
	}

	@Column(name = "flange", length = 10, nullable = false)
	public String getFlange() {
		return flange;
	}

	public void setGunTechchange(String gunTechchange) {
		this.gunTechchange = gunTechchange;
	}

	@Column(name = "gun_techchange", length = 20)
	public String getGunTechchange() {
		return gunTechchange;
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
