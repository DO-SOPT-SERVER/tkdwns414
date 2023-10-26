package com.server.sopt.seminar.dto.request;

import com.server.sopt.seminar.entity.SOPT;

public record MemberCreateRequest(
        String name,
        String nickname,
        int age,
        SOPT sopt
) {

}
