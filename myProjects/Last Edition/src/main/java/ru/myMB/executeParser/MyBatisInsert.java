package ru.myMB.executeParser;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


import ru.myMB.DAO.myBatis.BrnchOfLocImpl;
import ru.myMB.DAO.myBatis.CrntEmpImpl;
import ru.myMB.DAO.myBatis.CrntRgstnImpl;
import ru.myMB.DAO.myBatis.DRPImpl;
import ru.myMB.DAO.myBatis.DsgntnImpl;
import ru.myMB.DAO.myBatis.EmpHssImpl;
import ru.myMB.DAO.myBatis.ExmImpl;
import ru.myMB.DAO.myBatis.IndvlSImpl;
import ru.myMB.DAO.myBatis.InfoImpl;
import ru.myMB.DAO.myBatis.OthrBusImpl;
import ru.myMB.DAO.myBatis.OthrNmImpl;
import ru.myMB.DAO.myBatis.PrevRgstnImpl;
import ru.myMB.indvls.Count;
import ru.myMB.indvls.Indvl;
import ru.myMB.indvls.Indvls;

public class MyBatisInsert {

	public ArrayList<Indvl> listIndvls1 = null;
	public Connection conn = null;

	public void insertInfo(Indvls indvls, int a) throws IOException,
			SQLException {
		InfoImpl mbf = new InfoImpl();
		for (int i = 0; i < a; i++) {
			mbf.fillInfo(listIndvls1, conn, a, indvls.getListIndvls().get(i)
					.getInfo());
		}
	}

