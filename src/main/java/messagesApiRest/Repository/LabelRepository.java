package messagesApiRest.Repository;

import messagesApiRest.Domain.Label;
import messagesApiRest.Domain.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {











}
