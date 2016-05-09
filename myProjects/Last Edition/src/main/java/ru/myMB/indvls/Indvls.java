package ru.myMB.indvls;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Indvls")
@XmlSeeAlso(value = { ru.myMB.indvls.Indvl.class })
public class Indvls {

	@XmlElement(name = "Indvl")
	private ArrayList<Indvl> listIndvls;
	
	public ArrayList<Indvl> getListIndvls() {
		return listIndvls;
	}

	
	public void setListIndvls(ArrayList<Indvl> listIndvls) {
		this.listIndvls = listIndvls;
	}

}
