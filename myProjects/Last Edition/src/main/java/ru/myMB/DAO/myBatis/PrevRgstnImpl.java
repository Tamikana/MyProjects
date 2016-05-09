package ru.myMB.DAO.myBatis;

import ru.myMB.indvls.Indvl;
import ru.myMB.indvls.PrevRgstn;
import ru.myMB.DAO.IPrevRgstns;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class PrevRgstnImpl implements IPrevRgstns {

	@Override
	public void fillPrevRgstns(ArrayList<Indvl> listIndvls1, Connection conn6,
			int a, PrevRgstn prevRgstn) throws SQLException, IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources
					.getResourceAsReader("mybatis-configuration.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			session = sqlSessionFactory.openSession();
			session.insert("PrevRgstn.insert", prevRgstn);
			session.commit();
		} finally {
			session.close();
		}
	}

}
