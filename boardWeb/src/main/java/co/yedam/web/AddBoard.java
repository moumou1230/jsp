package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.vo.BoardVO;
import service.BoardService;
import service.BoardServiceImpl;

public class AddBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String title = req.getParameter("btitle");
		String content = req.getParameter("bcontent");
		String writer = req.getParameter("bwriter");
		
		BoardService bsv = new BoardServiceImpl();
		
		BoardVO bvo = new BoardVO();
		bvo.setTitle(title);
		bvo.setContent(content);
		bvo.setWriter(writer);
		
		if(bsv.addBoard(bvo)) {
			System.out.println("정상 작성되었습니다.");
			resp.sendRedirect("boardList.do");
		}else {
			System.out.println("작성에 실패하였습니다.");
			req.getRequestDispatcher("board/addBoard.tiles").forward(req, resp);
		}

	}

}
