package ru.myMB.DAO.myBatis;

import ru.myMB.indvls.Indvl;
import ru.myMB.indvls.OthrNm;
import ru.myMB.DAO.IOthrNm;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class OthrNmImpl implements IOthrNm {

	@Override
	public void fillOthrNmsDAO(ArrayList<Indvl> listIndvls1, Connection conn1,
			int a, OthrNm othrNm) throws SQLException, IOException {

		SqlSession session = null;
		try {
			Reader reader = Resources
					.getResourceAsReader("mybatis-configuration.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			session = sqlSessionFactory.openSession();
			session.insert("OthrNm.insert", othrNm);
			session.commit();
		} finally {
			session.close();
		}
	}

}
