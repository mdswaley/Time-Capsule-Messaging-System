package com.example.timecapsulemessagingsystem.DTO;

import com.example.timecapsulemessagingsystem.Entity.StatusOfMessage;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDto {
    private String senderName;
    private String receiverEmail;
    private LocalDateTime dateTime;
    private String message;
}
