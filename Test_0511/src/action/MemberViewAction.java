package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MemberViewService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberViewAction implements Action {

	@Override
	public ActionForward execute(
			HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		
		ActionForward forward = null;
		forward=new ActionForward();
		
		String viewId=req.getParameter("id");
		
		MemberViewService memberViewService
		= new MemberViewService();
		MemberBean member 
		= memberViewService.getMember(viewId);
		// 서비스 객체의 getMember 메소드에 전달된 아이디를 전달랳서
		// 회원 1명의 정보 추출
		
		req.setAttribute("member", member);
		// 추출된 정보를 reg 객체의 속성으로 담아서
		forward.setPath("./member_mod.jsp");
		// member_mid.jsp 로 전달.
		
		return forward;
	}

}
