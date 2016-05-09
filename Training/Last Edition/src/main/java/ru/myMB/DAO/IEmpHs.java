package ru.myMB.DAO;

import ru.myMB.indvls.EmpHs;
import ru.myMB.indvls.Indvl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IEmpHs {
	void fillEmpHss(ArrayList<Indvl> listIndvls1, Connection conn6, int a, EmpHs empHs) throws IOException, SQLException;
}
