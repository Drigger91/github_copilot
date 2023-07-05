package com.personal.github_copilot.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.personal.github_copilot.service.AdminService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController("/admin")
public class AdminController {
    private final AdminService adminService;
    @Data
    public static class AdminDto{
        private String username;
        private String password;
        private String email;
        private String phone;
        private String orgainzation;

    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
    @PostMapping("/register")
    public ResponseEntity<JsonNode> register(AdminDto adminDto) {
        return ResponseEntity.ok(adminService.register(adminDto));
    }

}
