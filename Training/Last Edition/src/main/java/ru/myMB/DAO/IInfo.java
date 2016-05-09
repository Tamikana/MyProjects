package ru.myMB.DAO;

import ru.myMB.indvls.Indvl;
import ru.myMB.indvls.Info;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IInfo {
	void fillInfo(ArrayList<Indvl> listIndvls1, Connection conn, int a, Info info)
			throws SQLException, IOException;
}
