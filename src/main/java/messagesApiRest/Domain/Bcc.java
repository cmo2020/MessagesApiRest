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
@Table(name = "bcc")
public class Bcc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String bccOne;
    @Column
    private String bccTwo;
    @Column
    private String bccThree;


    @OneToMany (mappedBy = "bcc")
    private Set<Message> message = new HashSet<>();

}
