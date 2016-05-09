package ru.myMB.DAO;

import ru.myMB.indvls.Count;
import ru.myMB.indvls.Indvl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IIndvl {
	Indvl selectIndvl(Connection conn, Connection conn2, int num) throws SQLException, IOException;
	Indvl selectDRP (Indvl indvl, Connection conn, int num) throws SQLException, IOException;
	Indvl selectExm (Indvl indvl, Connection conn, int num) throws SQLException, IOException;
	Indvl selectEmpHS (Indvl indvl, Connection conn, int num) throws SQLException, IOException;
	Indvl selectPrevRgstns (Indvl indvl, Connection conn, int num) throws SQLException, IOException;
	Indvl selectDsgntn (int num, Connection conn, Indvl indvl) throws IOException, SQLException;
	Indvl selectBrnchOfLoc (Indvl indvl, Connection conn, int num, int c) throws IOException, SQLException;
	Indvl selectCrntRgstn (Indvl indvl, Connection conn, int num, int c) throws SQLException, IOException;
	ArrayList <Integer> IndvlExmEmpHs (Connection conn) throws SQLException, IOException;
	Count countExm (Connection conn, Count count) throws SQLException, IOException;
	Count countEmpHs (Connection conn, Count count) throws SQLException, IOException;
}
