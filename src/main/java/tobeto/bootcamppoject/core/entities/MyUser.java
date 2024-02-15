package tobeto.bootcamppoject.core.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class MyUser<T> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private T id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "dateOfBirth")
    private LocalDateTime dateOfBirth;
    @Column(name = "nationalIdentity")
    private  String nationalIdentity;
    @Column(name = "email")
    private  String email;
    @Column(name="password")
    private String password;
}
