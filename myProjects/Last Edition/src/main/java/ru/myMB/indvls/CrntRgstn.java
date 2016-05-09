package ru.myMB.indvls;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class CrntRgstn {
	@XmlAttribute
	private String regAuth;
	@XmlAttribute
	private String regCat;
	@XmlAttribute
	private String st;
	@XmlAttribute
	private Date stDt;
	private int info_id;
	private int crntemps_id;

	public int getInfo_id() {
		return info_id;
	}

	public void setInfo_id(int info_id) {
		this.info_id = info_id;
	}

	public int getCrntemps_id() {
		return crntemps_id;
	}

	public void setCrntemps_id(int crntemps_id) {
		this.crntemps_id = crntemps_id;
	}

	public String getRegAuth() {
		return regAuth;
	}

	public void setRegAuth(String regAuth) {
		this.regAuth = regAuth;
	}

	public String getRegCat() {
		return regCat;
	}

	public void setRegCat(String regCat) {
		this.regCat = regCat;
	}

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}

	public Date getStDt() {
		return stDt;
	}

	public void setStDt(Date date) {
		this.stDt = date;
	}

}
