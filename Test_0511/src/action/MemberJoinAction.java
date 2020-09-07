package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MemberJoinService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberJoinAction implements Action {

	@Override
	public ActionForward 
	execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		// TODO Auto-generated method stub
		MemberBean member = new MemberBean();
		boolean joinResult = false;

		member.setCustname(req.getParameter("custname"));
		member.setPhone(req.getParameter("phone"));
		member.setAddress(req.getParameter("address"));
		member.setJoindate(req.getParameter("joindate"));
		member.setGrade(req.getParameter("grade"));
		member.setCity(req.getParameter("city"));

		MemberJoinService mjs = new MemberJoinService();

		joinResult = mjs.joinMember(member);
		// 호출한 메소드에서 다시 다오를 호출해서 쿼리를 수행하고,
		// 결과를 어레이리스트로 받아 옴.

		ActionForward fo = null;
		if (joinResult == false) {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();

			out.println("<script>");
			out.println("alert(('회원등록에 실패했습니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else {			
			fo = new ActionForward();
			fo.setRedirect(true);
			fo.setPath("./memberAddAction.me");
		}
		return fo;

	}

}
