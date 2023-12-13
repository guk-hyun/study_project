package com.study.study_project.domain.dto;

import lombok.Data;

@Data
public class BoardDTO {
	private Long boardnum;
	private String boardtitle;
	private String boardcontents;
	private String regdate;
	private String updatedate;
	private int readcount;
	private String userid;
}
