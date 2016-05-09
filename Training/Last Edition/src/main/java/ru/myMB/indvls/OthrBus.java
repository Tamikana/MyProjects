package ru.myMB.indvls;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class OthrBus {
	@XmlAttribute
	private String desc;
	private int Info_id;

	public int getInfo_id() {
		return Info_id;
	}

	public void setInfo_id(int info_id) {
		Info_id = info_id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
