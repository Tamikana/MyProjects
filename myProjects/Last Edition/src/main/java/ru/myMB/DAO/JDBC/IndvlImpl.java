package ru.myMB.DAO.JDBC;

import ru.myMB.indvls.BrnchOfLoc;
import ru.myMB.indvls.Count;
import ru.myMB.indvls.CrntEmp;
import ru.myMB.indvls.CrntRgstn;
import ru.myMB.indvls.DRP;
import ru.myMB.indvls.Dsgntn;
import ru.myMB.indvls.EmpHs;
import ru.myMB.indvls.Exm;
import ru.myMB.indvls.Indvl;
import ru.myMB.indvls.Info;
import ru.myMB.indvls.OthrBus;
import ru.myMB.indvls.OthrNm;
import ru.myMB.indvls.PrevRgstn;
import ru.myMB.DAO.IIndvl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IndvlImpl implements IIndvl{
	
	public int c=0;
	int nExm = 1;
	int nEmp = 1;
	
	@Override
	public Indvl selectIndvl(Connection conn, Connection conn2, int num) throws SQLException, IOException {

		Indvl indvl = new Indvl();
		indvl = selectInfo(indvl, conn, conn2, num);
		indvl = selectDRP(indvl, conn2, num);
		indvl = selectExm(indvl, conn2, num);
		indvl = selectEmpHS(indvl, conn2, num);
		indvl = selectPrevRgstns(indvl, conn2, num);
		indvl = selectDsgntn(num, conn2, indvl);
		indvl = selectBrnchOfLoc(indvl, conn2, num, c);
		indvl = selectCrntRgstn(indvl, conn2, num, c);
		
		return indvl;
	}

	public Indvl selectInfo (Indvl indvl, Connection conn, Connection conn2, int num) throws SQLException	{
		PreparedStatement statement2 = null;
		PreparedStatement statement3 = null;
		PreparedStatement statement4 = null;
		PreparedStatement statement5 = null;
		
		String selectSQL = "SELECT * FROM info "
				+ "left join othrnms on othrnms.info_id = info.id "
				+ "left join othrbuss on othrbuss.info_id = info.id "
				+ "left join crntemps on crntemps.info_id = info.id "
				+ "where info.id = ?";
		String countDesc= "SELECT COUNT(*) FROM othrbuss "
				+ "where info_id = ?";
		String countOthrNm= "SELECT COUNT(*) FROM othrnms "
				+ "where info_id = ?";
		String countCrntEmp= "SELECT COUNT(*) FROM crntemps "
				+ "where info_id = ?";
		
		
		
		statement2 = conn.prepareStatement(selectSQL);
		statement2.setInt(1, num);
		ResultSet rs = statement2.executeQuery();
		
		statement3 = conn2.prepareStatement(countDesc);
		statement3.setInt(1, num);
		ResultSet rsDesc = statement3.executeQuery();
		rsDesc.next();
		int a = rsDesc.getInt(1);
		rsDesc.close();
		int aDesc=0;
		
		statement4 = conn2.prepareStatement(countOthrNm);
		statement4.setInt(1, num);
		ResultSet rsOthrNm = statement4.executeQuery();
		rsOthrNm.next();
		int b = rsOthrNm.getInt(1);
		rsDesc.close();
		int bOthrNm=0;
		
		statement5 = conn2.prepareStatement(countCrntEmp);
		statement5.setInt(1, num);
		ResultSet rsCrntEmp = statement5.executeQuery();
		rsCrntEmp.next();
		c = rsCrntEmp.getInt(1);
		rsCrntEmp.close();
		int cCrntEmp=0;
		
		Info info = new Info();
		ArrayList<OthrNm> listOthrNm = new ArrayList<OthrNm>();
		indvl.setListOthrNms(listOthrNm);
		ArrayList<OthrBus> listOthrBus = new ArrayList<OthrBus>();
		indvl.setListOthrBus(listOthrBus);
		ArrayList<CrntEmp> listCrntEmp = new ArrayList<CrntEmp>();
		indvl.setListCrntEmps(listCrntEmp);
		
		while (rs.next()) {
			info.setFirstNm(rs.getString("info.firstNm"));
			info.setLastNm(rs.getString("info.lastNm"));
			info.setMidNm(rs.getString("midNm"));
			info.setIndvlPK(rs.getInt("indvlPK"));
			info.setLink(rs.getString("link"));
			info.setActvAGReg(rs.getString("actvAGReg"));
			info.setInfo_id(rs.getInt("id"));
			indvl.setInfo(info);
			
			if (bOthrNm<b)
			{
			OthrNm othrNm = new OthrNm();
			othrNm.setFirstNm(rs.getString("othrnms.firstNm"));
			othrNm.setLastNm(rs.getString("othrnms.lastNm"));
			indvl.getListOthrNms().add(othrNm);
			bOthrNm++;
			}
			
			if (aDesc<a)
			{
			OthrBus othrBus = new OthrBus();
			othrBus.setDesc(rs.getString("description"));
			aDesc++;
			indvl.getListOthrBus().add(othrBus);
			}
			
			if (cCrntEmp<c)
			{
			CrntEmp crntEmp = new CrntEmp();
			crntEmp.setCity(rs.getString("city"));
			crntEmp.setCntry(rs.getString("cntry"));
			crntEmp.setCrntemp_id(rs.getInt("id"));
			crntEmp.setOrgNm(rs.getString("orgNm"));
			crntEmp.setOrgPK(rs.getInt("orgPK"));
			crntEmp.setPostlCd(rs.getString("postlCd"));
			crntEmp.setState(rs.getString("state"));
			crntEmp.setStr1(rs.getString("str1"));
			crntEmp.setStr2(rs.getString("str2"));
			indvl.getListCrntEmps().add(crntEmp);
			cCrntEmp++;
			}
		}
		
		return indvl;
		
		
	}
@Override
	public Indvl selectDRP (Indvl indvl, Connection conn, int num) throws SQLException{
		PreparedStatement statement6 = null;
		String selectSQLDRP = "SELECT * FROM drps "
				+ "where info_id = ?";
		statement6 = conn.prepareStatement(selectSQLDRP);
		statement6.setInt(1, num);
		ResultSet rs6 = statement6.executeQuery();
		ArrayList <DRP> listDRP = new ArrayList <DRP> ();
		indvl.setListDRPs(listDRP);
		while (rs6.next()) 
			{
			DRP dRP = new DRP();
			dRP.setHasBankrupt(rs6.getString("hasBankrupt"));
			dRP.setHasBond(rs6.getString("hasBond"));
			dRP.setHasCivilJ(rs6.getString("hasCivilJudc"));
			dRP.setHasCriminal(rs6.getString("hasCriminal"));
			dRP.setHasCustComp(rs6.getString("hasCustComp"));
			dRP.setHasInvstgn(rs6.getString("hasInvstgn"));
			dRP.setHasJudgment(rs6.getString("hasJudgment"));
			dRP.setHasRegAction(rs6.getString("hasRegAction"));
			dRP.setHasTermination(rs6.getString("hasTermination"));
			indvl.getListDRPs().add(dRP);
			}
		
		return indvl;
	}
@Override
	public Indvl selectExm (Indvl indvl, Connection conn, int num) throws SQLException{
		PreparedStatement statement6 = null;
		String selectSQL = "SELECT * FROM exms "
				+ "where info_id = ?";
		statement6 = conn.prepareStatement(selectSQL);
		statement6.setInt(1, num);
		ResultSet rs6 = statement6.executeQuery();
		ArrayList <Exm> listExms = new ArrayList <Exm> ();
		indvl.setListExms(listExms);
		while (rs6.next()) 
			{
			Exm exm = new Exm();
			exm.setExmCd(rs6.getString("exmCd"));
			exm.setExmDt(rs6.getDate("exmDt"));
			exm.setExmNm(rs6.getString("exmNm"));
			indvl.getListExms().add(exm);
			}
		return indvl;
	}
	@Override
	public Indvl selectEmpHS (Indvl indvl, Connection conn, int num) throws SQLException{
		PreparedStatement statement6 = null;
		String selectSQL = "SELECT * FROM emphss "
				+ "where info_id = ?";
		statement6 = conn.prepareStatement(selectSQL);
		statement6.setInt(1, num);
		ResultSet rs6 = statement6.executeQuery();
		ArrayList <EmpHs> listEmpHss = new ArrayList <EmpHs> ();
		indvl.setListEmpHss(listEmpHss);
		while (rs6.next()) 
			{
		EmpHs empHs = new EmpHs();
		empHs.setCity(rs6.getString("city"));
		empHs.setFromDt(rs6.getDate("fromDt"));
		empHs.setOrgNm(rs6.getString("orgNm"));
		empHs.setState(rs6.getString("state"));
			indvl.getListEmpHss().add(empHs);
			}
		return indvl;
	}
@Override
	public Indvl selectPrevRgstns (Indvl indvl, Connection conn, int num) throws SQLException{
		PreparedStatement statement6 = null;
		String selectSQL = "SELECT * FROM prevrgstns "
				+ "where info_id = ?";
		statement6 = conn.prepareStatement(selectSQL);
		statement6.setInt(1, num);
		ResultSet rs6 = statement6.executeQuery();
		ArrayList <PrevRgstn> listPrevRgstns = new ArrayList <PrevRgstn> ();
		indvl.setListPrevRgstns(listPrevRgstns);
		while (rs6.next()) 
			{
			PrevRgstn prevRgstn = new PrevRgstn();
			prevRgstn.setOrgNm(rs6.getString("orgNm"));
			prevRgstn.setOrgPK(rs6.getInt("orgPK"));
			prevRgstn.setRegBeginDt(rs6.getDate("regBeginDt"));
			prevRgstn.setRegEndDt(rs6.getDate("regEndDt"));
			indvl.getListPrevRgstns().add(prevRgstn);
			}
		return indvl;
	}
@Override
	public Indvl selectBrnchOfLoc (Indvl indvl, Connection conn, int num, int c) throws SQLException{
		PreparedStatement statement6 = null;
		String selectSQL = "SELECT * FROM brnchoflocs "
				+ "where info_id = ?";
		for (int i=0; i<c; i++)
		{
		statement6 = conn.prepareStatement(selectSQL);
		statement6.setInt(1, num);
		ResultSet rs6 = statement6.executeQuery();
		ArrayList <BrnchOfLoc> listBrnchOfLoc = new ArrayList <BrnchOfLoc> ();
		
		indvl.getListCrntEmps().get(i).setListBrnchOfLoc(listBrnchOfLoc);
		
		while (rs6.next()) 
			{
			BrnchOfLoc brnchOfLoc = new BrnchOfLoc();
			brnchOfLoc.setCity(rs6.getString("city"));
			brnchOfLoc.setCntry(rs6.getString("cntry"));
			brnchOfLoc.setPostlCd(rs6.getString("postlCd"));
			brnchOfLoc.setState(rs6.getString("state"));
			brnchOfLoc.setStr1(rs6.getString("str1"));
			indvl.getListCrntEmps().get(i).getListBrnchOfLoc().add(brnchOfLoc);
			}
		}
		return indvl;
	}
@Override
	public Indvl selectCrntRgstn (Indvl indvl, Connection conn, int num, int c) throws SQLException{
		PreparedStatement statement6 = null;
		String selectSQL = "SELECT * FROM crntrgstns "
				+ "where info_id = ?";
		for (int i=0; i<c; i++)
		{
		statement6 = conn.prepareStatement(selectSQL);
		statement6.setInt(1, num);
		ResultSet rs6 = statement6.executeQuery();
		ArrayList <CrntRgstn> listCrntRgstn = new ArrayList <CrntRgstn> ();
		
		indvl.getListCrntEmps().get(i).setListCrntRgstn(listCrntRgstn);
		
		while (rs6.next()) 
			{
			CrntRgstn crntRgstn = new CrntRgstn();
			crntRgstn.setRegAuth(rs6.getString("regAuth"));
			crntRgstn.setRegCat(rs6.getString("regCat"));
			crntRgstn.setSt(rs6.getString("st"));
			crntRgstn.setStDt(rs6.getDate("stDt"));
			indvl.getListCrntEmps().get(i).getListCrntRgstn().add(crntRgstn);
			}
		}
		return indvl;
	}
@Override
	public Indvl selectDsgntn (int num, Connection conn, Indvl indvl) throws IOException, SQLException{
		PreparedStatement statement6 = null;
		String selectSQL = "SELECT * FROM dsgntns "
				+ "where info_id = ?";
		statement6 = conn.prepareStatement(selectSQL);
		statement6.setInt(1, num);
		ResultSet rs6 = statement6.executeQuery();
		ArrayList <Dsgntn> listDsgntn = new ArrayList <Dsgntn> ();
		indvl.setListDsgntns(listDsgntn);
		while (rs6.next()) 
			{
			Dsgntn dsgntn = new Dsgntn();
			dsgntn.setDsgntnNm(rs6.getString("dsgntnNm"));
			indvl.getListDsgntns().add(dsgntn);
			}
		return indvl;
	}
@Override
public ArrayList <Integer> IndvlExmEmpHs (Connection conn) throws SQLException
{
	ArrayList <Integer> listIndvlId = selectIndvlExmEmpHs (conn);
	return listIndvlId;
}

public ArrayList <Integer> selectIndvlExmEmpHs (Connection conn) throws SQLException
{
	ArrayList <Integer> listIndvlId = new ArrayList <Integer> ();
	ArrayList <Exm> listIndvlExm = new ArrayList <Exm> ();
	
	PreparedStatement statement= null;
	
	String selectSQL = "SELECT exms.info_id, count(exms.info_id) "
			+ "FROM exms where exms.info_id IN "
			+ "(SELECT emphss.info_id FROM emphss "
			+ "group by emphss.info_id having count(*)>?) "
			+ "group by exms.info_id having count(*)>?";
	statement = conn.prepareStatement(selectSQL);
	statement.setInt(1, nExm);
	statement.setInt(2, nEmp);
	ResultSet rs = statement.executeQuery();
	
	while (rs.next()) {
	Exm exm = new Exm();
	exm.setInfo_id(rs.getInt("Info_id"));
	listIndvlExm.add(exm);
	}
	for (int i=0; i<listIndvlExm.size();i++)
	{
		listIndvlId.add(listIndvlExm.get(i).getInfo_id());
	}
	return listIndvlId;
}

@Override
public Count countExm (Connection conn, Count count) throws SQLException
{
PreparedStatement statement= null;
	
	String selectSQL = "SELECT count(info_id) FROM exms group by exms.info_id having count(info_id)>?";
	statement = conn.prepareStatement(selectSQL);
	statement.setInt(1, nExm);
	ResultSet rs = statement.executeQuery();
	ArrayList <Integer> listCountExm = new ArrayList <Integer> ();
	count.setListCountExm(listCountExm);
	while (rs.next()) {
	count.getListCountExm().add(rs.getInt(1));
	}
return count;	
}

@Override
public Count countEmpHs (Connection conn, Count count) throws SQLException
{
    PreparedStatement statement= null;
	String selectSQL = "SELECT count(*) FROM emphss	group by emphss.info_id having count(*)>?;";
	statement = conn.prepareStatement(selectSQL);
	statement.setInt(1, nEmp);
	ResultSet rs = statement.executeQuery();
	ArrayList <Integer> listCountEmpHs = new ArrayList <Integer> ();
	count.setListCountEmpHs(listCountEmpHs);
	while (rs.next()) {
	count.getListCountEmpHs().add(rs.getInt(1));
	}
return count;	
}
}
