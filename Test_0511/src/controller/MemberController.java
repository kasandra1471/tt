package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.MemberAddAction;
import action.MemberJoinAction;
import action.MemberListAction;
import action.MemberUpdateAction;
import action.MemberViewAction;
import action.MoneyViewAction;
import vo.ActionForward;

// 어노테이션 : 일련의 작업들을 매크로 처럼 약속으로 정해 놓은 것.
@WebServlet("*.me") // 넘기는 주소가 어떤 것이든지,
// me로 끝나면 이쪽 클래스에서 처리.
public class MemberController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		// 한글깨짐 방지.
		// get은 클라이언트의 서버의 설정만 맞추면 한글 깨지지 않음.
		// post는 언어셋 설정 부분을 전달하지 못함.
		String RequestURI = req.getRequestURI();
//		System.out.println("RequestURI:"+getRequestURI);
		// /HRD_00000/memberListAtion.me 을 불러옴
		String contextPath = req.getContextPath();
		//
		String command = RequestURI.substring(contextPath.length());
		//
		ActionForward forward = null;
		Action action = null;
		// 인터페이스 Action 변수 action

		if (command.equals("/memberListAction.me")) {
			// 전달된 요청이 회원 목록 보기 라면,
			// 아래 내용을 수행.
			action = new MemberListAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/memberViewAction.me")) {

			action = new MemberViewAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/memberUpdateAction.me")) {

			action = new MemberUpdateAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/moneyViewAction.me")) {

			action = new MoneyViewAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/memberAddAction.me")) {
			action = new MemberAddAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/memberJoinAction.me")) {
			action = new MemberJoinAction();
			try {
				forward = action.execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (forward != null) {
			if (forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
				// 리퀘스트 객체를 공유하지 않고 페이지 이동.
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
				// 리퀘스트 객체를 공유하여 페이지 이동.
			}
		}
	}
}
