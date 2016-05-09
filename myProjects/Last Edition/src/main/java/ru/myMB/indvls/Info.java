package ru.myMB.indvls;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class Info {
	@XmlAttribute
	private String lastNm;
	@XmlAttribute
	private String firstNm;
	@XmlAttribute
	private String midNm;
	@XmlAttribute
	private int indvlPK;
	@XmlAttribute
	@XmlJavaTypeAdapter(BooleanAdapter.class)
	private String actvAGReg;
	@XmlAttribute
	private String link;
	private int info_id;
	
	public int getInfo_id() {
		return info_id;
	}


	public void setInfo_id(int info_id) {
		this.info_id = info_id;
	}


	public boolean isActvAGReg() {
		return new Boolean (actvAGReg);
	}

	
	public void setActvAGReg(String actvAGReg) {
		this.actvAGReg = actvAGReg;
	}
	
	public String getLastNm() {
		return lastNm;
	}

	public void setLastNm(String lastNm) {
		this.lastNm = lastNm;
	}

	public String getFirstNm() {
		return firstNm;
	}

	public void setFirstNm(String firstNm) {
		this.firstNm = firstNm;
	}

	public String getMidNm() {
		return midNm;
	}

	public void setMidNm(String midNm) {
		this.midNm = midNm;
	}

	public int getIndvlPK() {
		return indvlPK;
	}

	public void setIndvlPK(int indvlPK) {
		this.indvlPK = indvlPK;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
