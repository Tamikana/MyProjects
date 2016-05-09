package ru.myMB.DAO;

import ru.myMB.indvls.Indvl;
import ru.myMB.indvls.PrevRgstn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IPrevRgstns {
	void fillPrevRgstns(ArrayList<Indvl> listIndvls1, Connection conn6,
			int a, PrevRgstn prevRgstn) throws SQLException, IOException;
}
