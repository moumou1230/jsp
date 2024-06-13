package co.yedam.mapper;
//목록, 등록, 수정, 삭제, 단건조회

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.yedam.vo.BoardVO;

public interface BoardMapper {
	List<BoardVO> boardList();//전체목록
	List<BoardVO> boardListpaging(int page);
	int getTotalCnt();//페이징 계산용도 
	int insertBoard(BoardVO bvo);
	int updateBoard(BoardVO bvo);
	int deleteBoard(int bno);
	BoardVO selectBoard(int bno);//단건조회
	
	//회원id, 회원비밀번호
	int selectMember(@Param("id") String id, @Param("pw") String pw);
}
