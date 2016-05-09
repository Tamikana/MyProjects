package ru.myMB.indvls;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class BrnchOfLoc {

	private int info_id;
	private int crntemps_id;
	private int id;
	@XmlAttribute
	private String str1;
	@XmlAttribute
	private String city;
	@XmlAttribute
	private String state;
	@XmlAttribute
	private String cntry;
	@XmlAttribute
	private String postlCd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getStr1() {
		if (str1 == null)
			return "none";
		else
			return str1;
	}

	public void setStr1(String str1) {
		this.str1 = str1;
	}

	public String getCity() {
		if (city == null)
			return "none";
		else
			return city;
	}

	public void setCity(String city) {

		this.city = city;

	}

	public String getState() {
		if (state == null)
			return "none";
		else
			return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCntry() {
		if (cntry == null)
			return "none";
		else
			return cntry;
	}

	public void setCntry(String cntry) {
		this.cntry = cntry;

	}

	public String getPostlCd() {
		if (postlCd == null)
			return "none";
		else
			return postlCd;
	}

	public void setPostlCd(String postlCd) {
		this.postlCd = postlCd;

	}

}
