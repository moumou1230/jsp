package service;

import java.util.List;

import co.yedam.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> replyList(int boardNo, int page);
	ReplyVO getReply(int replyNo);
	boolean registReply(ReplyVO rvo);
	boolean removeReply(int replyNo);
	
	//댓글 건수
	int getTotalCount(int bno);
}
