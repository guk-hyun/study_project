package com.study.study_project.mapper;

import com.study.study_project.domain.dto.Criteria;
import com.study.study_project.domain.dto.ReplyDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
	//insert
	int insertReply(ReplyDTO reply);
	
	//update
	int updateReply(ReplyDTO reply);
	
	//delete
	int deleteReply(Long replyNum);
	int deleteByBoardnum(Long boardNum);
	
	//select
	Long getLastNum(String userid);
	int getTotal(Long boardNum);
	List<ReplyDTO> getList(Criteria cri, Long boardNum);
	int getRecentReply(Long boardNum);
}








