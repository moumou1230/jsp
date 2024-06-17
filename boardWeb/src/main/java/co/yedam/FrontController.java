package co.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.web.AddBoard;
import co.yedam.web.AddStudent;
import co.yedam.web.BoardForm;
import co.yedam.web.BoardList;
import co.yedam.web.CreateMember;
import co.yedam.web.DeleteBoard;
import co.yedam.web.DeleteForm;
import co.yedam.web.GetBoard;
import co.yedam.web.LoginControl;
import co.yedam.web.LoginForm;
import co.yedam.web.LogoutControl;
import co.yedam.web.MainControl;
import co.yedam.web.MemberForm;
import co.yedam.web.MemberList;
import co.yedam.web.ProductControl;
import co.yedam.web.ScriptForm;
import co.yedam.web.StudentForm;
import co.yedam.web.UpdateBoard;
import co.yedam.web.UpdateForm;

// front -> 요청url(*.do) - 실행 컨트롤러 매칭
// main.do -> FrontController -> /WEB_INF/public/main.jsp
// 객체생성 -> init -> service -> destroy 순으로 실행
public class FrontController extends HttpServlet{
	private Map<String, Control> map; //key = url, value = control
	
	public FrontController() {
		map = new HashMap<>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainControl());
		map.put("/product.do", new ProductControl());
		//학생 등록화면 studentForm.do
		map.put("/studentForm.do", new StudentForm());
		map.put("/addStudent.do", new AddStudent());//db에 정보저장
		
		//게시글 목록
		map.put("/boardList.do", new BoardList());
		//상세화면
		map.put("/getBoard.do", new GetBoard());
		//게시글 작성
		map.put("/boardForm.do", new BoardForm());
		map.put("/addBoard.do", new AddBoard());
		
		//게시글 수정
		map.put("/updateForm.do", new UpdateForm());
		map.put("/updateBoard.do", new UpdateBoard());
		
		//게시글 삭제
		map.put("/deleteForm.do", new DeleteForm());
		map.put("/deleteBoard.do", new DeleteBoard());
		
		//로그인
		map.put("/loginForm.do", new LoginForm());
		map.put("/login.do", new LoginControl());
		
		//로그아웃
		map.put("/logout.do", new LogoutControl());
		
		//회원가입
		map.put("/memberForm.do", new MemberForm());
		map.put("/createMember.do", new CreateMember());
		
		//회원목록(관리자 템플릿)
		map.put("/memberList.do", new MemberList());
		
		//자바스크립트 연습용 페이지
		map.put("/script.do", new ScriptForm());
		}
		
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); // http://localhost/BoardWeb/main.do (url) ,
//		System.out.println("uri : " + uri);// /BoardWeb/main.do
		String context = req.getContextPath(); // /BoardWed -> project name.
//		System.out.println("context : " + context);
		String page = uri.substring(context.length()); 
//		System.out.println("page : " + page);
		
//		String result = map.get(page);
		Control result = map.get(page);
//		System.out.println("result : " + result);
		result.exec(req, resp);
	}
}
