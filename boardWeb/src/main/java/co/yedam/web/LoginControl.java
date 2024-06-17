package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Control;
import co.yedam.vo.MemberVO;
import service.BoardService;
import service.BoardServiceImpl;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		BoardService svc = new BoardServiceImpl();
		MemberVO mvo = svc.checkMember(id, pw);
		
		if( mvo != null) {
			//로그인.
			HttpSession session = req.getSession();
			session.setAttribute("logId", id);
			System.out.println("로그인성공");
			
			if(mvo.getResponsibility().equals("User")) {
				resp.sendRedirect("main.do");	
			}else if(mvo.getResponsibility().equals("Admin")) {
				resp.sendRedirect("memberList.do");
			}
		}else {
			System.out.println("로그인실패");
			resp.sendRedirect("loginForm.do");
		}

	}

}
