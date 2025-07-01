package com.example.timecapsulemessagingsystem.Repository;

import com.example.timecapsulemessagingsystem.Entity.MessageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends JpaRepository<MessageData, Long> {
}
