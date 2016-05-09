package ru.myMB.DAO.JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import ru.myMB.DAO.IDsgntns;
import ru.myMB.indvls.Dsgntn;
import ru.myMB.indvls.Indvl;

public class DsgntnsImpl implements IDsgntns {

	@Override
	public void fillDsgntns(ArrayList<Indvl> listIndvls, Connection conn,
			int a, Dsgntn dsgntn) throws IOException, SQLException {
		PreparedStatement statement14 = null;
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < listIndvls.get(i).getListDsgntns().size(); j++) {
				statement14 = conn
						.prepareStatement("INSERT INTO dsgntns VALUES (?,?,?)");
				statement14.setInt(1, listIndvls.get(i).getListDsgntns().get(j)
						.getInfo_id());
				statement14.setInt(2, 0);
				statement14.setString(3, listIndvls.get(i).getListDsgntns()
						.get(j).getDsgntnNm());
				statement14.executeUpdate();
			}
		}

	}

}
