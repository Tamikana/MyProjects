package ru.myMB.DAO;

import ru.myMB.indvls.DRP;
import ru.myMB.indvls.Indvl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IDRP {
	void fillDRPs(ArrayList<Indvl> listIndvls1, Connection conn6, int a, DRP drp)
			throws SQLException, IOException;
}
