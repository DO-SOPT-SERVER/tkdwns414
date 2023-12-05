package com.server.sopt.seminar.dto.request.servicemember;

public record ServiceMemberRequest(
        String nickname,
        String password
) {
}