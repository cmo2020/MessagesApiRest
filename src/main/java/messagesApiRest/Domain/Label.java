package messagesApiRest.Domain;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "label")
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String labelName;



    @OneToMany
    @JoinTable(name = "label_message", joinColumns = @JoinColumn(name = "label_id"),
            inverseJoinColumns = @JoinColumn(name = "message_id"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Message> message = new HashSet<>();





}
