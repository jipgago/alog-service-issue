package kea.alog.issue.controller.dto;

import lombok.Getter;

@Getter
public class TokenPayloadDto {
    private String userNN;
    private String userEmail;
    private Long userPk;
    private Long iat;
    private Long exp;
}