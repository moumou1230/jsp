package co.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.vo.ReplyVO;
import service.ReplyService;
import service.ReplyServiceImpl;

public class ReplyList implements Control {
	
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/json;charset=utf-8");
		String bno = req.getParameter("bno");
		
		//댓글 목록
		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = svc.replyList(Integer.parseInt(bno));
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create(); //gson객체 생성
		String json = gson.toJson(list);//객체를 문자열로 변환
		
		resp.getWriter().print(json);//웹브라우저에 출력.
	}

}
