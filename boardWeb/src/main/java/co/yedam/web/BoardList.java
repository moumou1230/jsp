package co.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.common.PageDTO;
import co.yedam.common.SearchVO;
import co.yedam.vo.BoardVO;
import service.BoardService;
import service.BoardServiceImpl;

//oracle db에 있는 글목록을 조회해서 boardList.jsp에 출력
public class BoardList implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		page = page == null ? "1" : page;
		
		//검색조건들을 담는 searchVO
		SearchVO search = new SearchVO(Integer.parseInt(page), sc, kw);
		
		
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList(search);
		
		req.setAttribute("boardList", list);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		//paging계산
		int totalCnt = svc.boardTotal(search); //전체 페이지 계산
		PageDTO dto = new PageDTO(Integer.parseInt(page), totalCnt);
		req.setAttribute("paging", dto);
		
		req.getRequestDispatcher("board/boardList.tiles").forward(req, resp);

	}

}
