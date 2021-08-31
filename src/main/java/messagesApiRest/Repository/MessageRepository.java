package messagesApiRest.Repository;

import messagesApiRest.Domain.Message;
import messagesApiRest.Domain.User;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional(readOnly = true)
public interface MessageRepository extends JpaRepository <Message, Long> {


    @Query(value = "SELECT * FROM message WHERE recipient OR bcc OR cc IN(SELECT email FROM user)ORDER BY date DESC", nativeQuery = true)
    List<Message> findByRecipient(String email);





}
