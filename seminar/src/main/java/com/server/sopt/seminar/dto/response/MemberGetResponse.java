package com.server.sopt.seminar.dto.response;

import com.server.sopt.seminar.entity.Member;
import com.server.sopt.seminar.entity.SOPT;

public record MemberGetResponse(String name, String nickname, int age, SOPT sopt){
    public static MemberGetResponse of(Member member){
        return new MemberGetResponse(
                member.getName(),
                member.getNickname(),
                member.getAge(),
                member.getSopt()
        );
    }
}
