package com.server.sopt.seminar.service;

import com.server.sopt.seminar.dto.request.member.MemberCreateRequest;
import com.server.sopt.seminar.dto.request.member.MemberSOPTUpdateRequest;
import com.server.sopt.seminar.dto.response.member.MemberGetResponse;
import com.server.sopt.seminar.entity.Member;
import com.server.sopt.seminar.entity.SOPT;
import com.server.sopt.seminar.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberGetResponse getMemberByIdV1(Long memberId) {
        Member member = memberRepository.findById(memberId).get(); // NullPointException 발생 가능성 있음
        return MemberGetResponse.of(member);
    }

    public MemberGetResponse getMemberByIdV2(Long memberId){
        return MemberGetResponse.of(memberRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("해당하는 회원이 없습니다.")));
    }

    public MemberGetResponse getMemberByIdV3(Long memberId){
        return MemberGetResponse.of(memberRepository.findByIdOrThrow(memberId));
    }

    @Transactional
    public String create(MemberCreateRequest request){
        Member member = memberRepository.save(Member.builder()
                .name(request.name())
                .nickname(request.nickname())
                .age(request.age())
                .sopt(request.sopt())
                .build());
        return member.getId().toString();
    }

    public List<MemberGetResponse> getMembers(){
        return memberRepository.findAll()
                .stream()
                .map(MemberGetResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateSOPT(Long memberId, MemberSOPTUpdateRequest request){
        Member member = memberRepository.findByIdOrThrow(memberId);
        member.updateSOPT(new SOPT(request.generation(), request.part()));
    }

    @Transactional
    public void deleteMember(Long memberId){
        Member member = memberRepository.findByIdOrThrow(memberId);
        memberRepository.delete(member);
    }

    // 28번 줄에서는 interface에서 default로 만든 메소드를 사용했지만이렇게 private 메소드를 Service 내부에 만들어서 써도 됨
    private Member findById(Long memberId){
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 회원이 없습니다."));
    }
}
