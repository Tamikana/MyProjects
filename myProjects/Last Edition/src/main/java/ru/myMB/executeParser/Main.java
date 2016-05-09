package ru.myMB.executeParser;

import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBException;

import ru.myMB.DAO.JDBC.BrnchOfLocImpl;
import ru.myMB.DAO.JDBC.CrntEmpsImpl;
import ru.myMB.DAO.JDBC.CrntRgstnsImpl;
import ru.myMB.DAO.JDBC.DRPImpl;
import ru.myMB.DAO.JDBC.DsgntnsImpl;
import ru.myMB.DAO.JDBC.EmpHssImpl;
import ru.myMB.DAO.JDBC.ExmsImpl;
import ru.myMB.DAO.JDBC.IndvlImpl;
import ru.myMB.DAO.JDBC.InfoImpl;
import ru.myMB.DAO.JDBC.OthrBusImpl;
import ru.myMB.DAO.JDBC.OthrNmsImpl;
import ru.myMB.DAO.JDBC.PrevRgstnsImpl;
import ru.myMB.indvls.BrnchOfLoc;
import ru.myMB.indvls.Count;
import ru.myMB.indvls.CrntEmp;
import ru.myMB.indvls.CrntRgstn;
import ru.myMB.indvls.DRP;
import ru.myMB.indvls.Dsgntn;
import ru.myMB.indvls.EmpHs;
import ru.myMB.indvls.Exm;
import ru.myMB.indvls.Indvl;
import ru.myMB.indvls.Indvls;
import ru.myMB.indvls.Info;
import ru.myMB.indvls.OthrBus;
import ru.myMB.indvls.OthrNm;
import ru.myMB.indvls.PrevRgstn;
import ru.myMB.parser.JAXB.JaxbParser;
import ru.myMB.parser.SAX.Parser;
import ru.myMB.executeParser.ConnectionPool;

;

public class Main {

	public static Logger log = Logger.getLogger(Main.class.getName());
	public static int a = 100;

	public static int num = 1;

	public static void main(String[] arga) throws Exception {

		try {
			File file = new File("src/main/resources/IA_Indvl_Feeds1.xml");

			// first realization - JAXB parser
			JaxbParser jaxbparser = new JaxbParser();
			Indvls indvls = (Indvls) jaxbparser.getObject(file, Indvls.class);
			// int a = indvls.getListIndvls().size();
			// second realization - SAX parser
			// Parser parser = new Parser();
			// Indvls indvls = (Indvls) parser.getObject(file, Indvls.class);

			// fill table version 1

			MyBatisInsert mbi = new MyBatisInsert();
			mbi.insertInfo(indvls, a);
			indvls = count(indvls);
			mbi.insertCrntEmp(indvls, a);
			indvls = count2(indvls);
			mbi.insertBrnchOfLoc(indvls, a);
			mbi.insertCrntRgstn(indvls, a);
			mbi.insertOthrNm(indvls, a);
			mbi.insertExm(indvls, a);
			mbi.insertDsgntn(indvls, a);
			mbi.inserPrevRgstn(indvls, a);
			mbi.inserEmpHs(indvls, a);
			mbi.inserOthrBus(indvls, a);
			mbi.insertOthrNm(indvls, a);
			mbi.inserDRP(indvls, a);
			// first realization select

			ArrayList<Indvl> listIndvlExmEmpHs = mbi.selectIndvlExmEmpHs();
			for (int i = 0; i < listIndvlExmEmpHs.size(); i++) {
				test(listIndvlExmEmpHs.get(i));
				log.info("number of exams: "
						+ mbi.setCountExm().getListCountExm().get(i));
				log.info("number of empHs: "
						+ mbi.setCountExm().getListCountEmpHs().get(i));
			}

			// fill table version 2
			// databaseWork(indvls.getListIndvls(), a);

			// select version 2

		} catch (JAXBException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}

		// select first metod
		/*
		 * Main executor = new Main(); // executor.init(); Connection conn =
		 * executor.GetConnection(); Connection conn2 =
		 * executor.GetConnection(); IndvlImpl indvlExmEmpHsDAO = new
		 * IndvlImpl(); Count count = new Count(); count =
		 * indvlExmEmpHsDAO.countExm(conn2, count); count =
		 * indvlExmEmpHsDAO.countEmpHs(conn2, count); for (int i = 0; i <
		 * indvlExmEmpHsDAO.IndvlExmEmpHs(conn2).size(); i++) { IndvlImpl
		 * indvlDAO = new IndvlImpl(); Indvl indvlSelect =
		 * indvlDAO.selectIndvl(conn, conn2,
		 * indvlExmEmpHsDAO.IndvlExmEmpHs(conn2).get(i)); test(indvlSelect);
		 * log.info("info_id: " +indvlSelect.getInfo().getInfo_id());
		 * log.info("number of exams: " + count.getListCountExm().get(i));
		 * log.info("number of emphss: " + count.getListCountEmpHs().get(i)); }
		 * executor.releaseConnection(conn); executor.releaseConnection(conn2);
		 */

	}

