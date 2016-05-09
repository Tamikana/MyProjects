package ru.myMB.DAO.JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import ru.myMB.DAO.IInfo;
import ru.myMB.indvls.Indvl;
import ru.myMB.indvls.Info;

public class InfoImpl implements IInfo {

	@Override
	public void fillInfo(ArrayList<Indvl> listIndvls, Connection conn, int a,
			Info info) throws SQLException, IOException {
		PreparedStatement statement2 = null;
		for (int i = 0; i < a; i++) {
			statement2 = conn
					.prepareStatement("INSERT INTO info  VALUES (?,?,?,?,?,?,?)");
			statement2.setInt(1, 0);
			statement2.setString(2, listIndvls.get(i).getInfo().getLastNm());
			statement2.setString(3, listIndvls.get(i).getInfo().getFirstNm());
			statement2.setString(4, listIndvls.get(i).getInfo().getMidNm());
			statement2.setInt(5, listIndvls.get(i).getInfo().getIndvlPK());
			statement2.setBoolean(6, listIndvls.get(i).getInfo().isActvAGReg());
			statement2.setString(7, listIndvls.get(i).getInfo().getLink());
			statement2.executeUpdate();
			long seq = ((com.mysql.jdbc.PreparedStatement) statement2)
					.getLastInsertID();
			int id;
			id = (int) seq;
			listIndvls.get(i).getInfo().setInfo_id(id);
			for (int j = 0; j < listIndvls.get(i).getListCrntEmps().size(); j++) {
				listIndvls.get(i).getListCrntEmps().get(j).setInfo_id(id);
			}
			for (int j = 0; j < listIndvls.get(i).getListDRPs().size(); j++) {
				listIndvls.get(i).getListDRPs().get(j).setInfo_id(id);
			}
			for (int j = 0; j < listIndvls.get(i).getListDsgntns().size(); j++) {
				listIndvls.get(i).getListDsgntns().get(j).setInfo_id(id);
			}
			for (int j = 0; j < listIndvls.get(i).getListEmpHss().size(); j++) {
				listIndvls.get(i).getListEmpHss().get(j).setInfo_id(id);
			}
			for (int j = 0; j < listIndvls.get(i).getListExms().size(); j++) {
				listIndvls.get(i).getListExms().get(j).setInfo_id(id);
			}
			for (int j = 0; j < listIndvls.get(i).getListOthrNms().size(); j++) {
				listIndvls.get(i).getListOthrNms().get(j).setInfo_id(id);
			}
			for (int j = 0; j < listIndvls.get(i).getListOthrBus().size(); j++) {
				listIndvls.get(i).getListOthrBus().get(j).setInfo_id(id);
			}
			for (int j = 0; j < listIndvls.get(i).getListPrevRgstns().size(); j++) {
				listIndvls.get(i).getListPrevRgstns().get(j).setInfo_id(id);
			}
		}
	}

}
