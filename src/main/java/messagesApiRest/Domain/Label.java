package messagesApiRest.Domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "label")
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String labelName;

    @ManyToOne
    private Message message;

}
