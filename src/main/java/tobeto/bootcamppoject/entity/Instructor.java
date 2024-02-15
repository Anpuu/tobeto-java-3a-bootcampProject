package tobeto.bootcamppoject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tobeto.bootcamppoject.core.entities.MyUser;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="instructors")
@Entity
@EqualsAndHashCode(callSuper = true)
public class Instructor extends MyUser<Integer> {

    @Column(name = "companyName")
    private String companyName;
}
