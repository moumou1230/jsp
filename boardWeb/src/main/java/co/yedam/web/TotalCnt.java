package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import service.ReplyService;
import service.ReplyServiceImpl;

public class TotalCnt implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// bno => 댓글 건수
		String bno = req.getParameter("bno");
		
		ReplyService svc = new ReplyServiceImpl();
		int totalCnt = svc.getTotalCount(Integer.parseInt(bno));
		
		resp.getWriter().print(totalCnt);
		
	}
}
