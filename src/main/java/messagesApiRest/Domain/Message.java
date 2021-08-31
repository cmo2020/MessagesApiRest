package messagesApiRest.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
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
    private String deriveFrom;
    @Column
    private String subject;
    @Column
    private String recipient;
    @Column
    private String cc;
    @Column
    private String bcc;
    @Column
    private String body;
    @Lob
    @Column(name = "attachment", columnDefinition="BLOB")
    private byte[] attachment;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;




    @OneToMany(cascade = CascadeType.ALL, mappedBy = "message" )
    private Set<Label> label = new HashSet<>();

    @ManyToOne
    private User user;


    public Message addLabel(Label label) {
        label.setMessage(this);
        this.label.add(label);
        return  this;
    }
}

