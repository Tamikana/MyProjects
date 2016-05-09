package ru.myMB.DAO.JDBC;

import ru.myMB.indvls.CrntEmp;
import ru.myMB.indvls.Indvl;
import ru.myMB.DAO.ICrntEmp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class CrntEmpsImpl implements ICrntEmp {
	
	@Override
	public void fillCrntEmps(ArrayList<Indvl> listIndvls, Connection conn, int a, CrntEmp crntEmps)
			throws SQLException, FileNotFoundException, IOException {
		PreparedStatement statement6 = null;
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < listIndvls.get(i).getListCrntEmps().size(); j++) {
				statement6 = conn
						.prepareStatement("INSERT INTO crntEmps VALUES (?,?,?,?,?,?,?,?,?,?)");
				statement6.setInt(1, listIndvls.get(i).getListCrntEmps()
						.get(j).getInfo_id());
				statement6.setInt(2, 0);
				statement6.setString(3, listIndvls.get(i).getListCrntEmps()
						.get(j).getOrgNm());
				statement6.setInt(4, listIndvls.get(i).getListCrntEmps()
						.get(j).getOrgPK());
				statement6.setString(5, listIndvls.get(i).getListCrntEmps()
						.get(j).getStr1());
				statement6.setString(6, listIndvls.get(i).getListCrntEmps()
						.get(j).getStr2());
				statement6.setString(7, listIndvls.get(i).getListCrntEmps()
						.get(j).getCity());
				statement6.setString(8, listIndvls.get(i).getListCrntEmps()
						.get(j).getState());
				statement6.setString(9, listIndvls.get(i).getListCrntEmps()
						.get(j).getCntry());
				statement6.setString(10, listIndvls.get(i).getListCrntEmps()
						.get(j).getPostlCd());
				statement6.executeUpdate();
				long seq = ((com.mysql.jdbc.PreparedStatement) statement6)
						.getLastInsertID();
				int id;
				id = (int) seq;
				for (int k=0; k<listIndvls.get(i).getListCrntEmps()
						.get(j).getListBrnchOfLoc().size();k++)
				{
					listIndvls.get(i).getListCrntEmps()
					.get(j).getListBrnchOfLoc().get(k).setCrntemps_id(id);
					listIndvls.get(i).getListCrntEmps()
					.get(j).getListBrnchOfLoc().get(k).setInfo_id(listIndvls.get(i).getListCrntEmps()
					.get(j).getInfo_id());
				}
				for (int k=0; k<listIndvls.get(i).getListCrntEmps()
						.get(j).getListCrntRgstn().size();k++)
				{
					listIndvls.get(i).getListCrntEmps()
					.get(j).getListCrntRgstn().get(k).setCrntemps_id(id);
					listIndvls.get(i).getListCrntEmps()
					.get(j).getListCrntRgstn().get(k).setInfo_id(listIndvls.get(i).getListCrntEmps()
					.get(j).getInfo_id());
				}
			}
		}

	}

}
