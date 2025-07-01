package com.example.timecapsulemessagingsystem.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDto {
    private String senderName;
    private String receiverName;
    private LocalDateTime dateTime;
    private String message;
}
