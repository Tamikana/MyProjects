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

import ru.myMB.DAO.IEmpHs;
import ru.myMB.indvls.EmpHs;
import ru.myMB.indvls.Indvl;

public class EmpHssImpl implements IEmpHs {

	@Override
	public void fillEmpHss(ArrayList<Indvl> listIndvls, Connection conn, int a,
			EmpHs empHs) throws IOException, SQLException {
		SqlSession session = null;
		try {
			Reader reader = Resources
					.getResourceAsReader("mybatis-configuration.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			session = sqlSessionFactory.openSession();
			session.insert("EmpHs.insert", empHs);
			session.commit();
		} finally {
			session.close();
		}
	}
}
