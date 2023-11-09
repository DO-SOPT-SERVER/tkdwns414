package com.server.sopt.seminar.dto.response.post;

import com.server.sopt.seminar.dto.response.category.CategoryResponse;
import com.server.sopt.seminar.entity.Category;
import com.server.sopt.seminar.entity.Post;

public record PostGetResponse(
        Long id,
        String title,
        String content,
        CategoryResponse category
){
    public static PostGetResponse of (Post post, Category category){
        return new PostGetResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                CategoryResponse.of(category)
        );
    }

}
