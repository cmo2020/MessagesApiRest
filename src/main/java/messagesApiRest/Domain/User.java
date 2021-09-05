package messagesApiRest.Domain;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {


 @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @Column(nullable = false, unique = true, length = 20)
     @NotEmpty(message = "User name is required")
     private String userName;
     @Column(nullable = false,length = 20)
     @NotEmpty(message = "Name is required")
     private String name;
     @Column(nullable = false,  length = 20)
     @NotEmpty(message = "Lastname is required")
     private String lastName;
     @Column(nullable = false,  length = 30)
     @NotEmpty(message = "Email is required") @Pattern(regexp =  "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "Invalid email format")
     private String email;
     @Column(nullable = false,  length = 20)
     @NotEmpty(message = "Address is required")
     private String address;
     @Column
     @NotNull(message = "Zip Code is required")
     private Integer zipcode;
     @Column(nullable = false,  length = 10)
     @NotEmpty(message = "Country is required")
     private String country;
     @Column(nullable = false, length = 10)
     @NotEmpty(message = "State is required")
     private String state;
     @Column(nullable = false)@Lob
     @NotEmpty(message = "Password is required")
     private String password;


     @Enumerated(EnumType.STRING)
     private Role role;



     @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
     private Set<Message> message = new HashSet<>();




}
