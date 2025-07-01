package com.example.timecapsulemessagingsystem.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MessageData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String senderName;

    private String receiverEmail;

    @Enumerated(value = EnumType.STRING)
    private StatusOfMessage statusOfMessage = StatusOfMessage.PENDING;

    private LocalDateTime dateTime;

    private String message;
}
