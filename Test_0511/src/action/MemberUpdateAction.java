package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MemberUpdateService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberUpdateAction implements Action {
	// insert 작업과 비슷.

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) 
			throws Exception {
		
		MemberBean mb = new MemberBean();
		// 생성하는 이유
		// 새로 수정한 정보를 담을 그릇.
				
		mb.setCustno(Integer.parseInt(req.getParameter("custno")));
		// Integer.paresint를 사용하여 타입을 맞쳐줌
		// get파라미터로 넘어온 값은 문자열 이므로, 타입변환
		// (명시적 형변환)이 안됨, 이유는 동일 타입에서 메모리 크기 변화 일때 사용.
		mb.setCustname(req.getParameter("custname"));
		mb.setPhone(req.getParameter("phone"));
		mb.setAddress(req.getParameter("address"));
		mb.setJoindate(req.getParameter("joindate"));
		mb.setGrade(req.getParameter("grade"));
		mb.setCity(req.getParameter("city"));
// 수정 정보를 모두 담아서 회원 객체로 저장.
		
		MemberUpdateService memberUpdateService 
		= new MemberUpdateService();
		// 서비스 생성		
		
		boolean updateResult = false;

		updateResult = memberUpdateService.updateMember(mb);
		// mb에 정보를 넘김
		ActionForward forward = null;
		
		if (updateResult == false) {
// 수정이 안 됐을때,
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>");
			out.println("alert('회원 정보 수정 실패')");
			out.println("history.back()");
// 이전 화면으로 이동.
			out.println("</script>");
		} else {
// 수정이 됐다면,
			forward = new ActionForward();
			forward.setRedirect(true);
// 공유하는 값이 없으므로, 리다이렉트로 화면 이동.
			forward.setPath("./memberListAction.me");
// 이동할 주소 설정.
		}
		return forward;
	}
}
