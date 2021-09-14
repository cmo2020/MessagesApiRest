package messagesApiRest.Repository;


import messagesApiRest.Domain.*;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;




@Repository
public interface MessageRepository extends JpaRepository <Message, Long> {


    Page<Message> findByRecipient(Recipients recipients,Bcc bcc, Cc cc, Pageable pageable );

    Page<Message> findByDeriveFrom (Message message, Pageable pageable);

    Page<Message> findByLabel( Message message, Long idLabel, Pageable pageable);



}
