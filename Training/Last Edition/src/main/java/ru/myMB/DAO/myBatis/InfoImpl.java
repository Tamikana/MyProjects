package ru.myMB.DAO.myBatis;

import ru.myMB.indvls.Indvl;
import ru.myMB.indvls.Info;
import ru.myMB.DAO.IInfo;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class InfoImpl implements IInfo {

	@Override
	public void fillInfo(ArrayList<Indvl> listIndvls, Connection conn, int a,
			Info info) throws SQLException, IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources
					.getResourceAsReader("mybatis-configuration.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			session = sqlSessionFactory.openSession();
			session.insert("Info.insert", info);
			session.commit();
		} finally {
			session.close();
		}
	}
}
