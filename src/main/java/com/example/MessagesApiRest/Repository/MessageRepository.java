package com.example.MessagesApiRest.Repository;

import com.example.MessagesApiRest.Domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository <Message, Long> {
}
