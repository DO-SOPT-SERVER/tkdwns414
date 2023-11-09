package com.server.sopt.seminar.dto.request.member;

import com.server.sopt.seminar.entity.Part;

public record MemberSOPTUpdateRequest(
        int generation,
        Part part
) {
}
