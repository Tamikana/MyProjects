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

import ru.myMB.DAO.IExm;
import ru.myMB.indvls.Exm;
import ru.myMB.indvls.Indvl;

public class ExmImpl implements IExm {

	@Override
	public void fillExm(ArrayList<Indvl> listIndvls, Connection conn, int a,
			Exm exm) throws SQLException, IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources
					.getResourceAsReader("mybatis-configuration.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			session = sqlSessionFactory.openSession();
			session.insert("Exm.insert", exm);
			session.commit();
		} finally {
			session.close();
		}
	}

}
