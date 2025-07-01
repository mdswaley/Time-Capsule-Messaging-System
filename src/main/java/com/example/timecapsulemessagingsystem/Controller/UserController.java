package com.example.timecapsulemessagingsystem.Controller;

import com.example.timecapsulemessagingsystem.Entity.UserEntity;
import com.example.timecapsulemessagingsystem.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user/addUser")
    public ResponseEntity<String> adduser(@RequestBody UserEntity userEntity){
        return ResponseEntity.ok(userService.addUser(userEntity));
    }
}
