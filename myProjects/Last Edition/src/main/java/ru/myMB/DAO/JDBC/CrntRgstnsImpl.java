package ru.myMB.DAO.JDBC;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import ru.myMB.DAO.ICrntEgstns;
import ru.myMB.indvls.CrntRgstn;
import ru.myMB.indvls.Indvl;

public class CrntRgstnsImpl implements ICrntEgstns {

	@Override
	public void fillCrntRgstns(ArrayList<Indvl> listIndvls, Connection conn,
			int a, CrntRgstn crntRgstn) throws SQLException,
			FileNotFoundException, IOException {
		PreparedStatement statement8 = null;
		for (int i = 0; i < a; i++) {
			for (int k = 0; k < listIndvls.get(i).getListCrntEmps().size(); k++) {
				for (int j = 0; j < listIndvls.get(i).getListCrntEmps().get(k)
						.getListCrntRgstn().size(); j++) {
					statement8 = conn
							.prepareStatement("INSERT INTO crntRgstns VALUES (?,?,?,?,?,?,?)");
					statement8.setInt(1, listIndvls.get(i).getListCrntEmps()
							.get(k).getListCrntRgstn().get(j).getInfo_id());
					statement8.setInt(2, listIndvls.get(i).getListCrntEmps()
							.get(k).getListCrntRgstn().get(j).getCrntemps_id());
					statement8.setInt(3, 0);
					statement8.setString(4, listIndvls.get(i).getListCrntEmps()
							.get(k).getListCrntRgstn().get(j).getRegAuth());
					statement8.setString(5, listIndvls.get(i).getListCrntEmps()
							.get(k).getListCrntRgstn().get(j).getRegCat());
					statement8.setString(6, listIndvls.get(i).getListCrntEmps()
							.get(k).getListCrntRgstn().get(j).getSt());
					java.sql.Date stDt = new java.sql.Date(listIndvls.get(i)
							.getListCrntEmps().get(k).getListCrntRgstn().get(j)
							.getStDt().getTime());
					statement8.setDate(7, stDt);
					statement8.executeUpdate();
				}
			}
		}
	}
}