	public void insertCrntEmp(Indvls indvls, int a) throws IOException,
			SQLException {
		CrntEmpImpl mbce = new CrntEmpImpl();
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < indvls.getListIndvls().get(i).getListCrntEmps()
					.size(); j++) {
				mbce.fillCrntEmps(listIndvls1, conn, a, indvls.getListIndvls()
						.get(i).getListCrntEmps().get(j));
			}
		}
	}

	public void insertBrnchOfLoc(Indvls indvls, int a) throws IOException,
			SQLException {
		BrnchOfLocImpl mbbol = new BrnchOfLocImpl();
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < indvls.getListIndvls().get(i).getListCrntEmps()
					.size(); j++) {
				for (int k = 0; k < indvls.getListIndvls().get(i)
						.getListCrntEmps().get(j).getListBrnchOfLoc().size(); k++) {
					mbbol.fillBrnchOfLocs(listIndvls1, conn, a, indvls
							.getListIndvls().get(i).getListCrntEmps().get(j)
							.getListBrnchOfLoc().get(k));
				}
			}
		}
	}

	public void insertCrntRgstn(Indvls indvls, int a) throws IOException,
			SQLException {
		CrntRgstnImpl mbcr = new CrntRgstnImpl();
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < indvls.getListIndvls().get(i).getListCrntEmps()
					.size(); j++) {
				for (int k = 0; k < indvls.getListIndvls().get(i)
						.getListCrntEmps().get(j).getListCrntRgstn().size(); k++) {
					mbcr.fillCrntRgstns(listIndvls1, conn, a, indvls
							.getListIndvls().get(i).getListCrntEmps().get(j)
							.getListCrntRgstn().get(k));
				}
			}
		}
	}

	public void insertOthrNm(Indvls indvls, int a) throws IOException,
			SQLException {
		OthrNmImpl mbon = new OthrNmImpl();
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < indvls.getListIndvls().get(i).getListOthrNms()
					.size(); j++) {
				mbon.fillOthrNmsDAO(listIndvls1, conn, a, indvls
						.getListIndvls().get(i).getListOthrNms().get(j));
			}
		}
	}

	public void insertExm(Indvls indvls, int a) throws IOException,
			SQLException {
		ExmImpl mbe = new ExmImpl();
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < indvls.getListIndvls().get(i).getListExms()
					.size(); j++) {
				mbe.fillExm(listIndvls1, conn, a, indvls.getListIndvls().get(i)
						.getListExms().get(j));
			}
		}
	}

	public void insertDsgntn(Indvls indvls, int a) throws IOException {
		DsgntnImpl mbd = new DsgntnImpl();
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < indvls.getListIndvls().get(i).getListDsgntns()
					.size(); j++) {
				mbd.fillDsgntns(listIndvls1, conn, a, indvls.getListIndvls()
						.get(i).getListDsgntns().get(j));
			}
		}
	}

	public void inserPrevRgstn(Indvls indvls, int a) throws IOException,
			SQLException {
		PrevRgstnImpl mbpr = new PrevRgstnImpl();
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < indvls.getListIndvls().get(i)
					.getListPrevRgstns().size(); j++) {
				mbpr.fillPrevRgstns(listIndvls1, conn, a, indvls
						.getListIndvls().get(i).getListPrevRgstns().get(j));
			}
		}
	}

	public void inserEmpHs(Indvls indvls, int a) throws IOException,
			SQLException {
		EmpHssImpl mbeh = new EmpHssImpl();
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < indvls.getListIndvls().get(i).getListEmpHss()
					.size(); j++) {
				mbeh.fillEmpHss(listIndvls1, conn, a, indvls.getListIndvls()
						.get(i).getListEmpHss().get(j));
			}
		}
	}

	public void inserOthrBus(Indvls indvls, int a) throws IOException,
			SQLException {
		OthrBusImpl mbob = new OthrBusImpl();
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < indvls.getListIndvls().get(i).getListOthrBus()
					.size(); j++) {
				mbob.fillOthrBuss(listIndvls1, conn, a, indvls.getListIndvls()
						.get(i).getListOthrBus().get(j));
			}
		}
	}

	public void inserDRP(Indvls indvls, int a) throws IOException, SQLException {
		DRPImpl mbdrp = new DRPImpl();
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < indvls.getListIndvls().get(i).getListDRPs()
					.size(); j++) {
				mbdrp.fillDRPs(listIndvls1, conn, a, indvls.getListIndvls()
						.get(i).getListDRPs().get(j));
			}
		}
	}

	public Indvl selectIndvl(int num) throws IOException, SQLException {
		int c = 0;
		IndvlSImpl mbis = new IndvlSImpl();
		Indvl indvl = mbis.selectIndvl(conn, conn, num);
		indvl = mbis.selectOthrBus(num, indvl);
		indvl = mbis.selectOthrNm(num, indvl);
		indvl = mbis.selectCrntEmp(num, indvl);
		indvl = mbis.selectBrnchOfLoc(indvl, conn, num, c);
		indvl = mbis.selectCrntRgstn(indvl, conn, num, c);
		indvl = mbis.selectDRP(indvl, conn, num);
		indvl = mbis.selectExm(indvl, conn, num);
		indvl = mbis.selectEmpHS(indvl, conn, num);
		indvl = mbis.selectPrevRgstns(indvl, conn, num);
		indvl = mbis.selectDsgntn(num, conn, indvl);
		return indvl;
	}

	public ArrayList<Indvl> selectIndvlExmEmpHs() throws IOException,
			SQLException {
		IndvlSImpl mbseeh = new IndvlSImpl();
		ArrayList<Indvl> listIndvlExmEmpHs = new ArrayList<Indvl>();
		for (int i = 0; i < mbseeh.IndvlExmEmpHs(conn).size(); i++) {
			listIndvlExmEmpHs
					.add(selectIndvl(mbseeh.IndvlExmEmpHs(conn).get(i)));
		}
		return listIndvlExmEmpHs;
	}

	public Count setCountExm() throws IOException, SQLException {
		IndvlSImpl mbseeh = new IndvlSImpl();
		Count count = new Count();
		count = mbseeh.countExm(conn, count);
		count = mbseeh.countEmpHs(conn, count);
		return count;
	}

}
