package com.server.sopt.seminar.dto;

import lombok.Getter;

@Getter // ResponseEntity에 넣으려면 Getter 필요
public class HealthCheckResponse {
    private static final String STATUS = "OK";
    private final String status;

    public HealthCheckResponse() {
        this.status = STATUS;
    }
}
