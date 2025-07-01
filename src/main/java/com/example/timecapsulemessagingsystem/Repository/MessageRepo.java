package com.example.timecapsulemessagingsystem.Repository;

import com.example.timecapsulemessagingsystem.DTO.MessageDto;
import com.example.timecapsulemessagingsystem.Entity.MessageData;
import com.example.timecapsulemessagingsystem.Entity.StatusOfMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepo extends JpaRepository<MessageData, Long> {
    List<MessageData> findByStatusOfMessageAndDateTimeBefore(StatusOfMessage statusOfMessage, LocalDateTime dateTimeBefore);
}
