package ru.myMB.indvls;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Indvl")
@XmlSeeAlso(value = { ru.myMB.indvls.Info.class, ru.myMB.indvls.OthrNm.class,
		ru.myMB.indvls.CrntEmp.class, ru.myMB.indvls.Exm.class, ru.myMB.indvls.Dsgntn.class,
		ru.myMB.indvls.PrevRgstn.class, ru.myMB.indvls.EmpHs.class, ru.myMB.indvls.OthrBus.class,
		ru.myMB.indvls.DRP.class })
public class Indvl {

	@XmlElement(name = "Info")
	private Info info;
	@XmlElement(name = "Exm")
	@XmlElementWrapper(name = "Exms")
	private ArrayList<Exm> ListExms;
	@XmlElement(name = "CrntEmp")
	@XmlElementWrapper(name = "CrntEmps")
	private ArrayList<CrntEmp> listCrntEmps;
	@XmlElement(name = "EmpHs")
	@XmlElementWrapper(name = "EmpHss")
	private ArrayList<EmpHs> listEmpHss;
	@XmlElement(name = "DRP")
	@XmlElementWrapper(name = "DRPs")
	private ArrayList<DRP> listDRPs;
	@XmlElement(name = "Dsgntn")
	@XmlElementWrapper(name = "Dsgntns")
	private ArrayList<Dsgntn> listDsgntns;
	@XmlElement(name = "OthrBus")
	@XmlElementWrapper(name = "OthrBuss")
	private ArrayList<OthrBus> listOthrBus;
	@XmlElement(name = "OthrNm")
	@XmlElementWrapper(name = "OthrNms")
	private ArrayList<OthrNm> listOthrNms;
	@XmlElement(name = "PrevRgstn")
	@XmlElementWrapper(name = "PrevRgstns")
	private ArrayList<PrevRgstn> listPrevRgstns;

	public ArrayList<DRP> getListDRPs() {
		return listDRPs;
	}

	public void setListDRPs(ArrayList<DRP> listDRPs) {
		this.listDRPs = listDRPs;
	}

	public ArrayList<EmpHs> getListEmpHss() {
		return listEmpHss;
	}

	public void setListEmpHss(ArrayList<EmpHs> listEmpHss) {
		this.listEmpHss = listEmpHss;
	}

	public ArrayList<Dsgntn> getListDsgntns() {
		return listDsgntns;
	}

	public void setListDsgntns(ArrayList<Dsgntn> listDsgntns) {
		this.listDsgntns = listDsgntns;
	}

	public ArrayList<OthrBus> getListOthrBus() {
		return listOthrBus;
	}

	public void setListOthrBus(ArrayList<OthrBus> listOthrBus) {
		this.listOthrBus = listOthrBus;
	}

	public ArrayList<PrevRgstn> getListPrevRgstns() {
		return listPrevRgstns;
	}

	public void setListPrevRgstns(ArrayList<PrevRgstn> listPrevRgstns) {
		this.listPrevRgstns = listPrevRgstns;
	}

	public ArrayList<OthrNm> getListOthrNms() {
		return listOthrNms;
	}

	public ArrayList<Exm> getListExms() {
		return ListExms;
	}

	public void setListExms(ArrayList<Exm> listExms) {
		ListExms = listExms;
	}

	public void setListOthrNms(ArrayList<OthrNm> listOthrNms) {
		this.listOthrNms = listOthrNms;
	}

	public ArrayList<CrntEmp> getListCrntEmps() {
		return listCrntEmps;
	}

	public void setListCrntEmps(ArrayList<CrntEmp> listCrntEmps) {
		this.listCrntEmps = listCrntEmps;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

}