	private static void test(Indvl indvlSelect) {
		// test
		log.info("info: " + indvlSelect.getInfo().getFirstNm());
		log.info(indvlSelect.getInfo().getLastNm());
		log.info(String.valueOf(indvlSelect.getInfo().getIndvlPK()));
		for (int j = 0; j < indvlSelect.getListOthrBus().size(); j++) {
			log.info("othrbus: "
					+ indvlSelect.getListOthrBus().get(j).getDesc());
		}
		for (int j = 0; j < indvlSelect.getListOthrNms().size(); j++) {
			log.info("othrnm: "
					+ indvlSelect.getListOthrNms().get(j).getFirstNm());
		}
		for (int j = 0; j < indvlSelect.getListCrntEmps().size(); j++) {
			log.info("crntemp: "
					+ indvlSelect.getListCrntEmps().get(j).getCntry());
			for (int k = 0; k < indvlSelect.getListCrntEmps().get(j)
					.getListBrnchOfLoc().size(); k++) {
				log.info("brnchOfLoc: "
						+ indvlSelect.getListCrntEmps().get(j)
								.getListBrnchOfLoc().get(k).getStr1());
			}
			for (int k = 0; k < indvlSelect.getListCrntEmps().get(j)
					.getListCrntRgstn().size(); k++) {
				log.info("crtnRgstr: "
						+ indvlSelect.getListCrntEmps().get(j)
								.getListCrntRgstn().get(k).getRegCat());
			}
		}
		for (int j = 0; j < indvlSelect.getListDRPs().size(); j++) {
			log.info("drp: " + indvlSelect.getListDRPs().get(j).isHasBankrupt());
		}
		for (int j = 0; j < indvlSelect.getListExms().size(); j++) {
			log.info("exm: " + indvlSelect.getListExms().get(j).getExmDt());
		}
		for (int j = 0; j < indvlSelect.getListEmpHss().size(); j++) {
			log.info("empHs: " + indvlSelect.getListEmpHss().get(j).getFromDt());
		}
		for (int j = 0; j < indvlSelect.getListPrevRgstns().size(); j++) {
			log.info("prevRgstn: "
					+ indvlSelect.getListPrevRgstns().get(j).getOrgNm());
		}
		for (int j = 0; j < indvlSelect.getListDsgntns().size(); j++) {
			log.info("dgstns: "
					+ indvlSelect.getListDsgntns().get(j).getDsgntnNm());
		}
	}

