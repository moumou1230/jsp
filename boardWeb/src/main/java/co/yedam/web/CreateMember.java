package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.vo.MemberVO;
import service.BoardService;
import service.BoardServiceImpl;

public class CreateMember implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		BoardService svc = new BoardServiceImpl();
		MemberVO member = new MemberVO();
		
		member.setUserName(name);
		member.setUserId(id);
		member.setUserPw(pw);
		
		if(svc.insertMember(name, id, pw)) {
			System.out.println("회원가입 성공");
			resp.sendRedirect("main.do");
		}else {
			System.out.println("회원가입 실패");
			resp.sendRedirect("memberForm.do");
		}
		
	}

}
