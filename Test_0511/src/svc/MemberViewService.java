package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDAO;
import db.JdbcUtil;
import vo.MemberBean;

public class MemberViewService {
	public MemberBean getMember(String id){
		Connection con=null;
		try {
			con=JdbcUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		// DAO : Data Access Object
		memberDAO.setConnection(con);
		//DAO : data accecss object
		MemberBean member
		// 다오로 커넥션 전달
		= memberDAO.selectMember(id);
		
		JdbcUtil.close(con);
		
		return member;
	}
}
