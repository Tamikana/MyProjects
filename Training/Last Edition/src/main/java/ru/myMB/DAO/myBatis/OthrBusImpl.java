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

import ru.myMB.indvls.Indvl;
import ru.myMB.indvls.OthrBus;
import ru.myMB.DAO.IOthrBus;

public class OthrBusImpl implements IOthrBus {

	@Override
	public void fillOthrBuss(ArrayList<Indvl> listIndvls, Connection conn,
			int a, OthrBus othrBus) throws SQLException, IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources
					.getResourceAsReader("mybatis-configuration.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			session = sqlSessionFactory.openSession();
			session.insert("OthrBus.insert", othrBus);
			session.commit();
		} finally {
			session.close();
		}
	}

}
