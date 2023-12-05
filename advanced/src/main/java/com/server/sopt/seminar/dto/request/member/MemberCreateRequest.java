package com.server.sopt.seminar.dto.request.member;

import com.server.sopt.seminar.entity.SOPT;

public record MemberCreateRequest(
        String name,
        String nickname,
        int age,
        SOPT sopt
) {

}
