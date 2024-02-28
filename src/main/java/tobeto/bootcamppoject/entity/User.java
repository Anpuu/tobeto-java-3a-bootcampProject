package tobeto.bootcamppoject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tobeto.bootcamppoject.core.entities.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity<Integer>{

    @Column(name = "username")
    private String userName;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "dateofbirth")
    private LocalDateTime dateOfBirth;

    @Column(name = "nationalidentity")
    private  String nationalIdentity;

    @Column(name = "email")
    private  String email;

    @Column(name="password")
    private String password;
}
