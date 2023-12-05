package com.server.sopt.seminar.repository;

import com.server.sopt.seminar.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    default Post findByIdOrThrow(Long postId){
        return findById(postId).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
    }

    List<Post> findAllByMemberId(Long memberId);
}
