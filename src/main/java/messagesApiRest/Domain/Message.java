package messagesApiRest.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;


import javax.persistence.*;
import java.time.LocalDateTime;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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


    @ManyToOne
    private Label label;


    @ManyToOne
    private User user;




}

