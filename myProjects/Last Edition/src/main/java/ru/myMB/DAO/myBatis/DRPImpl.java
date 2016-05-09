package ru.myMB.DAO.myBatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import ru.myMB.DAO.IDRP;
import ru.myMB.indvls.DRP;
import ru.myMB.indvls.Indvl;

public class DRPImpl implements IDRP {

	public void fillDRPs(ArrayList<Indvl> listIndvls, Connection conn, int a, DRP drp)
			throws SQLException, IOException {
		SqlSession session = null;
		try
		{
		Reader reader = Resources
				.getResourceAsReader("mybatis-configuration.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(reader);
		session = sqlSessionFactory.openSession();
		session.insert("DRP.insert", drp);
		session.commit();
		}
		finally
		{
		session.close();
		}
	}
	
}
