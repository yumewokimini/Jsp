package co.yedom.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.ReplyMapper;
import co.yedam.vo.CenterVO;
import co.yedam.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService{

	SqlSession sqlSession 
	= DataSource.getInstance().openSession(true);//자동 커밋	
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class); 
	
	@Override
	public List<ReplyVO> replyList(int boardNo, int page) {
		return mapper.selectListPaging(boardNo,page);
	}
	
	@Override
	public ReplyVO getReply(int replyNo) {
		return mapper.selectReply(replyNo);
	}
	
	@Override
	public boolean registerReply(ReplyVO rvo) {
		return mapper.insertReply(rvo) == 1;
	}
	
	@Override
	public boolean removerReply(int replyNo) {
		return mapper.deleteReply(replyNo) == 1;
	}
	
	@Override
	public int getTotalCount(int bno) {
		return mapper.selectReplyCnt(bno);//?
	}
	
	@Override
	public int createCenterInfo(CenterVO[] array) {
		// TODO Auto-generated method stub
		return mapper.insertCenter(array);
	}
	
	@Override
	public List<Map<String, Object>> centerList() {
		// TODO Auto-generated method stub
		return mapper.centerBysido();
	}
}
