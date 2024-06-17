package service;
//목록,단건,등록,수정,삭제
//기능의 실행은 mapper 실행

import java.util.List;

import co.yedam.common.SearchVO;
import co.yedam.vo.BoardVO;
import co.yedam.vo.MemberVO;

public interface BoardService {
	List<BoardVO> boardList(SearchVO search);
	int boardTotal(SearchVO search);
	BoardVO getBoard(int bno);//단건조회
	boolean addBoard(BoardVO bvo);
	boolean editBoard(BoardVO bvo);
	boolean removeBoard(int bno);
	
	//checkMember(id.pw)
	MemberVO checkMember(String id, String pw);
	
	boolean insertMember(String name, String id, String pw);
}
