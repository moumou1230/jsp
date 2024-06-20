package co.yedam.common;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import co.yedam.mapper.ReplyMapper;
import co.yedam.vo.ReplyVO;



public class AppTest {
	public static void main(String[] args) {
		//여긴 테스트 하려고 하는곳
		SqlSessionFactory sqlSessionFactroy =  DataSource.getInstance();
		SqlSession sqlSession = sqlSessionFactroy.openSession(); //db에 접속해서 쿼리를 실행하는것 sqlSession
//		
		//interface 구현객체
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);//객체, 인터페이스
		//인터페이스에 구현해야할 메소드가 하나만 있는 인터페이스: 함수형인터페이스.
		//mapper.selectList(201).forEach(reply->System.out.println(reply));
		//ReplyVO rvo = mapper.selectReply(2);
		//System.out.println(rvo);
		ReplyVO rvo = new ReplyVO();
//		rvo.setReply("댓글작성 테스트");
//		rvo.setReplyer("admin");
//		rvo.setBoardNo(201);
//		if(mapper.insertReply(rvo) == 1) {
//			System.out.println("입력성공.");
//	}
//		try {
//			if(mapper.insertReply(rvo) == 1) {
//				System.out.println("입력성공.");
//			}
//			
//		} catch (Exception e) {
//			System.out.println("예외발생");
//		}
		
		if(mapper.deleteReply(1)==1) {
			System.out.println("삭제성공");
		}
		mapper.selectList(201).forEach(reply->System.out.println(reply));
	}
}
