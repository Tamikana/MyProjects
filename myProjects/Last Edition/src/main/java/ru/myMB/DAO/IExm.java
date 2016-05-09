package ru.myMB.DAO;

import ru.myMB.indvls.Exm;
import ru.myMB.indvls.Indvl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IExm {
	void fillExm(ArrayList<Indvl> listIndvls1, Connection conn5, int a, Exm exm) throws SQLException, IOException;
}
