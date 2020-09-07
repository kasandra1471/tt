package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDAO;
import db.JdbcUtil;
import vo.MoneyBean;

public class MoneyViewService {

	public ArrayList<MoneyBean> getMoneyView() {

		Connection con = null;
		try {
			con = JdbcUtil.getConnection();
			// 오라클과 연결
		} catch (Exception e) {
			e.printStackTrace();
		}

		MemberDAO memberDAO = MemberDAO.getInstance();
		// DAO : Data Access Object
		memberDAO.setConnection(con);
		// DAO : data accecss object
		// 오라클과의 커넥션을 다오에 전달
		ArrayList<MoneyBean> moneyList
		= memberDAO.selectMoneyList();
		// 다오로 커넥션 전달

		JdbcUtil.close(con);

		return moneyList;
	}

}
