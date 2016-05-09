package ru.myMB.DAO;

import ru.myMB.indvls.Indvl;
import ru.myMB.indvls.OthrBus;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IOthrBus {
	void fillOthrBuss(ArrayList<Indvl> listIndvls1, Connection conn6, int a, OthrBus othrBus) throws SQLException, IOException;
}
