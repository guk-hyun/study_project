package com.study.study_project.domain.dto;

import lombok.Data;

@Data
public class BoardDTO {
	private Long boardNum;
	private String userId;
	private String boardTitle;
	private String boardCategory;
	private String boardContent;
	private String boardRegdate;
	private String boardUpdate;
	private int boardViewcnt;
	private int boardBookmarkcnt;
}
