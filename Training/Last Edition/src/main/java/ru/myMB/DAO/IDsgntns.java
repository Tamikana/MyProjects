package ru.myMB.DAO;

import ru.myMB.indvls.Dsgntn;
import ru.myMB.indvls.Indvl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IDsgntns {
	void fillDsgntns(ArrayList<Indvl> listIndvls1, Connection conn6, int a, Dsgntn dsgntn) throws IOException, SQLException;
}
