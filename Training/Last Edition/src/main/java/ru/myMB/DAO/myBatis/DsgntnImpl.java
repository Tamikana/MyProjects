package ru.myMB.DAO.myBatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import ru.myMB.DAO.IDsgntns;
import ru.myMB.indvls.Dsgntn;
import ru.myMB.indvls.Indvl;

public class DsgntnImpl implements IDsgntns {

	@Override
	public void fillDsgntns(ArrayList<Indvl> listIndvls, Connection conn,
			int a, Dsgntn dsgntn) throws IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources
					.getResourceAsReader("mybatis-configuration.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			session = sqlSessionFactory.openSession();
			session.insert("Dsgntn.insert", dsgntn);
			session.commit();
		} finally {
			session.close();
		}
	}

}
