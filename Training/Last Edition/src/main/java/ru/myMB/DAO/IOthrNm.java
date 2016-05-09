package ru.myMB.DAO;

import ru.myMB.indvls.Indvl;
import ru.myMB.indvls.OthrNm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IOthrNm {
	void fillOthrNmsDAO(ArrayList<Indvl> listIndvls1, Connection conn1, int a, OthrNm othrNm) throws SQLException, IOException;
}
