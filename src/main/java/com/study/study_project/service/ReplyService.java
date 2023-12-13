package com.study.study_project.service;

import com.study.study_project.domain.dto.Criteria;
import com.study.study_project.domain.dto.ReplyDTO;
import com.study.study_project.domain.dto.ReplyPageDTO;

public interface ReplyService {
	boolean regist(ReplyDTO reply);
	
	boolean modify(ReplyDTO reply);
	
	boolean remove(Long replynum);
	
	ReplyPageDTO getList(Criteria cri, Long boardnum);
	
	Long getLastNum(String userid);
}
