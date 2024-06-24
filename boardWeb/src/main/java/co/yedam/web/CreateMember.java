package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.common.Control;
import co.yedam.vo.MemberVO;
import service.BoardService;
import service.BoardServiceImpl;

public class CreateMember implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파일 첨부일 경우에는 multipart 요청 처리
		//Multipart 요청 (1.요청정보 2.저장 위치 3.최대크기 4.인코딩 5.리네임 정책)
		String savePath = req.getServletContext().getRealPath("images");//각각 프로젝트마다 다른위치에 저장 서블릿은 프로젝트라 생각하면 편함
		int maxSize = 1024*1024*5;//5메가바이트 크기
		String encoding = "utf-8";
		
		MultipartRequest mr = new MultipartRequest(req, savePath, maxSize, encoding, new DefaultFileRenamePolicy());
		
		MemberVO member = new MemberVO();
		
		String name = mr.getParameter("name");
		String id = mr.getParameter("id");
		String pw = mr.getParameter("pw");
		String img = mr.getFilesystemName("myImage");
		 
		BoardService svc = new BoardServiceImpl();
		
		member.setUserName(name);
		member.setUserId(id);
		member.setUserPw(pw);
		member.setImage(img);
		
		System.out.println(name);
		System.out.println(id);
		System.out.println(pw);
		System.out.println(img);
		
		if(svc.addMemberImage(member)) {
			System.out.println("회원가입 성공");
			resp.sendRedirect("memberList.do");
		}else {
			System.out.println("회원가입 실패");
			resp.sendRedirect("memberForm.do");
		}
		
	}

}
