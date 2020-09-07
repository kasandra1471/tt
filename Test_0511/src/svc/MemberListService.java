package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDAO;
import db.JdbcUtil;
import vo.MemberBean;

public class MemberListService {

	public ArrayList<MemberBean> getMemberList(){
		Connection con=null;
		try {
			con=JdbcUtil.getConnection();
			// 오라클과 연결 만들기.
			} catch (Exception e) {
			e.printStackTrace();
			// 외부 입출력 처리를 하고 있으므로, 예외 적용
			}

		
		MemberDAO memberDAO = MemberDAO.getInstance();
		// DAO : Data Access Object
		memberDAO.setConnection(con);
		// 얻어낸 커넥션을 다오로 전달
		ArrayList<MemberBean> memberList
		= memberDAO.selectMemberList();
		
		JdbcUtil.close(con);
		
		return memberList;
	}
}
