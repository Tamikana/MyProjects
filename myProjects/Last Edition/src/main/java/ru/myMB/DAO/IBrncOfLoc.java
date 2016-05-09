package ru.myMB.DAO;

import ru.myMB.indvls.BrnchOfLoc;
import ru.myMB.indvls.Indvl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IBrncOfLoc {
	void fillBrnchOfLocs(ArrayList<Indvl> listIndvls1, Connection conn4, int a, BrnchOfLoc brnchOfLocs)
			throws SQLException, FileNotFoundException, IOException;
}
