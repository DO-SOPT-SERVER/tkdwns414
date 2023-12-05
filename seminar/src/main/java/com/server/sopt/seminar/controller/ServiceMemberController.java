package com.server.sopt.seminar.controller;

import com.server.sopt.seminar.dto.request.servicemember.ServiceMemberRequest;
import com.server.sopt.seminar.dto.response.servicemember.ServiceMemberResponse;
import com.server.sopt.seminar.service.ServiceMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/")
public class ServiceMemberController {

    private final ServiceMemberService serviceMemberService;

    @PostMapping("sign-up")
    public ResponseEntity<Void> signUp(@RequestBody ServiceMemberRequest request) {
        URI location = URI.create(serviceMemberService.create(request));
        return ResponseEntity.created(location).build();
    }

    @PostMapping("sign-in")
    public ResponseEntity<ServiceMemberResponse> signIn(@RequestBody ServiceMemberRequest request) {
        return ResponseEntity.ok().body(serviceMemberService.signIn(request));
    }
}
