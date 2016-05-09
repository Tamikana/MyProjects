package ru.myMB.parser.SAX;

import ru.myMB.indvls.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandler extends DefaultHandler {
	private ArrayList<Indvl> listIndvls = new ArrayList<Indvl>();

	public ArrayList<Indvl> getListIndvls() {

		return listIndvls;
	}

	public void setListIndvls(ArrayList<Indvl> listIndvls) {
		this.listIndvls = listIndvls;
	}

	Indvl indvl = null;
	Info info = null;
	String indvlPK1 = null;
	int indvlPK = 0;
	String actvAGReg1 = null;
	boolean actvAGReg;
	OthrNm othrNm = null;
	CrntEmp crntEmp = null;
	CrntRgstn crntRgstn = null;
	BrnchOfLoc brnchOfLoc = null;
	Exm exm = null;
	EmpHs empHs = null;
	DRP dRP = null;
	Dsgntn dsgntn = null;
	OthrBus othrBus = null;
	PrevRgstn prevRgstn = null;
	ArrayList<OthrBus> listOthrBus = null;
	ArrayList<PrevRgstn> listPrevRgstns = null;
	ArrayList<OthrNm> listOthrNms = null;
	ArrayList<CrntEmp> listCrntEmps = null;
	ArrayList<CrntRgstn> listCrntRgstn = null;
	ArrayList<BrnchOfLoc> listBrnchOfLocs = null;
	ArrayList<EmpHs> listEmpHss = null;
	ArrayList<DRP> listDRPs = null;
	ArrayList<Exm> listExms = null;
	ArrayList<Dsgntn> listDsgntns = null;
	public static Logger log = Logger.getLogger(UserHandler.class.getName());

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		switch (qName) {
		case ("Indvl"):
			indvl = new Indvl();
			break;
		case ("Info"):
			info = new Info();
			info.setLastNm(attributes.getValue("lastNm"));
			info.setFirstNm(attributes.getValue("firstNm"));
			info.setMidNm(attributes.getValue("midNm"));
			indvlPK1 = attributes.getValue("indvlPK");
			indvlPK = Integer.parseInt(indvlPK1);
			info.setIndvlPK(indvlPK);
			actvAGReg1 = attributes.getValue("actvAGReg");
			info.setActvAGReg(booleanAdapter(actvAGReg1));
			info.setLink(attributes.getValue("link"));
			indvl.setInfo(info);
			break;
		case ("OthrNms"):
			listOthrNms = new ArrayList<OthrNm>();
			indvl.setListOthrNms(listOthrNms);
			break;
		case ("OthrNm"):
			othrNm = new OthrNm();
			othrNm.setFirstNm(attributes.getValue("firstNm"));
			othrNm.setLastNm(attributes.getValue("lastNm"));
			indvl.getListOthrNms().add(othrNm);
			break;
		case ("CrntEmps"):
			listCrntEmps = new ArrayList<CrntEmp>();
			indvl.setListCrntEmps(listCrntEmps);
			break;
		case ("CrntEmp"):
			crntEmp = new CrntEmp();
			crntEmp.setOrgNm(attributes.getValue("orgNm"));
			String orgPK = attributes.getValue("orgPK");
			crntEmp.setOrgPK(Integer.parseInt(orgPK));
			crntEmp.setStr1(attributes.getValue("str1"));
			if (attributes.getIndex("str2") > -1)
				crntEmp.setStr2(attributes.getValue("str2"));
			else
				crntEmp.setStr2("none");
			crntEmp.setCity(attributes.getValue("city"));
			crntEmp.setState(attributes.getValue("state"));
			crntEmp.setCntry(attributes.getValue("cntry"));
			if (attributes.getIndex("postlCd") > -1) {
				crntEmp.setPostlCd(attributes.getValue("postlCd"));
			} else
				crntEmp.setPostlCd("none");
			break;
		case ("CrntRgstns"):
			listCrntRgstn = new ArrayList<CrntRgstn>();
			crntEmp.setListCrntRgstn(listCrntRgstn);
			break;
		case ("CrntRgstn"):
			crntRgstn = new CrntRgstn();
			crntRgstn.setRegAuth(attributes.getValue("regAuth"));
			crntRgstn.setRegCat(attributes.getValue("regCat"));
			crntRgstn.setSt(attributes.getValue("st"));
			String stDt = attributes.getValue("stDt");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				crntRgstn.setStDt(sdf.parse(stDt));
			} catch (ParseException e) {
				log.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
			crntEmp.getListCrntRgstn().add(crntRgstn);
			break;
		case ("BrnchOfLocs"):
			listBrnchOfLocs = new ArrayList<BrnchOfLoc>();
			crntEmp.setListBrnchOfLoc(listBrnchOfLocs);
			break;
		case ("BrnchOfLoc"):
			brnchOfLoc = new BrnchOfLoc();
			brnchOfLoc.setStr1(attributes.getValue("str1"));
			brnchOfLoc.setCity(attributes.getValue("city"));
			brnchOfLoc.setCntry(attributes.getValue("cntry"));
			if (attributes.getIndex("postlCd") > -1)
				brnchOfLoc.setPostlCd(attributes.getValue("postlCd"));
			else
				brnchOfLoc.setPostlCd("none");
			brnchOfLoc.setState(attributes.getValue("state"));
			crntEmp.getListBrnchOfLoc().add(brnchOfLoc);
			break;
		case ("Exms"):
			listExms = new ArrayList<Exm>();
			indvl.setListExms(listExms);
			break;
		case ("Exm"):
			exm = new Exm();
			exm.setExmNm(attributes.getValue("exmNm"));
			exm.setExmCd(attributes.getValue("exmCd"));
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			String exmDt = attributes.getValue("exmDt");
			try {
				exm.setExmDt(sdf1.parse(exmDt));
			} catch (ParseException e) {
				log.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
			indvl.getListExms().add(exm);
			break;
		case ("Dsgntns"):
			listDsgntns = new ArrayList<Dsgntn>();
			indvl.setListDsgntns(listDsgntns);
			break;
		case ("Dsgntn"):
			dsgntn = new Dsgntn();
			dsgntn.setDsgntnNm(attributes.getValue("dsgntnNm"));
			indvl.getListDsgntns().add(dsgntn);
			break;
		case ("PrevRgstns"):
			listPrevRgstns = new ArrayList<PrevRgstn>();
			indvl.setListPrevRgstns(listPrevRgstns);
			break;
		case ("PrevRgstn"):
			prevRgstn = new PrevRgstn();
			prevRgstn.setOrgNm(attributes.getValue("orgNm"));
			String orgPK1 = attributes.getValue("orgPK");
			prevRgstn.setOrgPK(Integer.parseInt(orgPK1));
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			if (attributes.getIndex("regBeginDt") > -1) {
				String regBeginDt1 = attributes.getValue("regBeginDt");
				try {
					prevRgstn.setRegBeginDt(sdf2.parse(regBeginDt1));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}

			if (attributes.getIndex("regEndDt") > -1) {
				String regEndDt1 = attributes.getValue("regEndDt");
				try {
					prevRgstn.setRegEndDt(sdf2.parse(regEndDt1));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
			indvl.getListPrevRgstns().add(prevRgstn);
			break;
		case ("EmpHss"):
			listEmpHss = new ArrayList<EmpHs>();
			indvl.setListEmpHss(listEmpHss);
			break;
		case ("EmpHs"):
			empHs = new EmpHs();
			empHs.setCity(attributes.getValue("city"));
			empHs.setOrgNm(attributes.getValue("orgNm"));
			empHs.setState(attributes.getValue("state"));
			String fromDt = attributes.getValue("fromDt");
			SimpleDateFormat sdf3 = new SimpleDateFormat("MM/yyyy");
			try {
				empHs.setFromDt(sdf3.parse(fromDt));
			} catch (ParseException e) {
				log.log(Level.SEVERE, e.getLocalizedMessage(), e);
			}
			indvl.getListEmpHss().add(empHs);
			break;
		case ("OthrBuss"):
			listOthrBus = new ArrayList<OthrBus>();
			indvl.setListOthrBus(listOthrBus);
			break;
		case ("OthrBus"):
			othrBus = new OthrBus();
			othrBus.setDesc(attributes.getValue("desc"));
			indvl.getListOthrBus().add(othrBus);
			break;
		case ("DRPs"):
			listDRPs = new ArrayList<DRP>();
			indvl.setListDRPs(listDRPs);
			break;
		case ("DRP"):
			dRP = new DRP();
			String hRA = attributes.getValue("hasRegAction");
			dRP.setHasRegAction(booleanAdapter(hRA));
			String hC = attributes.getValue("hasCriminal");
			dRP.setHasCriminal(booleanAdapter(hC));
			String hB = attributes.getValue("hasBankrupt");
			dRP.setHasBankrupt(booleanAdapter(hB));
			String hCJ = attributes.getValue("hasCivilJudc");
			dRP.setHasCivilJ(booleanAdapter(hCJ));
			String hBo = attributes.getValue("hasBond");
			dRP.setHasBond(booleanAdapter(hBo));
			String hJ = attributes.getValue("hasJudgment");
			dRP.setHasJudgment(booleanAdapter(hJ));
			String hI = attributes.getValue("hasInvstgn");
			dRP.setHasInvstgn(booleanAdapter(hI));
			String hCC = attributes.getValue("hasCustComp");
			dRP.setHasCustComp(booleanAdapter(hCC));
			String hT = attributes.getValue("hasTermination");
			dRP.setHasTermination(booleanAdapter(hT));
			indvl.getListDRPs().add(dRP);
			break;
			default: break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		switch (qName) {
		case ("Indvl"):
			listIndvls.add(indvl);
			break;
		case ("CrntEmps"):
			indvl.getListCrntEmps().add(crntEmp);
			break;
		default: break;
		}
	}

	public String booleanAdapter(String s) {
		if (s.equals("N"))
			return "false";
		else
			return "true";

	}

}
