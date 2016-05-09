package ru.myMB.indvls;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class PrevRgstn {
	@XmlAttribute
	private String orgNm;
	@XmlAttribute
	private int orgPK;
	@XmlAttribute
	private Date regBeginDt;
	@XmlAttribute
	private Date regEndDt;
	private int Info_id;

	public int getInfo_id() {
		return Info_id;
	}

	public void setInfo_id(int info_id) {
		Info_id = info_id;
	}

	public String getOrgNm() {
		return orgNm;
	}

	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}

	public int getOrgPK() {
		return orgPK;
	}

	public void setOrgPK(int orgPK) {
		this.orgPK = orgPK;
	}

	public Date getRegBeginDt() {
		return regBeginDt;
	}

	public void setRegBeginDt(Date regBeginDt) {
		this.regBeginDt = regBeginDt;
	}

	public Date getRegEndDt() {
		return regEndDt;
	}

	public void setRegEndDt(Date regEndDt) {
		this.regEndDt = regEndDt;
	}
}
