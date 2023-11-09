package com.server.sopt.seminar.dto.response.category;

import com.server.sopt.seminar.dto.response.post.PostGetResponse;
import com.server.sopt.seminar.entity.Category;
import com.server.sopt.seminar.entity.Post;

public record CategoryResponse(Short id, String name) {
    public static CategoryResponse of (Category category){
        return new CategoryResponse(
                category.getId(),
                category.getContent()
        );
    }
}
