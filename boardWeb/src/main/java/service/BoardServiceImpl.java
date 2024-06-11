package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.BoardMapper;
import co.yedam.vo.BoardVO;

//업무프로세스를 따라 실행하기 위한 서비스
public class BoardServiceImpl implements BoardService{
	
	SqlSession sqlSession =  DataSource.getInstance().openSession(true);
	
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	@Override
	public List<BoardVO> boardList() {
		//mapper에 등록된 기능활용
		return mapper.boardList();
	}

	@Override
	public BoardVO getBoard(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addBoard(BoardVO bvo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editBoard(BoardVO bvo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeBoard(int bno) {
		// TODO Auto-generated method stub
		return false;
	}

}
