package svc;

import java.sql.Connection;

import dao.MemberDAO;
import db.JdbcUtil;
import vo.MemberBean;

public class MemberJoinService {

	public boolean joinMember(MemberBean member) {
		boolean joinSuccess = false;
		MemberDAO dao = MemberDAO.getInstance();
		Connection con = null;
		
		try {
			con = JdbcUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		dao.setConnection(con);
		int insertCount = dao.insertMember(member);
		
		if (insertCount > 0) {
			joinSuccess = true;
			JdbcUtil.commit(con);
		} else {
			JdbcUtil.rollback(con);
		}
		JdbcUtil.close(con);
		return joinSuccess;
	}

}
