package com.server.sopt.seminar.dto.request;

import com.server.sopt.seminar.entity.SOPT;
import lombok.Data;

@Data
public class MemberCreateRequest {
    private String name;
    private String nickname;
    private int age;
    private SOPT sopt;
}
