package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.common.SearchVO;
import co.yedam.mapper.BoardMapper;
import co.yedam.vo.BoardVO;
import co.yedam.vo.MemberVO;

//업무프로세스를 따라 실행하기 위한 서비스
public class BoardServiceImpl implements BoardService{
	
	SqlSession sqlSession =  DataSource.getInstance().openSession(true);
	
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	@Override
	public List<BoardVO> boardList(SearchVO search) {
		//mapper에 등록된 기능활용
		return mapper.boardListpaging(search);
	}

	@Override
	public int boardTotal(SearchVO search) {

		return mapper.getTotalCnt(search);
	}
	
	@Override
	public BoardVO getBoard(int bno) {
		return mapper.selectBoard(bno);
	}

	@Override
	public boolean addBoard(BoardVO bvo) {
		return mapper.insertBoard(bvo) == 1;
	}

	@Override
	public boolean editBoard(BoardVO bvo) {
		
		return mapper.updateBoard(bvo)==1;
	}

	@Override
	public boolean removeBoard(int bno) {
		return mapper.deleteBoard(bno)==1;
	}
	@Override
	public MemberVO checkMember(String id, String pw) {
		return mapper.selectMember(id, pw);
	}
	
	@Override
	public boolean insertMember(String name, String id, String pw) {
		return mapper.createMember(name, id, pw) == 1;
	}
	@Override
	public List<MemberVO> memberList() {
		return mapper.memberList();
	}
	@Override
	public boolean addMemberAjax(MemberVO mvo) {
		return mapper.insertMemberAjax(mvo) == 1;
	}
	@Override
	public boolean checkMemberId(String id) {
		return mapper.selectMemberAjax(id) == 1;
	}
	
	@Override
	public boolean delMemberId(MemberVO mvo) {
		return mapper.delMemberAjax(mvo) == 1;
	}
	@Override
	public boolean delMemberId2(MemberVO mvo) {
		// TODO Auto-generated method stub
		return mapper.delMemberAjax2(mvo) == 1;
	}
	
	@Override
	public boolean updateMember(MemberVO mvo) {
		return mapper.updateMemberAjax(mvo) == 1;
	}
}
