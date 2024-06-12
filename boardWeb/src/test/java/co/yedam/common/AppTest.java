package co.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.BoardMapper;
import co.yedam.vo.BoardVO;
import service.BoardService;
import service.BoardServiceImpl;


public class AppTest {
	public static void main(String[] args) {
		//여긴 테스트 하려고 하는곳
//		SqlSessionFactory sqlSessionFactroy =  DataSource.getInstance();
//		SqlSession sqlSession = sqlSessionFactroy.openSession(); //db에 접속해서 쿼리를 실행하는것 sqlSession
//		
//		//interface 구현객체
//		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);//객체, 인터페이스
//		
//		List<BoardVO> list = mapper.boardListpaging(1);
//		
//		for(BoardVO bvo : list) {
//			System.out.println(bvo.toString());
//		}
		BoardService svc = new BoardServiceImpl();
		
		System.out.println(svc.getBoard(100));
	}
}
