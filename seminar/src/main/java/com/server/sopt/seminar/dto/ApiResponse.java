package com.server.sopt.seminar.dto;

import lombok.Getter;

@Getter
public class ApiResponse<T> {
    private final int code;
    private final String status;
    private final boolean success;
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
