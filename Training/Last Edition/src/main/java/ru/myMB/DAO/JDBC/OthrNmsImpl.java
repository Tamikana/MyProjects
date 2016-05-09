package ru.myMB.DAO.JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import ru.myMB.DAO.IOthrNm;
import ru.myMB.indvls.Indvl;
import ru.myMB.indvls.OthrNm;

public class OthrNmsImpl implements IOthrNm {

	@Override
	public void fillOthrNmsDAO(ArrayList<Indvl> listIndvls, Connection conn,
			int a, OthrNm othrNm) throws SQLException, IOException {
		PreparedStatement statement4 = null;
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < listIndvls.get(i).getListOthrNms().size(); j++) {
				statement4 = conn
						.prepareStatement("INSERT INTO othrNms VALUES (?,?,?,?)");
				statement4.setInt(1, listIndvls.get(i).getListOthrNms().get(j)
						.getInfo_id());
				statement4.setInt(2, 0);
				statement4.setString(3,
						listIndvls.get(i).getListOthrNms().get(j).getLastNm());
				statement4.setString(4,
						listIndvls.get(i).getListOthrNms().get(j).getFirstNm());
				statement4.executeUpdate();
			}
		}
	}
}