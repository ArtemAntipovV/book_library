package com.example.library.controller;


import com.example.library.component.JwtUtils;
import com.example.library.model.Employee;
import com.example.library.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JwtUtils jwtUtils;

    // 1) Метод логина: возвращает access token (10 минут) + refresh token (30 минут)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String login, @RequestParam String password) {
        Optional<Employee> optionalEmployee = employeeService.findByLogin(login);
        if (optionalEmployee.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid login or password");
        }
        Employee employee = optionalEmployee.get();
        // Сравнить пароль (в идеале нужно хранить хэш пароля и проверять его)
        if (!employee.getPassword().equals(password)) {
            return ResponseEntity.badRequest().body("Invalid login or password");
        }

        String accessToken = jwtUtils.generateAccessToken(login);
        String refreshToken = jwtUtils.generateRefreshToken(login);

        Map<String, String> tokens = new HashMap<>();
        tokens.put("accessToken", accessToken);
        tokens.put("refreshToken", refreshToken);
        return ResponseEntity.ok(tokens);
    }

    // 2) Получение нового access token по refresh token
    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestParam String refreshToken) {
        // Проверяем валидность refresh token
        if (!jwtUtils.validateToken(refreshToken)) {
            return ResponseEntity.badRequest().body("Invalid refresh token");
        }

        String login = jwtUtils.getLoginFromToken(refreshToken);
        // Генерируем новый access token
        String newAccessToken = jwtUtils.generateAccessToken(login);

        Map<String, String> tokens = new HashMap<>();
        tokens.put("accessToken", newAccessToken);
        tokens.put("refreshToken", refreshToken); // refreshToken можно переиспользовать или выдать новый
        return ResponseEntity.ok(tokens);
    }
}
