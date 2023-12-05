package com.server.sopt.seminar.service;

import com.server.sopt.seminar.dto.request.servicemember.ServiceMemberRequest;
import com.server.sopt.seminar.dto.response.servicemember.ServiceMemberResponse;
import com.server.sopt.seminar.entity.ServiceMember;
import com.server.sopt.seminar.repository.ServiceMemberRepository;
import com.server.sopt.seminar.security.jwt.JwtTokenProvider;
import com.server.sopt.seminar.security.jwt.UserAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ServiceMemberService {

    private final ServiceMemberRepository serviceMemberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public String create(ServiceMemberRequest request) {
        ServiceMember serviceMember = ServiceMember.builder()
                .nickname(request.nickname())
                .password(passwordEncoder.encode(request.password()))
                .build();
        serviceMemberRepository.save(serviceMember);

        return serviceMember.getId().toString();
    }

    public ServiceMemberResponse signIn(ServiceMemberRequest request) {
        ServiceMember serviceMember = serviceMemberRepository.findByNickname(request.nickname())
                .orElseThrow(() -> new RuntimeException("해당하는 회원이 없습니다."));
        if (!passwordEncoder.matches(request.password(), serviceMember.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
        return ServiceMemberResponse.builder()
                .accessToken(jwtTokenProvider.generateToken(
                        new UserAuthentication(serviceMember.getId(), null, null), 60 * 60 * 24 * 14L))
                .build();
    }

}