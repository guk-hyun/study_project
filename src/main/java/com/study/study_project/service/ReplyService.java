package com.study.study_project.service;

import com.study.study_project.domain.dto.Criteria;
import com.study.study_project.domain.dto.ReplyDTO;
import com.study.study_project.domain.dto.ReplyPageDTO;

public interface ReplyService {
	boolean regist(ReplyDTO reply);
	
	boolean modify(ReplyDTO reply);
	
	boolean remove(Long replyNum);
	
	ReplyPageDTO getList(Criteria cri, Long boardNum);
	
	Long getLastNum(String userId);
}
