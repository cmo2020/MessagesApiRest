package messagesApiRest.Repository;


import messagesApiRest.Domain.Label;
import messagesApiRest.Domain.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional(readOnly = true)
public interface MessageRepository extends JpaRepository <Message, Long> {


    @Query(value = "SELECT * FROM message WHERE recipient OR bcc OR cc IN(SELECT email FROM user)ORDER BY date DESC", nativeQuery = true)
    Page <Message> findByRecipient(Message message, Pageable pageable);

    @Query(value = "SELECT * FROM message WHERE derive_from IN(SELECT email FROM user)ORDER BY date DESC", nativeQuery = true)
    Page<Message> findBySender(Message message, Pageable pageable);

    @Query(value = "SELECT * FROM message WHERE label_id IN (SELECT label_id FROM label) ORDER BY date DESC", nativeQuery = true)
    Page<Message> filterByLabel (Long labelId, Pageable pageable);




}
