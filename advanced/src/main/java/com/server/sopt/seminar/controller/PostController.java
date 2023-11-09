package com.server.sopt.seminar.controller;

import com.server.sopt.seminar.dto.request.post.PostCreateRequest;
import com.server.sopt.seminar.dto.request.post.PostUpdateRequest;
import com.server.sopt.seminar.dto.response.post.PostGetResponse;
import com.server.sopt.seminar.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    private static final String CUSTOM_AUTH_ID = "X-Auth-Id";

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestHeader(CUSTOM_AUTH_ID) Long memberId,
                                           @RequestBody PostCreateRequest request){
        URI location = URI.create("/api/posts/" + postService.create(memberId, request));
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<PostGetResponse>> getPosts(@RequestHeader(CUSTOM_AUTH_ID) Long memberId){
        return ResponseEntity.ok(postService.getPosts(memberId));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostGetResponse> getPost(@PathVariable Long postId){
        return ResponseEntity.ok(postService.getPost(postId));
    }

    @PatchMapping("/{postId}")
    public ResponseEntity<Void> updatePost(@PathVariable Long postId,
                                           @RequestBody PostUpdateRequest request){
        postService.editContent(postId, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId){
        postService.deleteById(postId);
        return ResponseEntity.noContent().build();
    }

}