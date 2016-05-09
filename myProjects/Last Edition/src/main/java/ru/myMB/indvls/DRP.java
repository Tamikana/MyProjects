package ru.myMB.indvls;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class DRP {
	@XmlAttribute
	@XmlJavaTypeAdapter(BooleanAdapter.class)
	private String hasRegAction;
	@XmlAttribute
	@XmlJavaTypeAdapter(BooleanAdapter.class)
	private String hasCriminal;
	@XmlAttribute
	@XmlJavaTypeAdapter(BooleanAdapter.class)
	private String hasBankrupt;
	@XmlAttribute
	@XmlJavaTypeAdapter(BooleanAdapter.class)
	private String hasCivilJ;
	@XmlAttribute
	@XmlJavaTypeAdapter(BooleanAdapter.class)
	private String hasBond;
	@XmlAttribute
	@XmlJavaTypeAdapter(BooleanAdapter.class)
	private String hasJudgment;
	@XmlAttribute
	@XmlJavaTypeAdapter(BooleanAdapter.class)
	private String hasInvstgn;
	@XmlAttribute
	@XmlJavaTypeAdapter(BooleanAdapter.class)
	private String hasCustComp;
	@XmlAttribute
	@XmlJavaTypeAdapter(BooleanAdapter.class)
	private String hasTermination;
	private int Info_id;

	public int getInfo_id() {
		return Info_id;
	}
	public void setInfo_id(int info_id) {
		Info_id = info_id;
	}
	public boolean isHasRegAction() {
		return new Boolean(hasRegAction);
	}
	public void setHasRegAction(String hasRegAction) {
		this.hasRegAction = hasRegAction;
	}

	public boolean isHasCriminal() {
		return new Boolean(hasCriminal);
	}

	public void setHasCriminal(String hasCriminal) {
		this.hasCriminal = hasCriminal;
	}

	public boolean isHasBankrupt() {
		return new Boolean(hasBankrupt);
	}

	public void setHasBankrupt(String hasBankrupt) {
		this.hasBankrupt = hasBankrupt;
	}

	public boolean isHasCivilJ() {
		return new Boolean(hasCivilJ);
	}

	public void setHasCivilJ(String hasCivilJ) {
		this.hasCivilJ = hasCivilJ;
	}

	public boolean isHasBond() {
		return new Boolean(hasBond);
	}

	public void setHasBond(String hasBond) {
		this.hasBond = hasBond;
	}

	public boolean isHasJudgment() {
		return new Boolean(hasJudgment);
	}

	public void setHasJudgment(String hasJudgment) {
		this.hasJudgment = hasJudgment;
	}

	public boolean isHasInvstgn() {
		return new Boolean(hasInvstgn);
	}

	public void setHasInvstgn(String hasInvstgn) {
		this.hasInvstgn = hasInvstgn;
	}

	public boolean isHasCustComp() {
		return new Boolean(hasCustComp);
	}

	public void setHasCustComp(String hasCustComp) {
		this.hasCustComp = hasCustComp;
	}

	public boolean isHasTermination() {
		return new Boolean(hasTermination);
	}

	public void setHasTermination(String hasTermination) {
		this.hasTermination = hasTermination;
	}
}
