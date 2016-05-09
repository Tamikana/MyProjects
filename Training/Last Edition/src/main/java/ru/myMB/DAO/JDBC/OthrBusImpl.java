package ru.myMB.DAO.JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import ru.myMB.DAO.IOthrBus;
import ru.myMB.indvls.Indvl;
import ru.myMB.indvls.OthrBus;

public class OthrBusImpl implements IOthrBus {

	@Override
	public void fillOthrBuss(ArrayList<Indvl> listIndvls, Connection conn,
			int a, OthrBus othrBus) throws SQLException, IOException {
		PreparedStatement statement14 = null;
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < listIndvls.get(i).getListOthrBus().size(); j++) {
				statement14 = conn
						.prepareStatement("INSERT INTO othrBuss VALUES (?,?,?)");
				statement14.setInt(1, listIndvls.get(i).getListOthrBus().get(j)
						.getInfo_id());
				statement14.setInt(2, 0);
				statement14.setString(3, listIndvls.get(i).getListOthrBus()
						.get(j).getDesc());
				statement14.executeUpdate();
			}
		}

	}

}
