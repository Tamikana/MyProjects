package ru.myMB.indvls;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class EmpHs {
	@XmlAttribute
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date fromDt;
	@XmlAttribute
	private String orgNm;
	@XmlAttribute
	private String city;
	@XmlAttribute
	private String state;
	private int Info_id;

	public int getInfo_id() {
		return Info_id;
	}

	public void setInfo_id(int info_id) {
		Info_id = info_id;
	}

	public Date getFromDt() {
		return fromDt;
	}

	public void setFromDt(Date date) {
		this.fromDt = date;
	}

	public String getOrgNm() {
		return orgNm;
	}

	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
