package com.server.sopt.seminar.service;

import com.server.sopt.seminar.dto.request.post.PostCreateRequest;
import com.server.sopt.seminar.dto.request.post.PostUpdateRequest;
import com.server.sopt.seminar.dto.response.post.PostGetResponse;
import com.server.sopt.seminar.entity.Member;
import com.server.sopt.seminar.entity.Post;
import com.server.sopt.seminar.repository.MemberRepository;
import com.server.sopt.seminar.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public String create(Long memberId, PostCreateRequest request){
        Post post = Post.builder()
                .member(memberRepository.findByIdOrThrow(memberId))
                .title(request.title())
                .content(request.content())
                .build();
        Post savedPost = postRepository.save(post);
        return savedPost.getId().toString();
    }

    public List<PostGetResponse> getPosts(Long memberId) {
        return postRepository.findAllByMemberId(memberId)
                .stream()
                .map(PostGetResponse::of)
                .toList();
    }

    public PostGetResponse getPost(Long postId){
        return PostGetResponse.of(postRepository.findByIdOrThrow(postId));
    }

    @Transactional
    public void editContent(Long postId, PostUpdateRequest request) {
        Post post = postRepository.findByIdOrThrow(postId);
        post.updateContent(request.content());
    }

    @Transactional
    public void deleteById(Long postId) {
        Post post = postRepository.findByIdOrThrow(postId);
        postRepository.delete(post);
    }
}