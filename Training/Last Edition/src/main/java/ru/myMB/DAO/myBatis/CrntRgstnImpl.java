package ru.myMB.DAO.myBatis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import ru.myMB.DAO.ICrntEgstns;
import ru.myMB.indvls.CrntRgstn;
import ru.myMB.indvls.Indvl;

public class CrntRgstnImpl implements ICrntEgstns {

	@Override
	public void fillCrntRgstns(ArrayList<Indvl> listIndvls, Connection conn,
			int a, CrntRgstn crntRgstn) throws SQLException,
			FileNotFoundException, IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources
					.getResourceAsReader("mybatis-configuration.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			session = sqlSessionFactory.openSession();
			session.insert("CrntRgstn.insert", crntRgstn);
			session.commit();
		} finally {
			session.close();
		}
	}

}
