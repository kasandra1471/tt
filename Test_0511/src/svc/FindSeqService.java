package svc;

import java.sql.Connection;

import dao.MemberDAO;
import db.JdbcUtil;

public class FindSeqService {

	public int getSeq() {
		
	
		Connection con=null;
		try {
		con=JdbcUtil.getConnection();
		} catch (Exception e) {
		e.printStackTrace();
		}
		MemberDAO mDAO = MemberDAO.getInstance();
		mDAO.setConnection(con);
		int seq = mDAO.getSeq();
		JdbcUtil.close(con);
		
		return seq;
		
	}
		


}
