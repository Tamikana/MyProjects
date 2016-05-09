package ru.myMB.DAO.myBatis;

import ru.myMB.indvls.BrnchOfLoc;
import ru.myMB.indvls.Count;
import ru.myMB.indvls.CrntEmp;
import ru.myMB.indvls.CrntRgstn;
import ru.myMB.indvls.DRP;
import ru.myMB.indvls.Dsgntn;
import ru.myMB.indvls.EmpHs;
import ru.myMB.indvls.Exm;
import ru.myMB.indvls.Indvl;
import ru.myMB.indvls.Info;
import ru.myMB.indvls.OthrBus;
import ru.myMB.indvls.OthrNm;
import ru.myMB.indvls.PrevRgstn;
import ru.myMB.DAO.IIndvl;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class IndvlSImpl implements IIndvl {

	@Override
	public Indvl selectIndvl(Connection conn, Connection conn2, int num)
			throws SQLException, IOException {
		SqlSession session = null;
		Indvl indvl = new Indvl();
		try {
			Reader reader = Resources
					.getResourceAsReader("mybatis-configuration.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			session = sqlSessionFactory.openSession();
			Info info = (Info) session.selectOne("Indvl.getById", num);
			indvl.setInfo(info);
			session.commit();
		} finally {
			session.close();
		}
		return indvl;
	}

	public int selectCrntEmpCount(int num) throws IOException {
		SqlSession session = null;
		int countOthrBus = 0;
		try {
			Reader reader = Resources
					.getResourceAsReader("mybatis-configuration.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			session = sqlSessionFactory.openSession();
			countOthrBus = session.selectOne("Indvl.crntEmpCount", num);
			session.commit();
		} finally {
			session.close();
		}

		return countOthrBus;
	}

	public Indvl selectOthrBus(int num, Indvl indvl) throws IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources
					.getResourceAsReader("mybatis-configuration.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			session = sqlSessionFactory.openSession();
			List<OthrBus> listOthrBus = session.selectList(
					"Indvl.getByIdOthrBus", num);
			indvl.setListOthrBus((ArrayList<OthrBus>) listOthrBus);
			session.commit();
		} finally {
			session.close();
		}
		return indvl;
	}

	public Indvl selectOthrNm(int num, Indvl indvl) throws IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources
					.getResourceAsReader("mybatis-configuration.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			session = sqlSessionFactory.openSession();
			List<OthrNm> listOthrNm = session.selectList("Indvl.getByIdOthrNm",
					num);
			indvl.setListOthrNms((ArrayList<OthrNm>) listOthrNm);
			session.commit();
		} finally {
			session.close();
		}
		return indvl;
	}

	public Indvl selectCrntEmp(int num, Indvl indvl) throws IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources
					.getResourceAsReader("mybatis-configuration.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			session = sqlSessionFactory.openSession();

			List<CrntEmp> listCrntEmp = session.selectList(
					"Indvl.getByIdCrntEmps", num);
			indvl.setListCrntEmps((ArrayList<CrntEmp>) listCrntEmp);
			session.commit();
		} finally {
			session.close();
		}
		return indvl;
	}

	@Override
	public Indvl selectBrnchOfLoc(Indvl indvl, Connection conn, int num, int c)
			throws IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources
					.getResourceAsReader("mybatis-configuration.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			session = sqlSessionFactory.openSession();
			for (int i = 0; i < selectCrntEmpCount(num); i++) {
				if (selectCrntEmpCount(num) > 0) {
					List<BrnchOfLoc> listBrnchOfLoc = session.selectList(
							"Indvl.getByIdBranchOfLoc", indvl.getListCrntEmps()
									.get(i).getCrntemp_id());
					indvl.getListCrntEmps()
							.get(i)
							.setListBrnchOfLoc(
									(ArrayList<BrnchOfLoc>) listBrnchOfLoc);
				}
			}
			session.commit();
		} finally {
			session.close();
		}
		return indvl;
	}

	@Override
	public Indvl selectCrntRgstn(Indvl indvl, Connection conn, int num, int c)
			throws SQLException, IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources
					.getResourceAsReader("mybatis-configuration.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			session = sqlSessionFactory.openSession();
			for (int i = 0; i < selectCrntEmpCount(num); i++) {
				if (selectCrntEmpCount(num) > 0) {
					List<CrntRgstn> listCrntRgstn = session.selectList(
							"Indvl.getByIdCrntRgstn", indvl.getListCrntEmps()
									.get(i).getCrntemp_id());
					indvl.getListCrntEmps()
							.get(i)
							.setListCrntRgstn(
									(ArrayList<CrntRgstn>) listCrntRgstn);
				}
			}
			session.commit();
		} finally {
			session.close();
		}
		return indvl;
	}

	@Override
	public Indvl selectDRP(Indvl indvl, Connection conn, int num)
			throws SQLException, IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources
					.getResourceAsReader("mybatis-configuration.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			session = sqlSessionFactory.openSession();
			List<DRP> listDPR = session.selectList("Indvl.getByIdDRP", num);
			indvl.setListDRPs((ArrayList<DRP>) listDPR);
			session.commit();
		} finally {
			session.close();
		}
		return indvl;
	}

	@Override
	public Indvl selectExm(Indvl indvl, Connection conn, int num)
			throws SQLException, IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources
					.getResourceAsReader("mybatis-configuration.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			session = sqlSessionFactory.openSession();
			List<Exm> listExm = session.selectList("Indvl.getByIdExm", num);
			indvl.setListExms((ArrayList<Exm>) listExm);
			session.commit();
		} finally {
			session.close();
		}
		return indvl;
	}

	@Override
	public Indvl selectEmpHS(Indvl indvl, Connection conn, int num)
			throws SQLException, IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources
					.getResourceAsReader("mybatis-configuration.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			session = sqlSessionFactory.openSession();
			List<EmpHs> listEmpHs = session.selectList("Indvl.getByIdEmpHss",
					num);
			indvl.setListEmpHss((ArrayList<EmpHs>) listEmpHs);
			session.commit();
		} finally {
			session.close();
		}
		return indvl;
	}

	@Override
	public Indvl selectPrevRgstns(Indvl indvl, Connection conn, int num)
			throws SQLException, IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources
					.getResourceAsReader("mybatis-configuration.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			session = sqlSessionFactory.openSession();

			List<PrevRgstn> listPrevRgstn = session.selectList(
					"Indvl.getByIdPrevRgstn", num);
			indvl.setListPrevRgstns((ArrayList<PrevRgstn>) listPrevRgstn);
			session.commit();
		} finally {
			session.close();
		}
		return indvl;
	}

	@Override
	public Indvl selectDsgntn(int num, Connection conn, Indvl indvl)
			throws IOException, SQLException {
		SqlSession session = null;
		try {
			Reader reader = Resources
					.getResourceAsReader("mybatis-configuration.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			session = sqlSessionFactory.openSession();
			List<Dsgntn> listDsgntn = session.selectList("Indvl.getByIdDsgntn",
					num);
			indvl.setListDsgntns((ArrayList<Dsgntn>) listDsgntn);
			session.commit();
		} finally {
			session.close();
		}

		return indvl;
	}
	@Override
	public ArrayList<Integer> IndvlExmEmpHs(Connection conn)
			throws SQLException, IOException {
		SqlSession session = null;
		ArrayList<Integer> listExmEmpHss = new ArrayList<Integer>();
		try {
			Reader reader = Resources
					.getResourceAsReader("mybatis-configuration.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			session = sqlSessionFactory.openSession();
			List<Exm> listExm = session
					.selectList("IndvlSelectExmEmpHs.getByCountExmEmpHs");
			for (int i = 0; i < listExm.size(); i++) {
				listExmEmpHss.add(listExm.get(i).getInfo_id());
			}
			session.commit();
		} finally {
			session.close();
		}
		return listExmEmpHss;
	}

	@Override
	public Count countExm(Connection conn, Count count) throws IOException {
		Reader reader = Resources
				.getResourceAsReader("mybatis-configuration.xml");
		SqlSession session = null;
		try {
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			session = sqlSessionFactory.openSession();
			List<Integer> listCountExm = session
					.selectList("IndvlSelectExmEmpHs.exmCount");
			count.setListCountExm((ArrayList<Integer>) listCountExm);
			session.commit();
		} finally {
			session.close();
		}
		return count;
	}

	@Override
	public Count countEmpHs(Connection conn, Count count) throws SQLException,
			IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources
					.getResourceAsReader("mybatis-configuration.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			session = sqlSessionFactory.openSession();
			List<Integer> listCountEmpHs = session
					.selectList("IndvlSelectExmEmpHs.empHsCount");
			count.setListCountEmpHs((ArrayList<Integer>) listCountEmpHs);
			session.commit();
		} finally {
			session.close();
		}
		return count;
	}
}