	private static Indvls count(Indvls indvls) {
		for (int i = 0; i < indvls.getListIndvls().size(); i++) {
			for (int j = 0; j < indvls.getListIndvls().get(i).getListOthrNms()
					.size(); j++) {
				if (!(indvls.getListIndvls().get(i).getListOthrNms().get(j) == null))
					indvls.getListIndvls()
							.get(i)
							.getListOthrNms()
							.get(j)
							.setInfo_id(
									indvls.getListIndvls().get(i).getInfo()
											.getInfo_id());
			}
			for (int j = 0; j < indvls.getListIndvls().get(i).getListCrntEmps()
					.size(); j++) {
				if (!(indvls.getListIndvls().get(i).getListCrntEmps().get(j) == null))
					indvls.getListIndvls()
							.get(i)
							.getListCrntEmps()
							.get(j)
							.setInfo_id(
									indvls.getListIndvls().get(i).getInfo()
											.getInfo_id());
			}
			for (int j = 0; j < indvls.getListIndvls().get(i).getListExms()
					.size(); j++) {
				if (!(indvls.getListIndvls().get(i).getListExms().get(j) == null))
					indvls.getListIndvls()
							.get(i)
							.getListExms()
							.get(j)
							.setInfo_id(
									indvls.getListIndvls().get(i).getInfo()
											.getInfo_id());
			}
			for (int j = 0; j < indvls.getListIndvls().get(i).getListDsgntns()
					.size(); j++) {
				if (!(indvls.getListIndvls().get(i).getListDsgntns().get(j) == null))
					indvls.getListIndvls()
							.get(i)
							.getListDsgntns()
							.get(j)
							.setInfo_id(
									indvls.getListIndvls().get(i).getInfo()
											.getInfo_id());
			}
			for (int j = 0; j < indvls.getListIndvls().get(i)
					.getListPrevRgstns().size(); j++) {
				if (!(indvls.getListIndvls().get(i).getListPrevRgstns().get(j) == null))
					indvls.getListIndvls()
							.get(i)
							.getListPrevRgstns()
							.get(j)
							.setInfo_id(
									indvls.getListIndvls().get(i).getInfo()
											.getInfo_id());
			}
			for (int j = 0; j < indvls.getListIndvls().get(i).getListEmpHss()
					.size(); j++) {
				if (!(indvls.getListIndvls().get(i).getListEmpHss().get(j) == null))
					indvls.getListIndvls()
							.get(i)
							.getListEmpHss()
							.get(j)
							.setInfo_id(
									indvls.getListIndvls().get(i).getInfo()
											.getInfo_id());
			}
			for (int j = 0; j < indvls.getListIndvls().get(i).getListOthrBus()
					.size(); j++) {
				if (!(indvls.getListIndvls().get(i).getListOthrBus().get(j) == null))
					indvls.getListIndvls()
							.get(i)
							.getListOthrBus()
							.get(j)
							.setInfo_id(
									indvls.getListIndvls().get(i).getInfo()
											.getInfo_id());
			}
			for (int j = 0; j < indvls.getListIndvls().get(i).getListDRPs()
					.size(); j++) {
				if (!(indvls.getListIndvls().get(i).getListDRPs().get(j) == null))
					indvls.getListIndvls()
							.get(i)
							.getListDRPs()
							.get(j)
							.setInfo_id(
									indvls.getListIndvls().get(i).getInfo()
											.getInfo_id());
			}
		}

		return indvls;
	}

	private static Indvls count2(Indvls indvls) {
		for (int i = 0; i < indvls.getListIndvls().size(); i++) {
			for (int j = 0; j < indvls.getListIndvls().get(i).getListCrntEmps()
					.size(); j++) {
				for (int k = 0; k < indvls.getListIndvls().get(i)
						.getListCrntEmps().get(j).getListBrnchOfLoc().size(); k++) {
					if (!(indvls.getListIndvls().get(i).getListCrntEmps()
							.get(j).getListBrnchOfLoc().get(k) == null)) {
						indvls.getListIndvls()
								.get(i)
								.getListCrntEmps()
								.get(j)
								.getListBrnchOfLoc()
								.get(k)
								.setInfo_id(
										indvls.getListIndvls().get(i).getInfo()
												.getInfo_id());
						indvls.getListIndvls()
								.get(i)
								.getListCrntEmps()
								.get(j)
								.getListBrnchOfLoc()
								.get(k)
								.setCrntemps_id(
										indvls.getListIndvls().get(i)
												.getListCrntEmps().get(j)
												.getCrntemp_id());
					}
				}
				for (int k = 0; k < indvls.getListIndvls().get(i)
						.getListCrntEmps().get(j).getListCrntRgstn().size(); k++) {
					if (!(indvls.getListIndvls().get(i).getListCrntEmps()
							.get(j).getListCrntRgstn().get(k) == null)) {
						indvls.getListIndvls()
								.get(i)
								.getListCrntEmps()
								.get(j)
								.getListCrntRgstn()
								.get(k)
								.setInfo_id(
										indvls.getListIndvls().get(i).getInfo()
												.getInfo_id());
						indvls.getListIndvls()
								.get(i)
								.getListCrntEmps()
								.get(j)
								.getListCrntRgstn()
								.get(k)
								.setCrntemps_id(
										indvls.getListIndvls().get(i)
												.getListCrntEmps().get(j)
												.getCrntemp_id());
					}
				}
			}
		}
		return indvls;
	}

