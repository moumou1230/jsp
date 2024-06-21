package co.yedam.common;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.ReplyMapper;
import co.yedam.vo.ReplyVO;

public class AppTest {
	public static void main(String[] args) {
		// 여긴 테스트 하려고 하는곳
		SqlSessionFactory sqlSessionFactroy = DataSource.getInstance();
		SqlSession sqlSession = sqlSessionFactroy.openSession(); // db에 접속해서 쿼리를 실행하는것 sqlSession
//		
		// interface 구현객체
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);// 객체, 인터페이스
		mapper.selectListPaging(162, 6).forEach(reply -> System.out.println(reply));// 162번글의 댓글 1페이지 보겠다
	}
}
