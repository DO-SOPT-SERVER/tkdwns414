package com.server.sopt.seminar.entity;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@Embeddable
@Getter
@EqualsAndHashCode // equals, hashcode 메소드 자동 생성
public class CategoryId implements Serializable {

    private String categoryId;
}