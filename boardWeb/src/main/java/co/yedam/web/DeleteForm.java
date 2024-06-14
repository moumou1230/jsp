package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.vo.BoardVO;
import service.BoardService;
import service.BoardServiceImpl;

public class DeleteForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("bno");
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		BoardService bsv = new BoardServiceImpl();
		BoardVO bvo = bsv.getBoard(Integer.parseInt(no));
		
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		req.setAttribute("page", page);
		req.setAttribute("board", bvo);
		
		req.getRequestDispatcher("board/deleteForm.tiles").forward(req, resp);

	}

}
