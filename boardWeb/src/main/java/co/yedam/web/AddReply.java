package co.yedam.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.vo.ReplyVO;
import service.ReplyService;
import service.ReplyServiceImpl;

public class AddReply implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");
		
		String bno = req.getParameter("bno");
		String replyer = req.getParameter("replyer");
		String reply = req.getParameter("reply");
		
		ReplyVO rvo = new ReplyVO();
		rvo.setBoardNo(Integer.parseInt(bno));
		rvo.setReplyer(replyer);
		rvo.setReply(reply);
		System.out.println("rvo1"+rvo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		Gson gson = new GsonBuilder().create();
		
		ReplyService svc = new ReplyServiceImpl();
		
		try {
			if(svc.registReply(rvo)) {
				rvo.setReplyDate(new Date());
				System.out.println("rvo2"+rvo);
				
				map.put("retCode", "OK");
				map.put("retVal", rvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("reCode", "NG");
			map.put("reVal", "처리중에 오류가 발생하였습니다.");
		}
		//웹브라우저에 출력하기 위해서
		resp.getWriter().print(gson.toJson(map));

	}

}
