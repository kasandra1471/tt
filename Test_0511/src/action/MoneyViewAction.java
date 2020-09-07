package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MoneyViewService;
import vo.ActionForward;
import vo.MoneyBean;

public class MoneyViewAction implements Action {

	@Override
	public ActionForward execute(
			HttpServletRequest req,
			HttpServletResponse resp) throws Exception {

		ActionForward forward = null;
		
		forward = new ActionForward();
		
		MoneyViewService mvs = new MoneyViewService();
		
		ArrayList<MoneyBean> moneyList = mvs.getMoneyView();
		// 호출한 메소드에서 다시 다오를 호출해서 쿼리를 수행하고,
		// 결과를 어레이리스트로 받아 옴.
		
		req.setAttribute("moneyList", moneyList);
		forward.setPath("./money.jsp");
		
		return forward;
		
	}


}
