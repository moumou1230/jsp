package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Control;
import service.BoardService;
import service.BoardServiceImpl;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		BoardService svc = new BoardServiceImpl();
		if(svc.checkMember(id, pw)) {
			//로그인.
			HttpSession session = req.getSession();
			session.setAttribute("logId", id);
			System.out.println("로그인성공");
			resp.sendRedirect("main.do");
		}else {
			System.out.println("로그인실패");
			resp.sendRedirect("loginForm.do");
		}

	}

}
