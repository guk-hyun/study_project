package com.study.study_project.domain.dto;

import lombok.Data;

@Data
public class MessageDTO {
    private long messageNum;
    private String messageCategory;
    private String messageContent;
    private String sendId;
    private String receiveId;
    private String messageRegdate;
}
