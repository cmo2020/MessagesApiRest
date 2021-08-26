package messagesApiRest.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "message")
public  class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String subject;
    @Column
    private String body;
    @Lob
    @Column(name = "attachment", columnDefinition="BLOB")
    private byte[] attachment;
    @Column
    private String receptor;
    @Column
    private String cc;
    @Column
    private String bcc;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "message")
    private Set<Label> label = new HashSet<>();

    @ManyToOne
    private User user;



}

