package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MemberListService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberListAction implements Action {

	@Override
	public ActionForward execute(
			HttpServletRequest req,
			HttpServletResponse resp) throws Exception {

		ActionForward forward = null;
		
		forward = new ActionForward();
		// 처리후 이동할 주소와 방식 지정
		
		MemberListService memberListService = new MemberListService();
		
		ArrayList<MemberBean> memberList = memberListService.getMemberList();
		// 호출한 메소드에서 다시 다오를 호출해서 쿼리를 수행하고,
		// 결과를 어레이리스트로 받아 옴.
		
		req.setAttribute("memberList", memberList);
		
		// application > session > request > page
		// 현재 자리에서 발생된 정보를 다음 페이지로 넘기는 역할.
		// req으로 전달하는 "이름" , "값"
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
		forward.setPath("./list.jsp");
		
		return forward;
		
	}

}
