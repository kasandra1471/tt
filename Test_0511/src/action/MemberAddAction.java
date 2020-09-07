package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.FindSeqService;
import vo.ActionForward;

public class MemberAddAction implements Action {

	@Override
	public ActionForward 
	execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		// 회원번호는 자동 증가, 컬렉션 자동증가된 ㅗ히원번호 표시
		// select , insert 동작 필요

		ActionForward forward = null;
		forward = new ActionForward();
		FindSeqService fss = new FindSeqService();
		// 자동증가하는 일련번호 조회용 서비스
		
		
		
		int findSeq = fss.getSeq();
		req.setAttribute("custno", findSeq);
		forward.setPath("./member_add.jsp");
		return forward;
	}

}
