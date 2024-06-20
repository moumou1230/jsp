package co.yedam.web;

import java.io.IOException;
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

public class RemoveReply implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//댓글 번호 -> 댓글삭제,반환:
		resp.setContentType("text/json;charset=utf-8");
		String rno = req.getParameter("rno");
		
		ReplyService svc = new ReplyServiceImpl();
//		
//		if(svc.removeReply(Integer.parseInt(rno))) {//{"resCode": "OK"}
//			resp.getWriter().print("{\"retCode\": \"OK\"}");
//		}else {
//			resp.getWriter().print("{\"retCode\": \"NG\"}");
//		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		Gson gson = new GsonBuilder().create();

		if(svc.removeReply(Integer.parseInt(rno))) {
			map.put("retCode", "OK");
			map.put("retMsg", "성공적으로 삭제되었습니다.");
		}else {
			map.put("retCode", "NG");
			map.put("retMsg", "삭제중 예외가 발생하였습니다.");
		}
		String json = gson.toJson(map);
		resp.getWriter().print(json);
	}

}
