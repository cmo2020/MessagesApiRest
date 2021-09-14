package messagesApiRest.Domain;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "recipient")
public class Recipients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String recipientOne;
    @Column
    private String recipientTwo;
    @Column
    private String recipientThree;




    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipient")
    private Set<Message> message = new HashSet<>();

}
