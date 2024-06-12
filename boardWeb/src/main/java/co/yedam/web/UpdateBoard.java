package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
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
		
		BoardService bsv = new BoardServiceImpl();
		BoardVO board = new BoardVO();
		board.setBoardNo(Integer.parseInt(no));
		System.out.println(no);
		board.setTitle(title);
		System.out.println(title);
		board.setContent(content);
		
		if(bsv.editBoard(board)) {
			System.out.println("수정완료");
			resp.sendRedirect("boardList.do");
		}else {
			System.out.println("수정에 실패하였습니다.");
			resp.sendRedirect("boardList.do");
//			req.getRequestDispatcher("WEB-INF/view/boardList.jsp").forward(req, resp);
		}
	}

}
