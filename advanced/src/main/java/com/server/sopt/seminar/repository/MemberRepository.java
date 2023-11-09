package com.server.sopt.seminar.repository;

import com.server.sopt.seminar.entity.Member;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    default Member findByIdOrThrow (Long memberId) { // default 붙여서 interface에서 메소드 구현 가능
        return findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 회원이 없습니다."));
    }
}
