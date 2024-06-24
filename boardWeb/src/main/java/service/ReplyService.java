package service;

import java.util.List;
import java.util.Map;

import co.yedam.common.CenterVO;
import co.yedam.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> replyList(int boardNo, int page);
	ReplyVO getReply(int replyNo);
	boolean registReply(ReplyVO rvo);
	boolean removeReply(int replyNo);
	
	//댓글 건수
	int getTotalCount(int bno);
	
	//센터정보 생성
	int createCenterInfo(CenterVO[] array);
	
	//차트
	List<Map<String, Object>> centerList();
}
