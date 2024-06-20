package service;

import java.util.List;

import co.yedam.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> replyList(int boardNo);
	ReplyVO getReply(int replyNo);
	boolean registReply(ReplyVO rvo);
	boolean removeReply(int replyNo);
}
