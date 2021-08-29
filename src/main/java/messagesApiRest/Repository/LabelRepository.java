package messagesApiRest.Repository;

import messagesApiRest.Domain.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {

    public  String deleteByLabelName (String labelName);
    public Set<Label> findByLabelName (String labelName);
}
