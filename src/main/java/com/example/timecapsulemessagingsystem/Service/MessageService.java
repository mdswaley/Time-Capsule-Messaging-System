package com.example.timecapsulemessagingsystem.Service;

import com.example.timecapsulemessagingsystem.DTO.MessageDto;
import com.example.timecapsulemessagingsystem.Entity.MessageData;
import com.example.timecapsulemessagingsystem.Repository.MessageRepo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MessageService {

    private final MessageRepo messageRepo;
    private final ModelMapper modelMapper;

    public MessageDto addMessage(MessageDto messageDto) {
        MessageData messageData = modelMapper.map(messageDto,MessageData.class);
        MessageData save = messageRepo.save(messageData);
        return modelMapper.map(save,MessageDto.class);
    }

    public String sendMessage(MessageDto messageDto){
        if (messageDto.getMessage() == null || messageDto.getMessage().trim().isEmpty()) {
            throw new RuntimeException("Message cannot be empty.");
        }
        MessageData messageData = modelMapper.map(messageDto, MessageData.class);
        messageRepo.save(messageData);

        return "Message sent to " + messageDto.getReceiverName();
    }
}
