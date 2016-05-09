package ru.myMB.DAO.JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import ru.myMB.DAO.IPrevRgstns;
import ru.myMB.indvls.Indvl;
import ru.myMB.indvls.PrevRgstn;

public class PrevRgstnsImpl implements IPrevRgstns {

	@Override
	public void fillPrevRgstns(ArrayList<Indvl> listIndvls, Connection conn,
			int a, PrevRgstn prevRgstn) throws SQLException, IOException {
		PreparedStatement statement14 = null;
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < listIndvls.get(i).getListPrevRgstns().size(); j++) {
				statement14 = conn
						.prepareStatement("INSERT INTO prevRgstns VALUES (?,?,?,?,?,?)");
				statement14.setInt(1, listIndvls.get(i).getListPrevRgstns()
						.get(j).getInfo_id());
				statement14.setInt(2, 0);
				statement14.setString(3, listIndvls.get(i).getListPrevRgstns()
						.get(j).getOrgNm());
				statement14.setInt(4, listIndvls.get(i).getListPrevRgstns()
						.get(j).getOrgPK());
				java.sql.Date regBeginDt = new java.sql.Date(listIndvls.get(i)
						.getListPrevRgstns().get(j).getRegBeginDt().getTime());
				statement14.setDate(5, regBeginDt);
				java.sql.Date regEndDt = new java.sql.Date(listIndvls.get(i)
						.getListPrevRgstns().get(j).getRegEndDt().getTime());
				statement14.setDate(6, regEndDt);
				statement14.executeUpdate();
			}
		}
	}

}
