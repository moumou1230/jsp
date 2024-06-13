package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.vo.BoardVO;
import service.BoardService;
import service.BoardServiceImpl;

public class DeleteBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("bno");
		int page= Integer.parseInt(req.getParameter("page"));
		
		BoardService bsv = new BoardServiceImpl();
		
		if(bsv.removeBoard(Integer.parseInt(no))) {
			System.out.println("삭제 성공");
			resp.sendRedirect("boardList.do?page=" + page);
		}else {
			System.out.println("삭제실패");
			resp.sendRedirect("boardList.do");
		}

	}

}
