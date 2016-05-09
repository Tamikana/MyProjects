package ru.myMB.DAO.JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import ru.myMB.DAO.IDRP;
import ru.myMB.indvls.DRP;
import ru.myMB.indvls.Indvl;

public class DRPImpl implements IDRP {

	@Override
	public void fillDRPs(ArrayList<Indvl> listIndvls, Connection conn, int a,
			DRP drp) throws SQLException, IOException {

		PreparedStatement statement14 = null;
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < listIndvls.get(i).getListDRPs().size(); j++) {
				statement14 = conn
						.prepareStatement("INSERT INTO dRPs VALUES (?,?,?,?,?,?,?,?,?,?,?)");
				statement14.setInt(1, listIndvls.get(i).getListDRPs().get(j)
						.getInfo_id());
				statement14.setInt(2, 0);
				statement14.setBoolean(3, listIndvls.get(i).getListDRPs()
						.get(j).isHasRegAction());
				statement14.setBoolean(4, listIndvls.get(i).getListDRPs()
						.get(j).isHasCriminal());
				statement14.setBoolean(5, listIndvls.get(i).getListDRPs()
						.get(j).isHasBankrupt());
				statement14.setBoolean(6, listIndvls.get(i).getListDRPs()
						.get(j).isHasCivilJ());
				statement14.setBoolean(7, listIndvls.get(i).getListDRPs()
						.get(j).isHasBond());
				statement14.setBoolean(8, listIndvls.get(i).getListDRPs()
						.get(j).isHasJudgment());
				statement14.setBoolean(9, listIndvls.get(i).getListDRPs()
						.get(j).isHasInvstgn());
				statement14.setBoolean(10,
						listIndvls.get(i).getListDRPs().get(j).isHasCustComp());
				statement14.setBoolean(11,
						listIndvls.get(i).getListDRPs().get(j)
								.isHasTermination());
				statement14.executeUpdate();
			}
		}

	}
}
