package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.vo.MemberVO;
import service.BoardService;
import service.BoardServiceImpl;

public class DelMemberAjax2 implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
	
		
		BoardService svc = new BoardServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setUserId(id);
		
		if(svc.delMemberId2(vo)) {
			resp.getWriter().print("{\"retCode\": \"delete\"}");
		}else {
			resp.getWriter().print("{\"retCode\": \"error\"}");
		}


	}

}
