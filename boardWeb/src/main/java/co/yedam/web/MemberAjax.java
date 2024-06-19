package co.yedam.web;

import java.io.Console;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.vo.MemberVO;
import service.BoardService;
import service.BoardServiceImpl;

public class MemberAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// json문자열 반환
		//{"name": "홍길동","age":20,"phone":"010-1234-1234"}
		resp.setContentType("text/json;charset=utf-8");
		
		BoardService svc = new BoardServiceImpl();
		List<MemberVO> list = svc.memberList();
		System.out.println(list);
		
		String json = "[";
		for(int i = 0; i<list.size(); i++) {
			json += "{\"userId\":\""+ list.get(i).getUserId() + "\",\"userName\":\"" + list.get(i).getUserName()
					+ "\",\"userPw\":\"" + list.get(i).getUserPw() + "\",\"responsibility\":\"" + list.get(i).getResponsibility() + "\"}";
			if(i != list.size()-1) {
				json += ",";
			}
		}
		json += "]";
		
		resp.getWriter().print(json);

	}

}
