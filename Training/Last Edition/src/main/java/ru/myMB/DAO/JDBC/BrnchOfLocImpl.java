package ru.myMB.DAO.JDBC;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import ru.myMB.DAO.IBrncOfLoc;
import ru.myMB.indvls.BrnchOfLoc;
import ru.myMB.indvls.Indvl;

public class BrnchOfLocImpl implements IBrncOfLoc {

	@Override
	public void fillBrnchOfLocs(ArrayList<Indvl> listIndvls, Connection conn,
			int a, BrnchOfLoc brnchOfLocs) throws SQLException,
			FileNotFoundException, IOException {
		PreparedStatement statement10 = null;
		for (int i = 0; i < a; i++) {
			for (int k = 0; k < listIndvls.get(i).getListCrntEmps().size(); k++) {
				for (int j = 0; j < listIndvls.get(i).getListCrntEmps().get(k)
						.getListBrnchOfLoc().size(); j++) {
					statement10 = conn
							.prepareStatement("INSERT INTO brnchOfLocs VALUES (?,?,?,?,?,?,?,?)");
					statement10.setInt(1, listIndvls.get(i).getListCrntEmps()
							.get(k).getListBrnchOfLoc().get(j).getInfo_id());
					statement10
							.setInt(2, listIndvls.get(i).getListCrntEmps()
									.get(k).getListBrnchOfLoc().get(j)
									.getCrntemps_id());
					statement10.setInt(3, 0);
					statement10.setString(4, listIndvls.get(i)
							.getListCrntEmps().get(k).getListBrnchOfLoc()
							.get(j).getStr1());
					statement10.setString(5, listIndvls.get(i)
							.getListCrntEmps().get(k).getListBrnchOfLoc()
							.get(j).getCity());
					statement10.setString(6, listIndvls.get(i)
							.getListCrntEmps().get(k).getListBrnchOfLoc()
							.get(j).getState());
					statement10.setString(7, listIndvls.get(i)
							.getListCrntEmps().get(k).getListBrnchOfLoc()
							.get(j).getCntry());
					statement10.setString(8, listIndvls.get(i)
							.getListCrntEmps().get(k).getListBrnchOfLoc()
							.get(j).getPostlCd());
					statement10.executeUpdate();
				}
			}
		}
	}
}
