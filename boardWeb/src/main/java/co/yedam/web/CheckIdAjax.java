package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.vo.MemberVO;
import service.BoardService;
import service.BoardServiceImpl;

public class CheckIdAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		BoardService svc = new BoardServiceImpl();
		
		if(svc.checkMemberId(id)) {//{"retCod" : "Exist"}
			resp.getWriter().print("{\"retCode\" : \"Exist\"}");
		}else {
			resp.getWriter().print("{\"retCode\" : \"Not Exist\"}");
		}
	}

}
