package com.study.study_project.domain.dto;

import lombok.Data;

@Data
public class ReplyDTO {
	private Long replyNum;
	private String userId;
	private Long boardCategory;
	private Long boardNum;
	private String replyContents;
	private String replyRegdate;
	private String replyUpdate;
}
