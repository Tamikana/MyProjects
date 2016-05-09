package ru.myMB.DAO;

import ru.myMB.indvls.CrntEmp;
import ru.myMB.indvls.Indvl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ICrntEmp {
	void fillCrntEmps(ArrayList<Indvl> listIndvls1, Connection conn2, int a, CrntEmp crntEmps) throws SQLException, FileNotFoundException, IOException;
}
