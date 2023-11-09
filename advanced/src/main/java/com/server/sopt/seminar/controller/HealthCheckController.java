package com.server.sopt.seminar.controller;

import com.server.sopt.seminar.dto.ApiResponse;
import com.server.sopt.seminar.dto.HealthCheckResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @GetMapping("/v1")
    public Map<String, String> healthCheckV1(){
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return response;
    }

    @GetMapping("/v2")
    public ResponseEntity<String> healthCheckV2() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/v3")
    public String healthCheckV3() {
        return "OK";
    }

    @GetMapping("/v4")
    public ResponseEntity<Map<String,String>> healthCheckV4() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v5")
    public ResponseEntity<HealthCheckResponse> healthCheckV5() {
        return ResponseEntity.ok(new HealthCheckResponse()); // 내부에 Getter 필요함
        // ResponseEntuty에서 값을 가져오는 방법이 get~를 사용하기 때문
    }

    @GetMapping("/v6")
    public ApiResponse healthCheckV6() {
        return new ApiResponse<>(200, "OK", true);
    }

    @GetMapping("/v7")
    public ApiResponse<String> healthCheckV7() {
        return new ApiResponse<String>(200, "OK", true, "Hello");
    }
}
