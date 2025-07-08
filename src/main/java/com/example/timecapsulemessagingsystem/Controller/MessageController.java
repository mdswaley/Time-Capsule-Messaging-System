package com.example.timecapsulemessagingsystem.Controller;

import com.example.timecapsulemessagingsystem.DTO.MessageDto;

import com.example.timecapsulemessagingsystem.Entity.MessageData;
import com.example.timecapsulemessagingsystem.Service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/message")
public class MessageController {
    private final MessageService messageService;

    @PostMapping("/schedule")
    public ResponseEntity<String> sendMessage(@RequestBody MessageDto messageDto){
        return ResponseEntity.ok(messageService.sendMessage(messageDto));
    }

    @GetMapping
    public ResponseEntity<List<MessageData>> getAllMessage(){
        return ResponseEntity.ok(messageService.getAllMessage());
    }
}