	private void init() throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream("src/main/resources/config.properties"));
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		String url = prop.getProperty("url");
		String driver = prop.getProperty("driver");
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.setUsername(user);
		pool.setPassword(password);
		pool.setPath(url);
		pool.setClassName(driver);
		pool.setPoolsize(11);
		if (!pool.init())
			System.exit(100);
	}

	// get connection from ConnectionPool
	private Connection GetConnection() throws FileNotFoundException,
			IOException {
		Connection conn1 = ConnectionPool.getConnection();
		return conn1;
	}

	private void releaseConnection(Connection conn) {
		ConnectionPool.releaseConnection(conn);
	}

	@SuppressWarnings("unused")
	private static void databaseWork(ArrayList<Indvl> listIndvls1, int a)
			throws FileNotFoundException, IOException, SQLException,
			PropertyVetoException {

		Main executor = new Main();
		executor.init();
		Connection conn2 = executor.GetConnection();
		InfoImpl infoDAO = new InfoImpl();
		Info info = new Info();
		infoDAO.fillInfo(listIndvls1, conn2, a, info);
		executor.releaseConnection(conn2);
		// CrntEmpsDAO table
		Connection conn3 = executor.GetConnection();
		CrntEmpsImpl crntEmpsDAO = new CrntEmpsImpl();
		CrntEmp crntEmps = new CrntEmp();
		crntEmpsDAO.fillCrntEmps(listIndvls1, conn3, a, crntEmps);
		executor.releaseConnection(conn3);
		// BrnchOfLocsDAO table
		Connection conn4 = executor.GetConnection();
		BrnchOfLocImpl brnchOfLocsDAO = new BrnchOfLocImpl();
		BrnchOfLoc brnchOfLoc = new BrnchOfLoc();
		brnchOfLocsDAO.fillBrnchOfLocs(listIndvls1, conn4, a, brnchOfLoc);
		executor.releaseConnection(conn4);
		// CrntRgstnsDAO table
		Connection conn5 = executor.GetConnection();
		CrntRgstnsImpl crntRgstnsDAO = new CrntRgstnsImpl();
		CrntRgstn crntRgstn = new CrntRgstn();
		crntRgstnsDAO.fillCrntRgstns(listIndvls1, conn5, a, crntRgstn);
		executor.releaseConnection(conn5);
		threadsTables(listIndvls1, executor, a);

	}

	private static void threadsTables(ArrayList<Indvl> listIndvls1,
			Main executor, int a) throws FileNotFoundException, SQLException,
			IOException {
		// OthrNms table
		Connection conn6 = executor.GetConnection();
		OthrNmsImpl othrNmsDAO = new OthrNmsImpl();
		OthrNm othrNm = new OthrNm();
		othrNmsDAO.fillOthrNmsDAO(listIndvls1, conn6, a, othrNm);
		executor.releaseConnection(conn6);
		// ExmsDAO table
		Connection conn7 = executor.GetConnection();
		ExmsImpl exmsDAO = new ExmsImpl();
		Exm exm = new Exm();
		exmsDAO.fillExm(listIndvls1, conn7, a, exm);
		executor.releaseConnection(conn7);
		// DsgntnsDAO table
		Connection conn8 = executor.GetConnection();
		DsgntnsImpl dsgntnsDAO = new DsgntnsImpl();
		Dsgntn dsgntn = new Dsgntn();
		dsgntnsDAO.fillDsgntns(listIndvls1, conn8, a, dsgntn);
		executor.releaseConnection(conn8);
		// PrevRgstnsDAO table
		Connection conn9 = executor.GetConnection();
		PrevRgstnsImpl prevRgstnsDAO = new PrevRgstnsImpl();
		PrevRgstn prevRgstn = new PrevRgstn();
		prevRgstnsDAO.fillPrevRgstns(listIndvls1, conn9, a, prevRgstn);
		executor.releaseConnection(conn9);
		// EmpHssDAO
		Connection conn10 = executor.GetConnection();
		EmpHssImpl empHssDAO = new EmpHssImpl();
		EmpHs empHs = new EmpHs();
		empHssDAO.fillEmpHss(listIndvls1, conn10, a, empHs);
		executor.releaseConnection(conn10);
		// OthrBussDAO
		Connection conn11 = executor.GetConnection();
		OthrBusImpl othrBussDAO = new OthrBusImpl();
		OthrBus othrbus = new OthrBus();
		othrBussDAO.fillOthrBuss(listIndvls1, conn11, a, othrbus);
		executor.releaseConnection(conn11);
		// DRPsDAO
		Connection conn12 = executor.GetConnection();
		DRPImpl dRPsDAO = new DRPImpl();
		DRP drp = new DRP();
		dRPsDAO.fillDRPs(listIndvls1, conn12, a, drp);
		executor.releaseConnection(conn12);

	}

}
