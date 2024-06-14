package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.common.PageDTO;
import co.yedam.vo.BoardVO;
import service.BoardService;
import service.BoardServiceImpl;

public class UpdateBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String no = req.getParameter("bno");
		String title = req.getParameter("uTitle");
		String content = req.getParameter("uContent");
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		
		BoardService bsv = new BoardServiceImpl();
		BoardVO board = new BoardVO();
		board.setBoardNo(Integer.parseInt(no));
		board.setTitle(title);
		board.setContent(content);
		
		
		if(bsv.editBoard(board)) {
			System.out.println("수정완료");
			resp.sendRedirect("boardList.do?page="+page+"&searchCondition="+sc+"&keyword="+kw);
		}else {
			System.out.println("수정에 실패하였습니다.");
			resp.sendRedirect("boardList.do?page="+page);
//			req.getRequestDispatcher("WEB-INF/view/boardList.jsp").forward(req, resp);
		}
	}

}
