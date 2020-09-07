package svc;

import java.sql.Connection;

import dao.MemberDAO;
import db.JdbcUtil;
import vo.MemberBean;

public class MemberUpdateService {

	public boolean updateMember(MemberBean mb) {
		
		Connection con = null;
		try {
			con = JdbcUtil.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		MemberDAO memberDAO 
		= MemberDAO.getInstance();
		
		memberDAO.setConnection(con);
		//디오로 커넥션 전달
		
		int updateCnt = memberDAO.updateMember(mb);
		//1명의 개인 정보 수정 쿼리는 디비로 전달햇고,
		// 그 결과를 updateCnt로 전달
		
		boolean updateSuccess = false;
		
		if (updateCnt != 0) {
			updateSuccess = true;
			// 0이 아니라면 업데이트는 true 하고
			JdbcUtil.commit(con);
			// JbcUtil에서 comit을 호출하여 저장
		} else {
			JdbcUtil.rollback(con);
			// 0이라면 업데이트 x rollback을 호출
		}
		JdbcUtil.close(con);
		return updateSuccess;
	}

}
