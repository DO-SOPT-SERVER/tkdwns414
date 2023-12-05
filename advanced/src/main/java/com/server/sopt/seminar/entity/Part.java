package com.server.sopt.seminar.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Part {
    SERVER("서버"),
    WEB("웹"),
    ANDROID("안드로이드"),
    IOS("IOS"),
    PLAN("기획"),
    DESIGN("디자인");

    private final String name;
}