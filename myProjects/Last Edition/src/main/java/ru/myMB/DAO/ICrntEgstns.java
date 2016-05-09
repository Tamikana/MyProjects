package ru.myMB.DAO;

import ru.myMB.indvls.CrntRgstn;
import ru.myMB.indvls.Indvl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ICrntEgstns {
	
	void fillCrntRgstns(ArrayList<Indvl> listIndvls1, Connection conn3, int a, CrntRgstn crntRgstn)
			throws SQLException, FileNotFoundException, IOException;
}
