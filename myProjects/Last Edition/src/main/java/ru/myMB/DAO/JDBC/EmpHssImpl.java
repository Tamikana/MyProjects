package ru.myMB.DAO.JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import ru.myMB.DAO.IEmpHs;
import ru.myMB.indvls.EmpHs;
import ru.myMB.indvls.Indvl;

public class EmpHssImpl implements IEmpHs {

	@Override
	public void fillEmpHss(ArrayList<Indvl> listIndvls, Connection conn, int a,
			EmpHs empHs) throws IOException, SQLException {
		PreparedStatement statement14 = null;
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < listIndvls.get(i).getListEmpHss().size(); j++) {
				statement14 = conn
						.prepareStatement("INSERT INTO empHss VALUES (?,?,?,?,?,?)");
				statement14.setInt(1, listIndvls.get(i).getListEmpHss().get(j)
						.getInfo_id());
				statement14.setInt(2, 0);
				java.sql.Date fromDt = new java.sql.Date(listIndvls.get(i)
						.getListEmpHss().get(j).getFromDt().getTime());
				statement14.setDate(3, fromDt);
				statement14.setString(4,
						listIndvls.get(i).getListEmpHss().get(j).getOrgNm());
				statement14.setString(5,
						listIndvls.get(i).getListEmpHss().get(j).getCity());
				statement14.setString(6,
						listIndvls.get(i).getListEmpHss().get(j).getState());
				statement14.executeUpdate();
			}
		}
	}
}
