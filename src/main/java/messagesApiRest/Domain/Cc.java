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
@Table(name = "cc")
public class Cc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ccOne;
    @Column
    private String ccTwo;
    @Column
    private String ccThree;



    @OneToMany(mappedBy = "cc")
    private Set<Message> message = new HashSet<>();
}
