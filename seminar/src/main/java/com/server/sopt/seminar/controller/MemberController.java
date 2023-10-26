package com.server.sopt.seminar.controller;

import com.server.sopt.seminar.dto.request.MemberCreateRequest;
import com.server.sopt.seminar.dto.response.MemberGetResponse;
import com.server.sopt.seminar.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberGetResponse> getMemberProfileV1(@PathVariable Long memberId){
        return ResponseEntity.ok(memberService.getMemberByIdV1(memberId));
    }

    @GetMapping("/{memberId}/v2")
    public ResponseEntity<MemberGetResponse> getMemberProfileV2(@PathVariable Long memberId){
        return ResponseEntity.ok(memberService.getMemberByIdV2(memberId));
    }

    @GetMapping("/{memberId}/v3")
    public ResponseEntity<MemberGetResponse> getMemberProfileV3(@PathVariable Long memberId){
        return ResponseEntity.ok(memberService.getMemberByIdV3(memberId));
    }

    @PostMapping
    public ResponseEntity<Void> createMember(@RequestBody MemberCreateRequest request){
        URI location = URI.create(memberService.create(request));
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<MemberGetResponse>> getMembersProfile(){
        return ResponseEntity.ok(memberService.getMembers());
    }
}
