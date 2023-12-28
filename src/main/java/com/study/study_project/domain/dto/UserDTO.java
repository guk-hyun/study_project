package com.study.study_project.domain.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    private String userid;
    private String userpw;
    private String username;
    private String usernickname;
    private String userbirth;
    private String usergender;
    private String userinterest;
    private LocalDateTime userjoindate;
}

//아이디(중복 x)
//비밀번호
//닉네임(중복x -> 수정횟수 제한)
//이름
//나이(생년월일)
//성별
//관심요리(한식,중식,양식,일식,디저트)
//가입일자
