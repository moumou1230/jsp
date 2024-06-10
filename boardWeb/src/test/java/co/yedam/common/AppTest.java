package co.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.StudentMapper;
import co.yedam.vo.Student;

public class AppTest {
	public static void main(String[] args) {
		//여긴 테스트 하려고 하는곳
		SqlSessionFactory sqlSessionFactroy =  DataSource.getInstance();
		SqlSession sqlSession = sqlSessionFactroy.openSession(); //db에 접속해서 쿼리를 실행하는것 sqlSession
		
		//interface 구현객체
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);//객체, 인터페이스
		
		
		Student std = new Student();
//		std.setStdNo("S0010");
//		std.setStdName("김영식");
//		std.setPhone("010-9876-5432");
//		std.setBldType("B");
//		
//		sqlSession.insert("co.yedam.mapper.StudentMapper.insertStudent", std);
//		sqlSession.commit();
		
		
		std.setStdNo("S0010");
		std.setPhone("010-7777-7777");
		
//		sqlSession.update("co.yedam.mapper.StudentMapper.updateStudent", std);
		mapper.updateStudent(std);
		sqlSession.commit();
		
		List<Student> list //= sqlSession.selectList("co.yedam.mapper.StudentMapper.selectBlog");
						= mapper.selectBlog();
		for(Student std1 : list) {
			System.out.println(std1.toString());
		}
	}
}
