package com.example.MessagesApiRest.Repository;

import com.example.MessagesApiRest.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

   User findByUserName(String userName);
}
