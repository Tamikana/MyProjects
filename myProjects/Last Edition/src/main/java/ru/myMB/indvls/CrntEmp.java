package ru.myMB.indvls;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(value = { ru.myMB.indvls.BrnchOfLoc.class,
		ru.myMB.indvls.CrntRgstn.class })
public class CrntEmp {
	@XmlAttribute
	private String orgNm;
	@XmlAttribute
	private int orgPK;
	@XmlAttribute
	private String str1;
	@XmlAttribute
	private String str2;
	@XmlAttribute
	private String city;
	@XmlAttribute
	private String state;
	@XmlAttribute
	private String cntry;
	@XmlAttribute
	private String postlCd;
	@XmlElement(name = "BrnchOfLoc")
	@XmlElementWrapper(name = "BrnchOfLocs")
	private ArrayList<BrnchOfLoc> listBrnchOfLoc;
	@XmlElement(name = "CrntRgstn")
	@XmlElementWrapper(name = "CrntRgstns")
	private ArrayList<CrntRgstn> listCrntRgstn;
	private int info_id;
	private int crntemp_id;

	public int getInfo_id() {
		return info_id;
	}

	public void setInfo_id(int info_id) {
		this.info_id = info_id;
	}

	public ArrayList<CrntRgstn> getListCrntRgstn() {
		return listCrntRgstn;
	}

	public void setListCrntRgstn(ArrayList<CrntRgstn> listCrntRgstn) {
		this.listCrntRgstn = listCrntRgstn;
	}

	public String getStr2() {
		return str2;
	}

	public ArrayList<BrnchOfLoc> getListBrnchOfLoc() {
		return listBrnchOfLoc;
	}

	public void setListBrnchOfLoc(ArrayList<BrnchOfLoc> listBrnchOfLoc) {
		this.listBrnchOfLoc = listBrnchOfLoc;
	}

	public void setStr2(String str2) {
		this.str2 = str2;
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

	public String getStr1() {
		return str1;
	}

	public void setStr1(String str1) {
		this.str1 = str1;
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

	public String getCntry() {
		return cntry;
	}

	public void setCntry(String cntry) {
		this.cntry = cntry;
	}

	public String getPostlCd() {
		return postlCd;
	}

	public void setPostlCd(String postlCd) {
		this.postlCd = postlCd;
	}

	public int getCrntemp_id() {
		return crntemp_id;
	}

	public void setCrntemp_id(int crntemp_id) {
		this.crntemp_id = crntemp_id;
	}
}
