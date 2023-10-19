package com.server.sopt.seminar.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
public class ApiResponse<T> {
    private final int code;
    private final String status;
    private final boolean success;

    @JsonInclude(JsonInclude.Include.NON_NULL) // null 값은 결과값에 포함하지 않도록 설정
    private T data;

    public ApiResponse(int code, String status, boolean success) {
        this.code = code;
        this.status = status;
        this.success = success;
    }

    public ApiResponse(int code, String status, boolean success, T data) {
        this.code = code;
        this.status = status;
        this.success = success;
        this.data = data;
    }
}
