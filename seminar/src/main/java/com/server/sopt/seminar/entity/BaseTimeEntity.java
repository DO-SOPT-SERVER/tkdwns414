package com.server.sopt.seminar.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass // JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 아래 필드들도 컬럼으로 인식하도록 함
@EntityListeners(value = AuditingEntityListener.class) // 엔티티의 생명주기 이벤트를 처리하는 리스너, Auditing 활성화 필요
public abstract class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
