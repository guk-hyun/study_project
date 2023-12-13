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
	int deleteReply(Long replynum);
	int deleteByBoardnum(Long boardnum);
	
	//select
	Long getLastNum(String userid);
	int getTotal(Long boardnum);
	List<ReplyDTO> getList(Criteria cri, Long boardnum);
	int getRecentReply(Long boardnum);
}








