package com.personal.github_copilot.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.github_copilot.controller.AdminController;
import com.personal.github_copilot.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService {
    private final ObjectMapper objectMapper;

    public JsonNode register(AdminController.AdminDto adminDto) {
        var resultNode = objectMapper.createObjectNode();
        if (!validateAdminFromAdminDto(adminDto)) {
            resultNode.put("status", "error");
            resultNode.put("message", "Invalid admin data");
            return resultNode;
        }
        resultNode.put("status", "success");
        resultNode.put("message", "Admin registered successfully");
        return resultNode;
    }

    private boolean validateAdminFromAdminDto(AdminController.AdminDto adminDto) {
        if (Utils.StringUtil.isBadString(adminDto.getUsername())) {
            return false;
        }
        if (Utils.StringUtil.isBadString(adminDto.getPassword()) || adminDto.getPassword().length() < 8) {
            return false;
        }
        if (Utils.StringUtil.isBadString(adminDto.getEmail()) || !Utils.StringUtil.isValidEmail(adminDto.getEmail())) {
            return false;
        }
        if (Utils.StringUtil.isBadString(adminDto.getPhone())) {
            return false;
        }
        if (Utils.StringUtil.isBadString(adminDto.getOrgainzation())) {
            return false;
        }
        return true;
    }
}
