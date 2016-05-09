package ru.myMB.DAO.JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import ru.myMB.DAO.IExm;
import ru.myMB.indvls.Exm;
import ru.myMB.indvls.Indvl;

public class ExmsImpl implements IExm {

	@Override
	public void fillExm(ArrayList<Indvl> listIndvls, Connection conn, int a,
			Exm exm) throws SQLException, IOException {
		PreparedStatement statement12 = null;
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < listIndvls.get(i).getListExms().size(); j++) {
				statement12 = conn
						.prepareStatement("INSERT INTO exms VALUES (?,?,?,?,?)");
				statement12.setInt(1, listIndvls.get(i).getListExms().get(j)
						.getInfo_id());
				statement12.setInt(2, 0);
				statement12.setString(3, listIndvls.get(i).getListExms().get(j)
						.getExmCd());
				statement12.setString(4, listIndvls.get(i).getListExms().get(j)
						.getExmNm());
				java.sql.Date exmDt = new java.sql.Date(listIndvls.get(i)
						.getListExms().get(j).getExmDt().getTime());
				statement12.setDate(5, exmDt);
				statement12.executeUpdate();
			}
		}
	}
}
