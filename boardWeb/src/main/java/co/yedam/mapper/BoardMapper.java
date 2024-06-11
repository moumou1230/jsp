package co.yedam.mapper;
//목록, 등록, 수정, 삭제, 단건조회

import java.util.List;

import co.yedam.vo.BoardVO;

public interface BoardMapper {
	List<BoardVO> boardList();
	int insertBoard(BoardVO bvo);
	int updateBoard(BoardVO bvo);
	int deleteBoard(int bno);
	BoardVO selectBoard(int bno);
}
