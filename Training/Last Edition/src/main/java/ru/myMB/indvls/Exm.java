package ru.myMB.indvls;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Exm {
	@XmlAttribute
	private String exmNm;
	@XmlAttribute
	private String exmCd;
	@XmlAttribute
	private Date exmDt;
	private int Info_id;
	private int id;

	@SuppressWarnings("unused")
	private int getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(int id) {
		this.id = id;
	}

	public int getInfo_id() {
		return Info_id;
	}

	public void setInfo_id(int info_id) {
		Info_id = info_id;
	}

	public String getExmCd() {
		return exmCd;
	}

	public void setExmCd(String exmCd) {
		this.exmCd = exmCd;
	}

	public String getExmNm() {
		return exmNm;
	}

	public void setExmNm(String exmNm) {
		this.exmNm = exmNm;
	}

	public Date getExmDt() {
		return exmDt;
	}

	public void setExmDt(Date exmDt) {
		this.exmDt = exmDt;
	}

}
