package com.example.timecapsulemessagingsystem.Service;

import com.example.timecapsulemessagingsystem.DTO.MessageDto;
import com.example.timecapsulemessagingsystem.Entity.MessageData;
import com.example.timecapsulemessagingsystem.Entity.StatusOfMessage;
import com.example.timecapsulemessagingsystem.Entity.UserEntity;
import com.example.timecapsulemessagingsystem.Repository.MessageRepo;
import com.example.timecapsulemessagingsystem.Repository.UserRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MessageService {

    private final MessageRepo messageRepo;
    private final ModelMapper modelMapper;
    private final UserRepo userRepo;

    public MessageDto addMessage(MessageDto messageDto) {
        MessageData messageData = modelMapper.map(messageDto,MessageData.class);
        MessageData save = messageRepo.save(messageData);
        return modelMapper.map(save,MessageDto.class);
    }

    public String sendMessage(MessageDto messageDto){
        if (messageDto.getMessage() == null || messageDto.getMessage().trim().isEmpty()) {
            throw new RuntimeException("Message cannot be empty.");
        }

        Optional<UserEntity> receiverOpt = userRepo.findByEmail(messageDto.getReceiverEmail());
        if (receiverOpt.isEmpty()) {
            return "Receiver does not exist.";
        }

        MessageData messageData = modelMapper.map(messageDto, MessageData.class);
        messageData.setStatusOfMessage(StatusOfMessage.PENDING);
        messageRepo.save(messageData);

        return "Message sent to " + receiverOpt.get().getName();
    }

    @Scheduled(fixedRate = 60 * 1000)
    public void processPendingMessages() {
        ZoneId zone = ZoneId.of("Asia/Kolkata");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("=== Scheduler running at: " + now + " (" + zone + ") ===");

        var pendingMessages = messageRepo.findByStatusOfMessageAndDateTimeBefore(StatusOfMessage.PENDING, now);
        System.out.println("Found pending messages: " + pendingMessages.size());

        for (MessageData msg : pendingMessages) {
            System.out.println("Delivering message to receiverId " + msg.getId()
                    + ": " + msg.getMessage());

            msg.setStatusOfMessage(StatusOfMessage.SENT);
            messageRepo.save(msg);
        }
    }


}
