package messagesApiRest.Repository;

import messagesApiRest.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {



   User findByUserName(String userName);
   Optional<User> findByEmail (String email);
   User getUserById(Long id);


}
